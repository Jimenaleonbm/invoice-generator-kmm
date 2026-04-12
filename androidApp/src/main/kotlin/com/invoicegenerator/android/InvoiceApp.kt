package com.invoicegenerator.android

import android.app.Application
import com.invoicegenerator.data.db.DatabaseDriverFactory
import com.invoicegenerator.util.initKoin
import org.koin.android.ext.koin.androidContext

class InvoiceApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin(DatabaseDriverFactory(this))
    }
}
