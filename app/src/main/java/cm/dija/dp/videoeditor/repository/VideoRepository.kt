package cm.dija.dp.videoeditor.repository

import android.app.Activity
import android.database.Cursor
import android.provider.MediaStore
import cm.dija.dp.videoeditor.data.Video


class VideoRepository {


    fun getVideoList(activity: Activity): ArrayList<Video> {

        var thumbCols = arrayOf(MediaStore.Video.Thumbnails.DATA, MediaStore.Video.Thumbnails.VIDEO_ID)

        var videoCols = arrayOf(
            MediaStore.Video.Media._ID,
            MediaStore.Video.Media.DATA,
            MediaStore.Video.Media.TITLE,
            MediaStore.Video.Media.MIME_TYPE
        )

        var videoList:ArrayList<Video> = ArrayList()

        var cursor:Cursor = activity.contentResolver.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, videoCols, null, null, null)


        if (cursor != null && cursor.moveToFirst()) {

            do {

                var thumbnailPath:String = ""

                val id = cursor.getInt(cursor.getColumnIndex(MediaStore.Video.Media._ID))
                val thumbCursor = activity.contentResolver.query(
                    MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI,
                    thumbCols,
                    MediaStore.Video.Thumbnails.VIDEO_ID + "=" + id,
                    null,
                    null
                )

                if (thumbCursor.moveToFirst()) {
                    thumbnailPath = thumbCursor.getString(thumbCursor.getColumnIndex(MediaStore.Video.Thumbnails.DATA))
                }

                var videoPath:String = cursor.getString(
                    cursor
                        .getColumnIndex(MediaStore.Video.Media.DATA)
                )
                var title:String = cursor.getString(
                    cursor
                        .getColumnIndex(MediaStore.Video.Media.TITLE)
                )
                var mimetype:String = cursor.getString(
                    cursor
                        .getColumnIndex(MediaStore.Video.Media.MIME_TYPE)
                )

              videoList.add(Video(thumbnailPath,videoPath,title,mimetype))

            } while(cursor.moveToNext())

        }

        return videoList
    }
}