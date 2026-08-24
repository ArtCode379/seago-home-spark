package seago.household.seagohomespark.ui.composable.screen.order

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import seago.household.seagohomespark.R
import seago.household.seagohomespark.data.entity.OrderEntity
import seago.household.seagohomespark.ui.composable.shared.KGUGNContentWrapper
import seago.household.seagohomespark.ui.composable.shared.KGUGNEmptyView
import seago.household.seagohomespark.ui.state.DataUiState
import seago.household.seagohomespark.ui.viewmodel.OrderViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun OrdersScreen(
    modifier: Modifier = Modifier,
    viewModel: OrderViewModel = koinViewModel(),
) {
    val ordersState by viewModel.ordersState.collectAsState()

    OrdersContent(
        ordersState = ordersState,
        modifier = modifier,
    )
}

@Composable
private fun OrdersContent(
    ordersState: DataUiState<List<OrderEntity>>,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {

        KGUGNContentWrapper(
            dataState = ordersState,

            dataPopulated = {
                val data = (ordersState as DataUiState.Populated).data

            },

            dataEmpty = {
                KGUGNEmptyView(
                    primaryText = stringResource(R.string.kgugn_orders_state_empty_primary_text),
                    modifier = Modifier.fillMaxSize(),
                )
            },
        )
    }
}