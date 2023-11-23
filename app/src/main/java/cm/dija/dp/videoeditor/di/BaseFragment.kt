package cm.dija.dp.videoeditor.di

import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cm.dija.dp.videoeditor.viewmodel.DashboardViewModel

@AndroidEntryPoint
open class BaseFragment:Fragment()