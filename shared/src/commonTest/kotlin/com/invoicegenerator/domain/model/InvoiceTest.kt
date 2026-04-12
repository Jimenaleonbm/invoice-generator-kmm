package com.invoicegenerator.domain.model

import kotlin.test.Test
import kotlin.test.assertEquals

class InvoiceTest {

    @Test
    fun `invoice subtotal is sum of item totals`() {
        val items = listOf(
            InvoiceItem(description = "Service A", quantity = 2.0, unitPrice = 100.0),
            InvoiceItem(description = "Service B", quantity = 1.0, unitPrice = 50.0)
        )
        val invoice = Invoice(
            number = "INV-001",
            clientId = 1L,
            clientName = "Acme Corp",
            issueDate = "2024-01-01",
            dueDate = "2024-01-31",
            items = items
        )

        assertEquals(250.0, invoice.subtotal)
    }

    @Test
    fun `invoice tax amount is calculated from items`() {
        val items = listOf(
            InvoiceItem(description = "Service A", quantity = 1.0, unitPrice = 100.0, taxRate = 20.0)
        )
        val invoice = Invoice(
            number = "INV-002",
            clientId = 1L,
            clientName = "Test Client",
            issueDate = "2024-01-01",
            dueDate = "2024-01-31",
            items = items
        )

        assertEquals(20.0, invoice.taxAmount)
        assertEquals(120.0, invoice.total)
    }

    @Test
    fun `invoice with no items has zero total`() {
        val invoice = Invoice(
            number = "INV-003",
            clientId = 1L,
            clientName = "Empty Client",
            issueDate = "2024-01-01",
            dueDate = "2024-01-31"
        )

        assertEquals(0.0, invoice.subtotal)
        assertEquals(0.0, invoice.total)
    }

    @Test
    fun `invoice item total is quantity times unit price`() {
        val item = InvoiceItem(
            description = "Consulting",
            quantity = 3.0,
            unitPrice = 150.0
        )

        assertEquals(450.0, item.total)
    }
}
