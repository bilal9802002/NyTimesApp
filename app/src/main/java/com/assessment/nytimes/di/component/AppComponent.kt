package com.assessment.nytimes.di.component

import android.app.Application
import com.assessment.nytimes.presentation.NYTimesApplication
import com.assessment.nytimes.di.builder.ActivityBuilderModule
import com.assessment.nytimes.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBuilderModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(NYTimesApplication: NYTimesApplication)
}