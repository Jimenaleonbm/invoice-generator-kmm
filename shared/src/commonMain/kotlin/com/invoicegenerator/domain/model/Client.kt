package com.invoicegenerator.domain.model

/**
 * Represents a client/customer for invoicing.
 */
data class Client(
    val id: Long = 0,
    val name: String,
    val email: String,
    val phone: String = "",
    val address: String = "",
    val taxId: String = ""
)
