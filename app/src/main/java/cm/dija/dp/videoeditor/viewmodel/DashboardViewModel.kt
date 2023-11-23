package cm.dija.dp.videoeditor.viewmodel

import androidx.lifecycle.ViewModel
import cm.dija.dp.videoeditor.repository.DashboardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(private val repository: DashboardRepository) : ViewModel() {
    // TODO: Implement the ViewModel
}