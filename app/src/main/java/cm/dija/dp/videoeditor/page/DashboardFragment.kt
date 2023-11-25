package cm.dija.dp.videoeditor.page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cm.dija.dp.videoeditor.R
import cm.dija.dp.videoeditor.adapter.DashboardAdapter
import cm.dija.dp.videoeditor.di.BaseFragment
import cm.dija.dp.videoeditor.viewmodel.DashboardViewModel

class DashboardFragment : BaseFragment() {
    companion object {
        fun newInstance() = DashboardFragment()
    }

    private val viewModel: DashboardViewModel by viewModels()

    private lateinit var view:View


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_dashboard, container, false)
        view = v
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.dashboardRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)

        viewModel.getMenuItems().observeForever {
            val dashboardAdapter = DashboardAdapter(it)
            recyclerView.adapter = dashboardAdapter
        }

    }

}