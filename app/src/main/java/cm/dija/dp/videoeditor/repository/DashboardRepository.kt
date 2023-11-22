package cm.dija.dp.videoeditor.repository

import androidx.lifecycle.MutableLiveData

class DashboardRepository {
    val menuListLiveData: MutableLiveData<ArrayList<String>> = MutableLiveData()
    val menu = ArrayList<String>()
    fun getMenuItems(): MutableLiveData<ArrayList<String>> {
        menu.add("Cut Video")
        menu.add("Merge Video")
        menu.add("Exported Video")
        menuListLiveData.postValue(menu)
        return menuListLiveData
    }
}