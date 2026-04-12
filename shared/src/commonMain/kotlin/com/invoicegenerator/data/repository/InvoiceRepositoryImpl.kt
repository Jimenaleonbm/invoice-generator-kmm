package com.invoicegenerator.data.repository

import com.invoicegenerator.data.db.DatabaseDriverFactory
import com.invoicegenerator.data.db.createDatabase
import com.invoicegenerator.domain.model.Invoice
import com.invoicegenerator.domain.model.InvoiceItem
import com.invoicegenerator.domain.model.InvoiceStatus

/**
 * SQLDelight-backed implementation of [InvoiceRepository].
 */
class InvoiceRepositoryImpl(driverFactory: DatabaseDriverFactory) : InvoiceRepository {

    private val database = createDatabase(driverFactory)
    private val queries = database.invoiceQueries

    override suspend fun getAllInvoices(): List<Invoice> {
        return queries.getAllInvoices().executeAsList().map { entity ->
            val items = queries.getItemsByInvoiceId(entity.id).executeAsList().map { item ->
                InvoiceItem(
                    id = item.id,
                    description = item.description,
                    quantity = item.quantity,
                    unitPrice = item.unitPrice,
                    taxRate = item.taxRate
                )
            }
            Invoice(
                id = entity.id,
                number = entity.number,
                clientId = entity.clientId,
                clientName = entity.clientName,
                issueDate = entity.issueDate,
                dueDate = entity.dueDate,
                items = items,
                notes = entity.notes,
                status = InvoiceStatus.valueOf(entity.status)
            )
        }
    }

    override suspend fun getInvoiceById(id: Long): Invoice? {
        val entity = queries.getInvoiceById(id).executeAsOneOrNull() ?: return null
        val items = queries.getItemsByInvoiceId(id).executeAsList().map { item ->
            InvoiceItem(
                id = item.id,
                description = item.description,
                quantity = item.quantity,
                unitPrice = item.unitPrice,
                taxRate = item.taxRate
            )
        }
        return Invoice(
            id = entity.id,
            number = entity.number,
            clientId = entity.clientId,
            clientName = entity.clientName,
            issueDate = entity.issueDate,
            dueDate = entity.dueDate,
            items = items,
            notes = entity.notes,
            status = InvoiceStatus.valueOf(entity.status)
        )
    }

    override suspend fun saveInvoice(invoice: Invoice): Long {
        queries.insertInvoice(
            number = invoice.number,
            clientId = invoice.clientId,
            clientName = invoice.clientName,
            issueDate = invoice.issueDate,
            dueDate = invoice.dueDate,
            notes = invoice.notes,
            status = invoice.status.name
        )
        val insertedId = queries.lastInsertRowId().executeAsOne()
        invoice.items.forEach { item ->
            queries.insertInvoiceItem(
                invoiceId = insertedId,
                description = item.description,
                quantity = item.quantity,
                unitPrice = item.unitPrice,
                taxRate = item.taxRate
            )
        }
        return insertedId
    }

    override suspend fun updateInvoice(invoice: Invoice) {
        queries.updateInvoice(
            number = invoice.number,
            clientId = invoice.clientId,
            clientName = invoice.clientName,
            issueDate = invoice.issueDate,
            dueDate = invoice.dueDate,
            notes = invoice.notes,
            status = invoice.status.name,
            id = invoice.id
        )
        queries.deleteItemsByInvoiceId(invoice.id)
        invoice.items.forEach { item ->
            queries.insertInvoiceItem(
                invoiceId = invoice.id,
                description = item.description,
                quantity = item.quantity,
                unitPrice = item.unitPrice,
                taxRate = item.taxRate
            )
        }
    }

    override suspend fun deleteInvoice(id: Long) {
        queries.deleteInvoice(id)
    }
}
