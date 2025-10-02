package com.lime.regioncodeskg.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.lime.regioncodeskg.data.InAppReviewCountData
import com.lime.regioncodeskg.data.inAppReviewCountPreferenceKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

class InAppReviewCountRepositoryImpl(
    private val dataStore: DataStore<Preferences>
): InAppReviewCountRepository {
    override suspend fun increaseInAppReviewCount() {
        dataStore.edit { preferences ->
            val currentCount = dataStore.data.firstOrNull()
                ?.get(inAppReviewCountPreferenceKey) ?: 0

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