package com.jecruzv.capstonewl.domain.usecases

import com.jecruzv.capstonewl.data.model.MoviesDao
import com.jecruzv.capstonewl.data.remote.dto.toMovie
import com.jecruzv.capstonewl.data.remote.dto.toUpcomingMovie
import com.jecruzv.capstonewl.domain.model.PopularMovie
import com.jecruzv.capstonewl.domain.model.UpcomingMovie
import com.jecruzv.capstonewl.domain.repository.MoviesRepository
import com.jecruzv.capstonewl.util.ExploreType
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

/**
 * Use-case to get explore content from repository call.
 */
class GetUpcomingMoviesUseCase @Inject constructor(
    private val repository: MoviesRepository,
    private val moviesDao: MoviesDao
) {
    operator fun invoke(page: Int, exploreType: ExploreType): Single<List<UpcomingMovie>> {
        return repository.getUpcomingMovies(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { movies ->
                Single.fromCallable {
                    moviesDao.addUpcomingMovies(movies.map { it.toUpcomingMovie() }.filterNot { it.poster_path.isNullOrBlank() })
                }.subscribeOn(Schedulers.io()).subscribe()
                movies.map { it.toUpcomingMovie() }.filterNot { it.poster_path.isNullOrBlank() }

            }
    }
}