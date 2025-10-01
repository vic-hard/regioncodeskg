package com.lime.regioncodeskg.data

import android.content.Context
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

private const val IN_APP_REVIEW_COUNT_PREFERENCE_NAME = "in_app_review_count_preferences"
private const val IN_APP_REVIEW_COUNT_PREFERENCE_KEY = "in_app_review_count_preferences_key"

data class InAppReviewCountData(val count: Int)

val Context.inAppReviewCountDataStore by preferencesDataStore(IN_APP_REVIEW_COUNT_PREFERENCE_NAME)

val inAppReviewCountPreferenceKey = intPreferencesKey(IN_APP_REVIEW_COUNT_PREFERENCE_KEY)