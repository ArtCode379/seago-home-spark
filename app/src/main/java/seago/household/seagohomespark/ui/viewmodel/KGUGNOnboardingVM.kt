package seago.household.seagohomespark.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import seago.household.seagohomespark.data.repository.KGUGNOnboardingRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class KGUGNOnboardingVM(
    private val onboardingRepository: KGUGNOnboardingRepo,
) : ViewModel() {
    private val _onboardingSetState = MutableStateFlow(false)
    val onboardingSetState: StateFlow<Boolean>
        get() = _onboardingSetState.asStateFlow()

    fun setOnboarded() {
        viewModelScope.launch {
            onboardingRepository.setOnboardingState(true)
            _onboardingSetState.update { true }
        }
    }
}