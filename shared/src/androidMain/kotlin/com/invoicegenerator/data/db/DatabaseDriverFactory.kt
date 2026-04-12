package com.invoicegenerator.data.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.invoicegenerator.db.InvoiceDatabase

/**
 * Android implementation of [DatabaseDriverFactory].
 */
actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(InvoiceDatabase.Schema, context, "invoice.db")
    }
}
