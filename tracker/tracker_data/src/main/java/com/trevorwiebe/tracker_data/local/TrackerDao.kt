package com.trevorwiebe.tracker_data.local

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.trevorwiebe.tracker_data.local.entity.TrackedFoodEntity
import kotlinx.coroutines.flow.Flow

interface TrackerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrackedFood(trackedFoodEntity: TrackedFoodEntity)

    @Query("SELECT * FROM trackedfoodentity WHERE dayOfMonth = :day AND month = :month AND year = :year")
    fun getFoodsForDate(day: Int, month: Int, year: Int): Flow<List<TrackedFoodEntity>>

    @Delete
    suspend fun deleteTrackedFood(trackedFoodEntity: TrackedFoodEntity)
}