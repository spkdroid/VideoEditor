package cm.dija.dp.videoeditor.repository

import android.annotation.SuppressLint
import android.app.Activity
import android.database.Cursor
import android.provider.MediaStore
import androidx.lifecycle.MutableLiveData
import cm.dija.dp.videoeditor.data.Video

class VideoRepository {

    val videoListLiveData: MutableLiveData<ArrayList<Video>> = MutableLiveData()
    @SuppressLint("Range")
    fun getVideoList(activity: Activity) {

        val thumbCols = arrayOf(MediaStore.Video.Thumbnails.DATA, MediaStore.Video.Thumbnails.VIDEO_ID)
        val videoCols = arrayOf(
            MediaStore.Video.Media._ID,
            MediaStore.Video.Media.DATA,
            MediaStore.Video.Media.TITLE,
            MediaStore.Video.Media.MIME_TYPE
        )

        val videoList: ArrayList<Video> = ArrayList()

        val cursor: Cursor? = activity.contentResolver.query(
            MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
            videoCols,
            null,
            null,
            null
        )

        if (cursor != null && cursor.moveToFirst()) {

            do {
                var thumbnailPath = ""
                val id = cursor.getInt(cursor.getColumnIndex(MediaStore.Video.Media._ID))
                val thumbCursor = activity.contentResolver.query(
                    MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI,
                    thumbCols,
                    MediaStore.Video.Thumbnails.VIDEO_ID + "=" + id,
                    null,
                    null
                )

                if (thumbCursor?.moveToFirst() == true) {
                    thumbnailPath =
                        thumbCursor.getString(thumbCursor.getColumnIndex(MediaStore.Video.Thumbnails.DATA))
                }

                val videoPath: String = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DATA))
                val title: String = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.TITLE))
                val mimetype: String =
                    cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.MIME_TYPE))
                videoList.add(Video(thumbnailPath, videoPath, title, mimetype))

            } while (cursor.moveToNext())
        }
        videoListLiveData.postValue(videoList)
    }
}
