import SwiftUI

struct InvoiceListView: View {
    var body: some View {
        List {
            Text("No invoices yet")
                .foregroundColor(.secondary)
        }
        .navigationTitle("Invoices")
        .toolbar {
            ToolbarItem(placement: .navigationBarTrailing) {
                Button(action: {}) {
                    Image(systemName: "plus")
                }
            }
        }
    }
}

struct InvoiceListView_Previews: PreviewProvider {
    static var previews: some View {
        NavigationView {
            InvoiceListView()
        }
    }
}
