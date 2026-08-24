package seago.household.seagohomespark.ui.composable.screen.productdetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import seago.household.seagohomespark.R
import seago.household.seagohomespark.data.model.Product
import seago.household.seagohomespark.ui.composable.shared.KGUGNContentWrapper
import seago.household.seagohomespark.ui.composable.shared.KGUGNEmptyView
import seago.household.seagohomespark.ui.state.DataUiState
import seago.household.seagohomespark.ui.viewmodel.ProductDetailsViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ProductDetailsScreen(
    productId: Int,
    modifier: Modifier = Modifier,
    viewModel: ProductDetailsViewModel = koinViewModel(),
) {
    val productState by viewModel.productDetailsState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.observeProductDetails(productId)
    }

    ProductDetailsScreenContent(
        productState = productState,
        modifier = modifier,
        onAddToCart = viewModel::addProductToCart
    )
}

@Composable
private fun ProductDetailsScreenContent(
    productState: DataUiState<Product>,
    modifier: Modifier = Modifier,
    onAddToCart: () -> Unit,
) {
    Column(modifier = modifier) {

        KGUGNContentWrapper(
            dataState = productState,

            dataPopulated = {
                val data = (productState as DataUiState.Populated).data

            },

            dataEmpty = {
                KGUGNEmptyView(
                    primaryText = stringResource(R.string.kgugn_product_details_state_empty_primary_text),
                    modifier = Modifier.fillMaxSize(),
                )
            },
        )
    }
}