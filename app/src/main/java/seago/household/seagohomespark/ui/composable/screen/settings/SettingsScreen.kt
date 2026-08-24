package seago.household.seagohomespark.ui.composable.screen.settings

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Column(modifier.fillMaxSize().padding(20.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("About", style = MaterialTheme.typography.titleLarge)
        Card {
            Column(Modifier.fillMaxWidth().padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("Seago Home Spark", style = MaterialTheme.typography.titleMedium)
                Text("SEAGO LTD", color = MaterialTheme.colorScheme.onSurfaceVariant)
                Text("Version 1.0", color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
        Text("Support", style = MaterialTheme.typography.titleLarge)
        Text("Questions about a reservation or product? Visit our customer support website.")
        Button(
            onClick = {
                context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://seago.surf")))
            },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text("Customer Support")
        }
    }
}

