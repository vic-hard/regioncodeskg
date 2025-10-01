package com.lime.regioncodeskg.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lime.regioncodeskg.data.repository.InAppReviewCountRepository
import kotlinx.coroutines.launch

abstract class BaseNumbersViewModel(
    private val inAppReviewCountRepository: InAppReviewCountRepository
) : ViewModel() {
    protected fun increaseInAppReviewCount() {
        viewModelScope.launch {
            inAppReviewCountRepository.increaseInAppReviewCount()
        }
    }
}