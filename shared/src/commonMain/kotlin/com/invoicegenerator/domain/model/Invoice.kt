package com.invoicegenerator.domain.model

/**
 * Represents an invoice with line items and client information.
 */
data class Invoice(
    val id: Long = 0,
    val number: String,
    val clientId: Long,
    val clientName: String,
    val issueDate: String,
    val dueDate: String,
    val items: List<InvoiceItem> = emptyList(),
    val notes: String = "",
    val status: InvoiceStatus = InvoiceStatus.DRAFT
) {
    val subtotal: Double
        get() = items.sumOf { it.total }

    val taxAmount: Double
        get() = items.sumOf { it.taxAmount }

    val total: Double
        get() = subtotal + taxAmount
}

/**
 * Represents a single line item in an invoice.
 */
data class InvoiceItem(
    val id: Long = 0,
    val description: String,
    val quantity: Double,
    val unitPrice: Double,
    val taxRate: Double = 0.0
) {
    val total: Double
        get() = quantity * unitPrice

    val taxAmount: Double
        get() = total * (taxRate / 100.0)
}

/**
 * Invoice lifecycle status.
 */
enum class InvoiceStatus {
    DRAFT,
    SENT,
    PAID,
    OVERDUE,
    CANCELLED
}
