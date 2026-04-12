package com.invoicegenerator.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.invoicegenerator.android.ui.theme.InvoiceGeneratorTheme
import com.invoicegenerator.android.navigation.AppNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InvoiceGeneratorTheme {
                AppNavigation()
            }
        }
    }
}
