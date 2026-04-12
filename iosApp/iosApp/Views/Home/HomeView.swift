import SwiftUI

struct HomeView: View {
    var body: some View {
        VStack(spacing: 24) {
            Spacer()
            Image(systemName: "doc.text.fill")
                .resizable()
                .frame(width: 80, height: 80)
                .foregroundColor(.blue)
            Text("Invoice Generator")
                .font(.largeTitle)
                .fontWeight(.bold)
            Text("Create and manage your invoices offline")
                .font(.body)
                .foregroundColor(.secondary)
                .multilineTextAlignment(.center)
                .padding(.horizontal)
            Spacer()
            NavigationLink(destination: InvoiceListView()) {
                Text("View Invoices")
                    .frame(maxWidth: .infinity)
                    .padding()
                    .background(Color.blue)
                    .foregroundColor(.white)
                    .cornerRadius(12)
                    .padding(.horizontal)
            }
            Spacer()
        }
        .navigationTitle("Home")
        .navigationBarTitleDisplayMode(.inline)
    }
}

struct HomeView_Previews: PreviewProvider {
    static var previews: some View {
        NavigationView {
            HomeView()
        }
    }
}
