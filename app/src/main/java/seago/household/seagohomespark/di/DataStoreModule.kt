package seago.household.seagohomespark.di

import seago.household.seagohomespark.data.datastore.KGUGNOnboardingPrefs
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataStoreModule = module {
    single { KGUGNOnboardingPrefs(androidContext()) }
}