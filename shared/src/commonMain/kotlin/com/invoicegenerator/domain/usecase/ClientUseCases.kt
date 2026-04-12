package com.invoicegenerator.domain.usecase

import com.invoicegenerator.data.repository.ClientRepository
import com.invoicegenerator.domain.model.Client

/**
 * Use case for retrieving all clients.
 */
class GetClientsUseCase(private val repository: ClientRepository) {
    suspend operator fun invoke(): List<Client> = repository.getAllClients()
}

/**
 * Use case for saving a client.
 */
class SaveClientUseCase(private val repository: ClientRepository) {
    suspend operator fun invoke(client: Client): Long = repository.saveClient(client)
}
