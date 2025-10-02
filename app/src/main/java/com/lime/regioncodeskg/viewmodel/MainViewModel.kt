package com.lime.regioncodeskg.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lime.regioncodeskg.data.repository.InAppReviewCountRepository
import com.lime.regioncodeskg.data.repository.MAX_COUNT_BEFORE_REVIEW
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val inAppReviewCountRepository: InAppReviewCountRepository
) : ViewModel() {
    private val _reviewTrigger = MutableSharedFlow<Unit>()
    val reviewTrigger: SharedFlow<Unit> = _reviewTrigger

    init {
        observeInAppReviewCount()
    }

    private fun observeInAppReviewCount() {
        viewModelScope.launch {
            inAppReviewCountRepository.getInAppReviewCount()
                .drop(1) // ignore the first emission (startup value)
                .collect { countData ->
                    Timber.d("observeInAppReviewCount() %s", countData.count)
                    if (countData.count >= MAX_COUNT_BEFORE_REVIEW || countData.count < 0) {
                        _reviewTrigger.emit(Unit)
                    }
                }
        }
    }
}