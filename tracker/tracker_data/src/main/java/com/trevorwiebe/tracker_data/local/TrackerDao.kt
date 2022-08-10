package com.trevorwiebe.tracker_data.local

import androidx.room.*
import com.trevorwiebe.tracker_data.local.entity.TrackedFoodEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TrackerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrackedFood(trackedFoodEntity: TrackedFoodEntity)

    @Query("SELECT * FROM trackedfoodentity WHERE dayOfMonth = :day AND month = :month AND year = :year")
    fun getFoodsForDate(day: Int, month: Int, year: Int): Flow<List<TrackedFoodEntity>>

    @Delete
    suspend fun deleteTrackedFood(trackedFoodEntity: TrackedFoodEntity)
}