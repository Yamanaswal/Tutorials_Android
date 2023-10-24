package com.yaman.dependency_injection_using_hilt_android.di

import com.yaman.dependency_injection_using_hilt_android.navigator.AppNavigator
import com.yaman.dependency_injection_using_hilt_android.navigator.AppNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent


@Module
@InstallIn(ActivityComponent::class)
abstract class NavigationModule {

    @Binds
    abstract fun bindNavigator(impl: AppNavigatorImpl): AppNavigator
}