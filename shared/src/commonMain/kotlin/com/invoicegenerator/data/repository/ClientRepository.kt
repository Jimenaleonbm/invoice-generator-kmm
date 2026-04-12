package com.invoicegenerator.data.repository

import com.invoicegenerator.domain.model.Client

/**
 * Repository interface for client CRUD operations.
 */
interface ClientRepository {
    suspend fun getAllClients(): List<Client>
    suspend fun getClientById(id: Long): Client?
    suspend fun saveClient(client: Client): Long
    suspend fun updateClient(client: Client)
    suspend fun deleteClient(id: Long)
}
