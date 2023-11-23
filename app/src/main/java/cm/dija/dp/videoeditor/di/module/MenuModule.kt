package cm.dija.dp.videoeditor.di.module

import cm.dija.dp.videoeditor.repository.DashboardRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MenuModule {
    @Provides
    fun provideDashboardRepository(): DashboardRepository {
        return DashboardRepository()
    }
}