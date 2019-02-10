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

class VideoAdapter(val items : ArrayList<Video>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.video_list_item, parent, false))
    }

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.filename.text = items[position].title
        holder.duration.text = items[position].mimeType
        holder.videoimage.setImageURI(Uri.parse(items[position].thumbnailPath))
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    var filename = view.filename!!
    var duration = view.duration!!
    var videoimage = view.videoimage!!
 }