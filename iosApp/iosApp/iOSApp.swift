import SwiftUI
import shared
@main
struct iOSApp: App {

    init() {
        KoinInitKt.koinInit(declaration: {(_) in })
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
