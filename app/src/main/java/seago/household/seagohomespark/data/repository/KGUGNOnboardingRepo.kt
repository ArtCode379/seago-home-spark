package seago.household.seagohomespark.data.repository

import seago.household.seagohomespark.data.datastore.KGUGNOnboardingPrefs
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class KGUGNOnboardingRepo(
    private val kgugnOnboardingStoreManager: KGUGNOnboardingPrefs,
    private val coroutineDispatcher: CoroutineDispatcher,
) {

    fun observeOnboardingState(): Flow<Boolean?> {
        return kgugnOnboardingStoreManager.onboardedStateFlow
    }

    suspend fun setOnboardingState(state: Boolean) {
        withContext(coroutineDispatcher) {
            kgugnOnboardingStoreManager.setOnboardedState(state)
        }
    }
}