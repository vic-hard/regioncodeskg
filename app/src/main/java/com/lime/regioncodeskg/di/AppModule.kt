package com.lime.regioncodeskg.di

import android.content.Context
import android.content.res.Resources
import com.lime.regioncodeskg.di.qualifiers.DiplomaticResolver
import com.lime.regioncodeskg.di.qualifiers.NewNumbersResolver
import com.lime.regioncodeskg.utils.DiplomaticPlatesResolverImpl
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

}