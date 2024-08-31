import SwiftUI
import shared

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        Main_iosKt.main()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {

	var body: some View {
        ComposeView().ignoresSafeArea(edges: .bottom)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        ContentView();
	}
}
