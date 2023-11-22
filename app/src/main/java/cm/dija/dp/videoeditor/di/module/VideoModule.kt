package cm.dija.dp.videoeditor.di.module

import cm.dija.dp.videoeditor.repository.VideoRepository
import dagger.Module
import dagger.Provides
@Module
class VideoModule {
    @Provides
    fun provideVideoRepository(): VideoRepository {
        return VideoRepository()
    }
}