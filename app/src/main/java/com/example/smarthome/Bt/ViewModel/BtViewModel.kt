package com.example.smarthome.Bt.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.smarthome.Bt.Repo.BtRepository

class BtViewModel(
    private val repository: BtRepository
) : ViewModel() {
}
class BtViewModelFactory(
    private val repository: BtRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        if (modelClass.isAssignableFrom(BtViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BtViewModel(repository) as T
        }

        throw IllegalArgumentException(
            "Unknown ViewModel class"
        )
    }
}