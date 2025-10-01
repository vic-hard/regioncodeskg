package com.lime.regioncodeskg.data.repository

import androidx.datastore.core.DataStore
import com.lime.regioncodeskg.data.InAppReviewCountData
import kotlinx.coroutines.flow.Flow
import androidx.datastore.preferences.core.edit
import com.lime.regioncodeskg.data.inAppReviewCountPreferenceKey
import kotlinx.coroutines.flow.map
import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.firstOrNull

const val MAX_COUNT_BEFORE_REVIEW = 3
class InAppReviewCountRepositoryImpl(
    private val dataStore: DataStore<Preferences>
): InAppReviewCountRepository {
    override suspend fun increaseInAppReviewCount() {
        dataStore.edit { preferences ->
            val currentCount = dataStore.data.firstOrNull()
                ?.get(inAppReviewCountPreferenceKey) ?: 0
            if (currentCount == MAX_COUNT_BEFORE_REVIEW)
                return@edit

            val updatedCount: Int = currentCount + 1
            preferences[inAppReviewCountPreferenceKey] = updatedCount
        }
    }

    override fun getInAppReviewCount(): Flow<InAppReviewCountData> {
        return dataStore.data.map { preferences ->
            val inAppReviewCount = preferences[inAppReviewCountPreferenceKey] ?: 0
            InAppReviewCountData(inAppReviewCount)
        }
    }
}