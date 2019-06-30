package me.rozkmin.mvvm

import io.reactivex.Single

interface Repository<T> {
    fun getOne(id: String): Single<T>
}