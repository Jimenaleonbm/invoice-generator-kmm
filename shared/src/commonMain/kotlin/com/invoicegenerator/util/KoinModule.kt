package com.invoicegenerator.util

import com.invoicegenerator.data.db.DatabaseDriverFactory
import com.invoicegenerator.data.repository.ClientRepository
import com.invoicegenerator.data.repository.ClientRepositoryImpl
import com.invoicegenerator.data.repository.InvoiceRepository
import com.invoicegenerator.data.repository.InvoiceRepositoryImpl
import com.invoicegenerator.domain.usecase.DeleteInvoiceUseCase
import com.invoicegenerator.domain.usecase.GetClientsUseCase
import com.invoicegenerator.domain.usecase.GetInvoicesUseCase
import com.invoicegenerator.domain.usecase.SaveClientUseCase
import com.invoicegenerator.domain.usecase.SaveInvoiceUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

/**
 * Koin dependency injection module for the shared module.
 */
val sharedModule = module {
    single<InvoiceRepository> { InvoiceRepositoryImpl(get()) }
    single<ClientRepository> { ClientRepositoryImpl(get()) }
    factoryOf(::GetInvoicesUseCase)
    factoryOf(::SaveInvoiceUseCase)
    factoryOf(::DeleteInvoiceUseCase)
    factoryOf(::GetClientsUseCase)
    factoryOf(::SaveClientUseCase)
}

/**
 * Initializes Koin with a platform-specific [DatabaseDriverFactory].
 */
fun initKoin(driverFactory: DatabaseDriverFactory) {
    org.koin.core.context.startKoin {
        modules(
            module { single { driverFactory } },
            sharedModule
        )
    }
}
