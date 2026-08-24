package seago.household.seagohomespark.ui.composable.screen.order

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import seago.household.seagohomespark.data.entity.OrderEntity
import seago.household.seagohomespark.ui.state.DataUiState
import seago.household.seagohomespark.ui.viewmodel.OrderViewModel
import java.time.format.DateTimeFormatter

@Composable
fun OrdersScreen(
    modifier: Modifier = Modifier,
    viewModel: OrderViewModel = koinViewModel(),
) {
    val state by viewModel.ordersState.collectAsState()
    val orders = (state as? DataUiState.Populated)?.data.orEmpty().sortedByDescending { it.timestamp }
    if (orders.isEmpty()) {
        Column(
            modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text("No orders yet", style = MaterialTheme.typography.titleLarge)
            Text("Your reservations will appear here.", color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    } else {
        LazyColumn(
            modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            items(orders, key = { it.orderNumber }) { order ->
                OrderCard(order)
            }
        }
    }
}

@Composable
private fun OrderCard(order: OrderEntity) {
    Card(shape = RoundedCornerShape(16.dp)) {
        Column(Modifier.fillMaxWidth().padding(16.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Order #" + order.orderNumber, style = MaterialTheme.typography.titleMedium)
                Text("Reserved", color = MaterialTheme.colorScheme.tertiary)
            }
            Text(order.timestamp.format(DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm")))
            Text(order.description, color = MaterialTheme.colorScheme.onSurfaceVariant)
            Text("£%.2f".format(order.price), style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.primary)
            Text("Ready for collection for 24 hours", style = MaterialTheme.typography.labelLarge)
        }
    }
}

