package com.lime.regioncodeskg.data.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.lime.regioncodeskg.data.di.qualifiers.InAppReviewCount
import com.lime.regioncodeskg.data.inAppReviewCountDataStore
import com.lime.regioncodeskg.data.repository.InAppReviewCountRepository
import com.lime.regioncodeskg.data.repository.InAppReviewCountRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
class DataModule {

    @Provides
    @InAppReviewCount
    fun provideInAppReviewCountDataStore(
        @ApplicationContext context: Context
    ): DataStore<Preferences> {
        return context.inAppReviewCountDataStore
    }

    @Provides
    fun provideInAppReviewCountRepository(
        @InAppReviewCount dataStore: DataStore<Preferences>
    ): InAppReviewCountRepository {
        return InAppReviewCountRepositoryImpl(dataStore)
    }

}