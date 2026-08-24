package seago.household.seagohomespark.ui.composable.screen.checkout

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel
import seago.household.seagohomespark.ui.state.DataUiState
import seago.household.seagohomespark.ui.viewmodel.CheckoutViewModel

@Composable
fun CheckoutScreen(
    modifier: Modifier = Modifier,
    viewModel: CheckoutViewModel = koinViewModel(),
    onNavigateToOrdersScreen: () -> Unit,
) {
    val orderState by viewModel.orderState.collectAsStateWithLifecycle()
    val invalid by viewModel.emailInvalidState.collectAsStateWithLifecycle()
    if (orderState is DataUiState.Populated) {
        CheckoutDialog(onConfirm = onNavigateToOrdersScreen)
    }
    CheckoutContent(
        viewModel.customerFirstName,
        viewModel.customerLastName,
        viewModel.customerEmail,
        invalid,
        modifier,
        LocalFocusManager.current,
        viewModel.customerFirstName.isNotBlank() &&
            viewModel.customerLastName.isNotBlank() &&
            viewModel.customerEmail.isNotBlank(),
        viewModel::updateCustomerFirstName,
        viewModel::updateCustomerLastName,
        viewModel::updateCustomerEmail,
        viewModel::placeOrder,
    )
}

@Composable
private fun CheckoutContent(
    firstName: String,
    lastName: String,
    email: String,
    invalid: Boolean,
    modifier: Modifier,
    focusManager: FocusManager,
    enabled: Boolean,
    onFirstNameChanged: (String) -> Unit,
    onLastNameChanged: (String) -> Unit,
    onEmailChanged: (String) -> Unit,
    onPlaceOrder: () -> Unit,
) {
    Column(
        modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp),
    ) {
        Text("Reserve for store collection", style = MaterialTheme.typography.titleLarge)
        Text("Your order will be held in store for 24 hours.", color = MaterialTheme.colorScheme.onSurfaceVariant)
        CheckoutTextField(firstName, onFirstNameChanged, "First name", Modifier.fillMaxWidth())
        CheckoutTextField(lastName, onLastNameChanged, "Last name", Modifier.fillMaxWidth())
        CheckoutTextField(
            email,
            onEmailChanged,
            "Email",
            Modifier.fillMaxWidth(),
            isError = invalid,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
        )
        if (invalid) {
            Text("Enter a valid email address.", color = MaterialTheme.colorScheme.error)
        }
        Button(onClick = onPlaceOrder, enabled = enabled, modifier = Modifier.fillMaxWidth().height(52.dp)) {
            Text("Place Order")
        }
    }
}

@Composable
fun CheckoutTextField(
    input: String,
    onInputChange: (String) -> Unit,
    labelText: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    isError: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
) {
    OutlinedTextField(
        value = input,
        onValueChange = onInputChange,
        modifier = modifier,
        enabled = enabled,
        label = {
            Text(labelText)
        },
        isError = isError,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = true,
    )
}

