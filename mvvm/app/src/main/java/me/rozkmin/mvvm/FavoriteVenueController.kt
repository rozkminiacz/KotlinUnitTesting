package me.rozkmin.mvvm

import io.reactivex.Completable
import io.reactivex.Single

interface FavoriteVenueController {
    fun markAs(venueId: String, favorite: Boolean): Completable
    fun checkIsFavorite(venueId: String): Single<Boolean>
}