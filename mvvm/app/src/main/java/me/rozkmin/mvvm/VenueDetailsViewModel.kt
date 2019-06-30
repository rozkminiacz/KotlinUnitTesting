package me.rozkmin.mvvm

import android.arch.lifecycle.ViewModel

/**
 * Created by jaroslawmichalik on 2019-06-30
 */
class VenueDetailsViewModel(
    val venueId: String,
    val venueRepository: Repository<VenueDisplayable>,
    val favoriteVenueController: FavoriteVenueController
) : ViewModel() {

    var isFavorite: Boolean? = null

    var displayable: VenueDisplayable? = null

    var errorCallback: (Throwable) -> Unit = {}

    fun start() {
        venueRepository.getOne(venueId)
            .doOnSuccess {
                displayable = it
            }
            .doOnError {
                errorCallback.invoke(it)
            }
            .subscribe()

        favoriteVenueController.checkIsFavorite(venueId)
            .doOnSuccess {
                isFavorite = it
            }
            .doOnError {
                // ignore
            }
            .subscribe()
    }

    fun favoriteClick() {
        isFavorite?.let { favorite ->
            favoriteVenueController.markAs(venueId, !favorite)
                .doOnComplete {
                    isFavorite = !favorite
                }
                .doOnError {
                    errorCallback.invoke(it)
                }
                .subscribe()
        }
    }
}