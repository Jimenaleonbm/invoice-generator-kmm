package com.invoicegenerator.data.repository

import com.invoicegenerator.domain.model.Invoice

/**
 * Repository interface for invoice CRUD operations.
 */
interface InvoiceRepository {
    suspend fun getAllInvoices(): List<Invoice>
    suspend fun getInvoiceById(id: Long): Invoice?
    suspend fun saveInvoice(invoice: Invoice): Long
    suspend fun updateInvoice(invoice: Invoice)
    suspend fun deleteInvoice(id: Long)
}
