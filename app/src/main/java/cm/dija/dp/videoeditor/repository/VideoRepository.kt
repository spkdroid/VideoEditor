package cm.dija.dp.videoeditor.repository

import android.app.Activity
import android.content.Context
import android.database.Cursor
import android.provider.MediaStore



class VideoRepository {



    fun getVideoList(activity: Activity): Array<String> {

        var thumbCols = arrayOf(MediaStore.Video.Thumbnails.DATA, MediaStore.Video.Thumbnails.VIDEO_ID)

        var videoCols = arrayOf(
            MediaStore.Video.Media._ID,
            MediaStore.Video.Media.DATA,
            MediaStore.Video.Media.TITLE,
            MediaStore.Video.Media.MIME_TYPE
        )

    //    var cursor:Cursor = activity.contentResolver.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, thumbCols, MediaStore.Video.Thumbnails.VIDEO_ID + "=" + id, null, null)

    return thumbCols
    }



}