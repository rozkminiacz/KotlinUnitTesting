package me.rozkmin.mvvm

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.Completable
import io.reactivex.Single
import org.junit.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import strikt.assertions.isFalse
import strikt.assertions.isNull
import strikt.assertions.isTrue

class VenueDetailsViewModelTest {

    @Test
    fun `given repository emits value when start view model then display that value`() {
        val viewModel = createViewModel(
            venueRepository = mock {
                on { getOne(FAKE_ID) } doReturn Single.just(fakeVenue)
            }
        )

        viewModel.start()

        expectThat(viewModel.displayable).isEqualTo(fakeVenue)
    }

    @Test
    fun `given repository emits error when start view model then show error`() {
        val mockErrorCallback: (Throwable) -> Unit = mock()
        val throwable = Throwable("some error")

        val viewModel = createViewModel(
            venueRepository = mock {
                on { getOne(FAKE_ID) } doReturn Single.error(throwable)
            }
        ).apply {
            errorCallback = mockErrorCallback
        }

        viewModel.start()

        verify(mockErrorCallback).invoke(throwable)
    }

    @Test
    fun `given venue favorite call returns favorite when start view model then set favorite`() {
        val viewModel = createViewModel(
            favoriteVenueController = mock {
                on { checkIsFavorite(FAKE_ID) } doReturn Single.just(true)
            }
        )

        viewModel.start()

        expectThat(viewModel.isFavorite).isTrue()
    }

    @Test
    fun `given venue favorite call returns not favorite when start view model then set not favorite`() {
        val viewModel = createViewModel(
            favoriteVenueController = mock {
                on { checkIsFavorite(FAKE_ID) } doReturn Single.just(false)
            }
        )

        viewModel.start()

        expectThat(viewModel.isFavorite).isFalse()
    }

    @Test
    fun `given venue favorite call error when start view model then don't set any value`() {
        val viewModel = createViewModel(
            favoriteVenueController = mock {
                on { checkIsFavorite(FAKE_ID) } doReturn Single.error(Throwable("some error"))
            }
        )

        viewModel.start()

        expectThat(viewModel.isFavorite).isNull()
    }

    @Test
    fun `given mark as favorite click when call completes then change state of favorite`(){
        val viewModel = createViewModel(
            favoriteVenueController = mock {
                on { checkIsFavorite(FAKE_ID) } doReturn Single.never()
                on { markAs(FAKE_ID, true) } doReturn Completable.complete()
            }
        ).apply {
            isFavorite = false
        }

        viewModel.start()

        viewModel.favoriteClick()

        expectThat(viewModel.isFavorite).isTrue()
    }

    @Test
    fun `given mark as favorite click when call error then display error`(){
        val throwable = Throwable("some error")
        val mockErrorCallback: (Throwable) -> Unit = mock()

        val viewModel = createViewModel(
            favoriteVenueController = mock {
                on { checkIsFavorite(FAKE_ID) } doReturn Single.never()
                on { markAs(FAKE_ID, true) } doReturn Completable.error(throwable)
            }
        ).apply {
            isFavorite = false
            errorCallback = mockErrorCallback
        }

        viewModel.start()

        viewModel.favoriteClick()

        verify(mockErrorCallback).invoke(throwable)
    }

    private fun createViewModel(
        venueId: String = FAKE_ID,
        venueRepository: Repository<VenueDisplayable> = mock {
            on { getOne(any()) } doReturn Single.never()
        },
        favoriteVenueController: FavoriteVenueController = mock {
            on { checkIsFavorite(any()) } doReturn Single.never()
        }
    ) = VenueDetailsViewModel(
        venueId = venueId,
        venueRepository = venueRepository,
        favoriteVenueController = favoriteVenueController
    )

    companion object {
        const val FAKE_ID = "fake_id"
        val fakeVenue = VenueDisplayable(
            id = FAKE_ID,
            location = "Fake City, Main Square 1",
            name = "Fake Place"
        )
    }
}