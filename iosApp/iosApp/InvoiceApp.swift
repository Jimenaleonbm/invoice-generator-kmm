import SwiftUI
import shared

@main
struct InvoiceApp: App {
    
    init() {
        // Initialize Koin
        KoinModuleKt.doInitKoin(driverFactory: DatabaseDriverFactory())
    }
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}
