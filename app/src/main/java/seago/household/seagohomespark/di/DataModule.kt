package seago.household.seagohomespark.di

import seago.household.seagohomespark.data.repository.CartRepository
import seago.household.seagohomespark.data.repository.KGUGNOnboardingRepo
import seago.household.seagohomespark.data.repository.OrderRepository
import seago.household.seagohomespark.data.repository.ProductRepository

import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    includes(databaseModule, dataStoreModule)

    single {
        KGUGNOnboardingRepo(
            kgugnOnboardingStoreManager = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }

    single { ProductRepository() }

    single {
        CartRepository(
            cartItemDao = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }

    single {
        OrderRepository(
            orderDao = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }
}