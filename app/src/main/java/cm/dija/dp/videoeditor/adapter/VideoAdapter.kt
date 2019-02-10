package cm.dija.dp.videoeditor.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cm.dija.dp.videoeditor.R
import cm.dija.dp.videoeditor.data.Video
import kotlinx.android.synthetic.main.video_list_item.view.*
import android.graphics.BitmapFactory
import android.media.ThumbnailUtils
import android.graphics.Bitmap
import android.media.MediaMetadataRetriever





class VideoAdapter(val items : ArrayList<Video>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.video_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.filename.text = items[position].mimeType
        holder.relativepath.text = items[position].thumbnailPath


        val metadataRetriever = MediaMetadataRetriever()
        try {
            metadataRetriever.setDataSource(items[position].thumbnailPath)
            val duration = metadataRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)
            val time = java.lang.Long.valueOf(duration) / 2
            val bitmap = metadataRetriever.getFrameAtTime(time, MediaMetadataRetriever.OPTION_NEXT_SYNC)
            //now convert to base64
            val resizedBitmap = Bitmap.createScaledBitmap(
                bitmap, 250, 150, false
            )
            holder.videoimage.setImageBitmap(resizedBitmap)
        } catch (ex: Exception) {
        }



     /*   if(items[position].videoPath.isEmpty()){
            val ThumbImage = ThumbnailUtils.extractThumbnail(BitmapFactory.decodeFile(items[position].thumbnailPath),250, 250)
            holder.videoimage.setImageBitmap(ThumbImage)
        }
        else {
            holder.videoimage.setImageURI(Uri.parse(items[position].videoPath))
        }
*/

    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    var filename = view.filename!!
    var relativepath = view.relativepath!!
    var videoimage = view.videoimage!!
 }