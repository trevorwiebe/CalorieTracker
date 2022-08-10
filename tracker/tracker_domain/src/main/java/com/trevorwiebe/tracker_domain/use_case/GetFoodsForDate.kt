package com.trevorwiebe.tracker_domain.use_case

import com.trevorwiebe.tracker_domain.model.TrackableFood
import com.trevorwiebe.tracker_domain.model.TrackedFood
import com.trevorwiebe.tracker_domain.repository.TrackerRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class GetFoodsForDate(
    private val repository: TrackerRepository
) {
    operator fun invoke(date: LocalDate): Flow<List<TrackedFood>> {
        return repository.getFoodsForDate(date)
    }
}