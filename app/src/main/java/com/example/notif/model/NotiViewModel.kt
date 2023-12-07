package com.example.notif.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.example.notif.Notification
import com.example.notif.NotificationRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotiViewModel(private val repository: NotificationRepository): ViewModel() {

    var notis: LiveData<List<Notification>> = repository.allNotis.asLiveData()

    private val _title = MutableLiveData<String>("Is this")
    val title: LiveData<String> = _title

    private val _desc = MutableLiveData<String>("working?")
    val desc: LiveData<String> = _desc

    private val _date = MutableLiveData<String>()
    val date: LiveData<String> = _date

    private val _time = MutableLiveData<String>()
    val time: LiveData<String> = _time

    fun addNoti(noti: Notification) = CoroutineScope(Dispatchers.IO).launch { repository.insertNotification(noti) }

    fun setTitle(title: String) {
        _title.value = title
    }
    // comment
    fun setDesc(desc: String) {
        _desc.value = desc
    }

    fun setDate(date: String) {
        _date.value = date
    }

    fun setTime(time: String) {
        _time.value = time
    }
}

class NotificationModelFactory(private val repository: NotificationRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NotiViewModel::class.java))
            return NotiViewModel(repository) as T
        throw IllegalArgumentException("Unknown class for view model.")
    }
}