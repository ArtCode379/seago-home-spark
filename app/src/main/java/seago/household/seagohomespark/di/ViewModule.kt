package seago.household.seagohomespark.di

import seago.household.seagohomespark.ui.viewmodel.AppViewModel
import seago.household.seagohomespark.ui.viewmodel.CartViewModel
import seago.household.seagohomespark.ui.viewmodel.CheckoutViewModel
import seago.household.seagohomespark.ui.viewmodel.KGUGNOnboardingVM
import seago.household.seagohomespark.ui.viewmodel.OrderViewModel
import seago.household.seagohomespark.ui.viewmodel.ProductDetailsViewModel
import seago.household.seagohomespark.ui.viewmodel.ProductViewModel
import seago.household.seagohomespark.ui.viewmodel.KGUGNSplashVM
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModule = module {
    viewModel {
        AppViewModel(
            cartRepository = get()
        )
    }

    viewModel {
        KGUGNSplashVM(
            onboardingRepository = get()
        )
    }

    viewModel {
        KGUGNOnboardingVM(
            onboardingRepository = get()
        )
    }

    viewModel {
        ProductViewModel(
            productRepository = get(),
            cartRepository = get(),
        )
    }

    viewModel {
        ProductDetailsViewModel(
            productRepository = get(),
            cartRepository = get(),
        )
    }

    viewModel {
        CheckoutViewModel(
            cartRepository = get(),
            productRepository = get(),
            orderRepository = get(),
        )
    }

    viewModel {
        CartViewModel(
            cartRepository = get(),
            productRepository = get(),
        )
    }

    viewModel {
        OrderViewModel(
            orderRepository = get(),
        )
    }
}