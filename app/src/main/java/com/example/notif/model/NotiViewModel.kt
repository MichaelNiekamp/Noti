package com.example.notif.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotiViewModel: ViewModel() {
    private val _title = MutableLiveData<String>("")
    val title: LiveData<String> = _title

    private val _desc = MutableLiveData<String>("")
    val desc: LiveData<String> = _desc

    private val _date = MutableLiveData<String>("")
    val date: LiveData<String> = _date

    private val _time = MutableLiveData<String>("")
    val time: LiveData<String> = _time

    fun setTitle(title: String) {
        _title.value = title
    }

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