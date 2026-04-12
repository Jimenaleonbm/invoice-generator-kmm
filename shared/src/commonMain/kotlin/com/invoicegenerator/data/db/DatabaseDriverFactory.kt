package com.invoicegenerator.data.db

import app.cash.sqldelight.db.SqlDriver
import com.invoicegenerator.db.InvoiceDatabase

/**
 * Creates the platform-specific SQLDelight driver.
 * Each platform provides its own implementation.
 */
expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}

/**
 * Creates and returns the InvoiceDatabase instance.
 */
fun createDatabase(driverFactory: DatabaseDriverFactory): InvoiceDatabase {
    return InvoiceDatabase(driverFactory.createDriver())
}
