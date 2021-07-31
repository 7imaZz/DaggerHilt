package com.tawajood.daggerhilt.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    s: String
): ViewModel() {

    init {
        Log.d("7ima", "s: $s")
    }
}