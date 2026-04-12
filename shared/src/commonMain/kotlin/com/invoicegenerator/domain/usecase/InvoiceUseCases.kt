package com.invoicegenerator.domain.usecase

import com.invoicegenerator.data.repository.InvoiceRepository
import com.invoicegenerator.domain.model.Invoice

/**
 * Use case for retrieving all invoices.
 */
class GetInvoicesUseCase(private val repository: InvoiceRepository) {
    suspend operator fun invoke(): List<Invoice> = repository.getAllInvoices()
}

/**
 * Use case for creating or updating an invoice.
 */
class SaveInvoiceUseCase(private val repository: InvoiceRepository) {
    suspend operator fun invoke(invoice: Invoice): Long = repository.saveInvoice(invoice)
}

/**
 * Use case for deleting an invoice by id.
 */
class DeleteInvoiceUseCase(private val repository: InvoiceRepository) {
    suspend operator fun invoke(id: Long) = repository.deleteInvoice(id)
}
