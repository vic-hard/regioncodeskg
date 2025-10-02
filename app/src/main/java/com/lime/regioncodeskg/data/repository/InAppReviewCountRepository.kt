package com.lime.regioncodeskg.data.repository

import com.lime.regioncodeskg.data.InAppReviewCountData
import kotlinx.coroutines.flow.Flow

const val MAX_COUNT_BEFORE_REVIEW = 3
interface InAppReviewCountRepository {
    suspend fun increaseInAppReviewCount()
    fun getInAppReviewCount(): Flow<InAppReviewCountData>
}