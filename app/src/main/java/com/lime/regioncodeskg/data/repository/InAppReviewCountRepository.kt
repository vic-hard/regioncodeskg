package com.lime.regioncodeskg.data.repository

import com.lime.regioncodeskg.data.InAppReviewCountData
import kotlinx.coroutines.flow.Flow

interface InAppReviewCountRepository {
    suspend fun increaseInAppReviewCount()
    fun getInAppReviewCount(): Flow<InAppReviewCountData>
}