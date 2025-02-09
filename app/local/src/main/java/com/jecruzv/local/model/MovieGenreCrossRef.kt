package com.jecruzv.local.model

import androidx.room.Entity
import androidx.room.ForeignKey
import com.jecruzv.local.Constants

@Entity(
    tableName = Constants.MOVIES_GENRES_TABLE,
    primaryKeys = ["movieId", "genreId"],
    foreignKeys = [
        ForeignKey(
            entity = MovieDetail::class,
            parentColumns = ["id"],
            childColumns = ["movieId"]
        ),
        ForeignKey(
            entity = Genres::class,
            parentColumns = ["id"],
            childColumns = ["genreId"]
        )
    ]
)data class MovieGenreCrossRef(
    val movieId: Int,
    val genreId: Int
)