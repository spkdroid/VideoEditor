package cm.dija.dp.videoeditor.di.module

import cm.dija.dp.videoeditor.repository.VideoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class VideoModule {
    @Provides
    fun provideVideoRepository(): VideoRepository {
        return VideoRepository()
    }
}