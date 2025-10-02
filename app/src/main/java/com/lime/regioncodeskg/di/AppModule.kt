package com.lime.regioncodeskg.di

import android.content.Context
import android.content.res.Resources
import com.google.android.play.core.review.ReviewManager
import com.google.android.play.core.review.ReviewManagerFactory
import com.lime.regioncodeskg.di.qualifiers.Diplomatic4DigitsResolver
import com.lime.regioncodeskg.di.qualifiers.DiplomaticResolver
import com.lime.regioncodeskg.di.qualifiers.NewNumbersResolver
import com.lime.regioncodeskg.utils.Diplomatic4DigitsResolverImpl
import com.lime.regioncodeskg.utils.DiplomaticPlatesResolverImpl
import com.lime.regioncodeskg.utils.MilitaryPlatesResolver
import com.lime.regioncodeskg.utils.MilitaryPlatesResolverImpl
import com.lime.regioncodeskg.utils.NumericPlatesResolver
import com.lime.regioncodeskg.utils.NumericPlatesResolverImpl
import com.lime.regioncodeskg.utils.OldPlatesResolver
import com.lime.regioncodeskg.utils.OldPlatesResolverImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideResources(@ApplicationContext context: Context): Resources {
        return context.resources
    }

    @Provides
    @NewNumbersResolver
    fun provideNumericPlatesResolver(resources: Resources): NumericPlatesResolver {
        return NumericPlatesResolverImpl(resources)
    }

    @Provides
    fun provideOldPlatesResolver(resources: Resources): OldPlatesResolver {
        return OldPlatesResolverImpl(resources)
    }

    @Provides
    @DiplomaticResolver
    fun provideDiplomaticPlatesResolver(resources: Resources): NumericPlatesResolver {
        return DiplomaticPlatesResolverImpl(resources)
    }

    @Provides
    @Diplomatic4DigitsResolver
    fun provideDiplomatic4DigitsResolver(resources: Resources): NumericPlatesResolver {
        return Diplomatic4DigitsResolverImpl(resources)
    }

    @Provides
    fun providesMilitaryPlatesResolver(resources: Resources): MilitaryPlatesResolver {
        return MilitaryPlatesResolverImpl(resources)
    }

    @Provides
    fun provideInAppReviewManager(@ApplicationContext context: Context): ReviewManager {
        return ReviewManagerFactory.create(context)
    }
}
