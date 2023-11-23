package cm.dija.dp.videoeditor.di.component

import cm.dija.dp.videoeditor.di.module.MenuModule
import cm.dija.dp.videoeditor.di.module.VideoModule
import cm.dija.dp.videoeditor.repository.DashboardRepository
import cm.dija.dp.videoeditor.repository.VideoRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [VideoModule::class, MenuModule::class])
interface AppComponent {
    fun inject(videoRepository: VideoRepository)
    fun inject(dashboardRepository: DashboardRepository)
}
