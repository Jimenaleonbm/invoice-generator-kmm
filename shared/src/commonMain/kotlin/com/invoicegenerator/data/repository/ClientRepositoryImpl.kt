package com.invoicegenerator.data.repository

import com.invoicegenerator.data.db.DatabaseDriverFactory
import com.invoicegenerator.data.db.createDatabase
import com.invoicegenerator.domain.model.Client

/**
 * SQLDelight-backed implementation of [ClientRepository].
 */
class ClientRepositoryImpl(driverFactory: DatabaseDriverFactory) : ClientRepository {

    private val database = createDatabase(driverFactory)
    private val queries = database.clientQueries

    override suspend fun getAllClients(): List<Client> {
        return queries.getAllClients().executeAsList().map { entity ->
            Client(
                id = entity.id,
                name = entity.name,
                email = entity.email,
                phone = entity.phone,
                address = entity.address,
                taxId = entity.taxId
            )
        }
    }

    override suspend fun getClientById(id: Long): Client? {
        return queries.getClientById(id).executeAsOneOrNull()?.let { entity ->
            Client(
                id = entity.id,
                name = entity.name,
                email = entity.email,
                phone = entity.phone,
                address = entity.address,
                taxId = entity.taxId
            )
        }
    }

    override suspend fun saveClient(client: Client): Long {
        queries.insertClient(
            name = client.name,
            email = client.email,
            phone = client.phone,
            address = client.address,
            taxId = client.taxId
        )
        return queries.getAllClients().executeAsList().last().id
    }

    override suspend fun updateClient(client: Client) {
        queries.updateClient(
            name = client.name,
            email = client.email,
            phone = client.phone,
            address = client.address,
            taxId = client.taxId,
            id = client.id
        )
    }

    override suspend fun deleteClient(id: Long) {
        queries.deleteClient(id)
    }
}
