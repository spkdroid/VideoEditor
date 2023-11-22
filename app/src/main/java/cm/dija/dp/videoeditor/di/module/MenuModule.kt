package cm.dija.dp.videoeditor.di.module

import cm.dija.dp.videoeditor.repository.DashboardRepository
import dagger.Module
import dagger.Provides

@Module
class MenuModule {
    @Provides
    fun provideDashboardRepository(): DashboardRepository {
        return DashboardRepository()
    }
}