package seago.household.seagohomespark.ui.composable.screen.cart

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.RemoveShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import org.koin.compose.viewmodel.koinViewModel
import seago.household.seagohomespark.ui.state.*
import seago.household.seagohomespark.ui.viewmodel.CartViewModel

@Composable
fun CartScreen(
    modifier: Modifier = Modifier,
    viewModel: CartViewModel = koinViewModel(),
    onNavigateToCheckoutScreen: () -> Unit,
) {
    val state by viewModel.cartItemsState.collectAsStateWithLifecycle()
    val total by viewModel.totalPrice.collectAsStateWithLifecycle()
    val cartItems = (state as? DataUiState.Populated)?.data.orEmpty()
    if (cartItems.isEmpty()) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Icon(Icons.Rounded.RemoveShoppingCart, null, Modifier.size(72.dp), tint = MaterialTheme.colorScheme.primary)
            Text("Your cart is ready for a fresh find", style = MaterialTheme.typography.titleLarge)
            Text("Start shopping from the Home tab.", color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    } else {
        Column(modifier.fillMaxSize().padding(16.dp)) {
            LazyColumn(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(cartItems, key = { it.productId }) { item ->
                    CartRow(
                        item,
                        { viewModel.incrementProductInCart(item.productId) },
                        {
                            if (item.quantity == 1) {
                                viewModel.deleteFromCart(item.productId)
                            } else {
                                viewModel.decrementItemInCart(item.productId)
                            }
                        },
                        { viewModel.deleteFromCart(item.productId) },
                    )
                }
            }
            Text("Subtotal  £%.2f".format(total), style = MaterialTheme.typography.titleMedium)
            Text("Total  £%.2f".format(total), style = MaterialTheme.typography.titleLarge)
            Spacer(Modifier.height(12.dp))
            Button(onClick = onNavigateToCheckoutScreen, modifier = Modifier.fillMaxWidth().height(52.dp)) {
                Text("Proceed to Checkout")
            }
        }
    }
}

@Composable
private fun CartRow(item: CartItemUiState, onPlus: () -> Unit, onMinus: () -> Unit, onRemove: () -> Unit) {
    Card(shape = RoundedCornerShape(16.dp)) {
        Row(Modifier.fillMaxWidth().padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(item.productImageUrl, item.productTitle, Modifier.size(64.dp), contentScale = ContentScale.Crop)
            Column(Modifier.weight(1f).padding(horizontal = 12.dp)) {
                Text(item.productTitle, style = MaterialTheme.typography.titleMedium)
                Text("£%.2f".format(item.productPrice), color = MaterialTheme.colorScheme.primary)
            }
            IconButton(onClick = onMinus) {
                Text("−")
            }
            Text(item.quantity.toString())
            IconButton(onClick = onPlus) {
                Text("+")
            }
            IconButton(onClick = onRemove) {
                Text("×")
            }
        }
    }
}

