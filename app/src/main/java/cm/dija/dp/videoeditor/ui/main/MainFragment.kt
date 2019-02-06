package cm.dija.dp.videoeditor.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import cm.dija.dp.videoeditor.R
import com.github.hiteshsondhi88.libffmpeg.exceptions.FFmpegNotSupportedException
import com.github.hiteshsondhi88.libffmpeg.LoadBinaryResponseHandler
import com.github.hiteshsondhi88.libffmpeg.FFmpeg
import com.github.hiteshsondhi88.libffmpeg.exceptions.FFmpegCommandAlreadyRunningException
import com.github.hiteshsondhi88.libffmpeg.ExecuteBinaryResponseHandler

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel

        val ffmpeg = FFmpeg.getInstance(context)
        try {
            ffmpeg.loadBinary(object : LoadBinaryResponseHandler() {

                override fun onStart() {
                    Toast.makeText(context,"Started",Toast.LENGTH_LONG).show()
                }

                override fun onFailure() {
                    Toast.makeText(context,"Failure",Toast.LENGTH_LONG).show()
                }

                override fun onSuccess() {
                    Toast.makeText(context,"Success",Toast.LENGTH_LONG).show()
                }

                override fun onFinish() {
                    Toast.makeText(context,"Finish",Toast.LENGTH_LONG).show()
                }
            })
        } catch (e: FFmpegNotSupportedException) {
            // Handle if FFmpeg is not supported by device
        }


        try {
            // to execute "ffmpeg -version" command you just need to pass "-version"
            ffmpeg.execute(arrayOf("-version"), object : ExecuteBinaryResponseHandler() {

                override fun onStart() {}

                override fun onProgress(message: String?) {
                    Toast.makeText(context,message,Toast.LENGTH_LONG).show()
                }

                override fun onFailure(message: String?) {
                    Toast.makeText(context,message,Toast.LENGTH_LONG).show()
                }

                override fun onSuccess(message: String?) {
                    Toast.makeText(context,message,Toast.LENGTH_LONG).show()
                }

                override fun onFinish() {}
            })
        } catch (e: FFmpegCommandAlreadyRunningException) {
            // Handle if FFmpeg is already running
        }


    }

}
