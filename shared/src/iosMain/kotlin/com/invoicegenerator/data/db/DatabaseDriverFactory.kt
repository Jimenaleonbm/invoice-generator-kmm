package com.invoicegenerator.data.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.invoicegenerator.db.InvoiceDatabase

/**
 * iOS/Native implementation of [DatabaseDriverFactory].
 */
actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(InvoiceDatabase.Schema, "invoice.db")
    }
}
