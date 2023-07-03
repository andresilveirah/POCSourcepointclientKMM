import SwiftUI
import POCSourcepointClient

struct ContentView: View {
    @ObservedObject private(set) var viewModel = ViewModel()

	var body: some View {
        Text(viewModel.text)
	}
}

extension ContentView {
    class ViewModel: ObservableObject {
        @Published var text = "Loading..."
        let coordinator = SourcepointCoordinator(platform: PlatformSpecific())

        init() {
            coordinator.greet { greeting, error in
                DispatchQueue.main.async {
                    if let greeting = greeting {
                        self.text = greeting
                    } else {
                        self.text = error?.localizedDescription ?? "error"
                    }
                }
            }
        }
    }

}
