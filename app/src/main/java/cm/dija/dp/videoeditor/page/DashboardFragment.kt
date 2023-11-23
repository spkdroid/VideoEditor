package cm.dija.dp.videoeditor.page

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import cm.dija.dp.videoeditor.R
import cm.dija.dp.videoeditor.viewmodel.DashboardViewModel

class DashboardFragment : Fragment() {
    companion object {
        fun newInstance() = DashboardFragment()
    }

    private val dashBoardViewModel: DashboardViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)
        //dashBoardViewModel.

    // TODO: Use the ViewModel
    }

}