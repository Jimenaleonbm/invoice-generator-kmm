# invoice-generator-kmm

An offline invoice generator using Kotlin Multiplatform for Android and iOS.

## Project Structure

```
invoice-generator-kmm/
├── shared/                  # KMM shared module
│   └── src/
│       ├── commonMain/      # Common business logic
│       │   └── kotlin/com/invoicegenerator/
│       │       ├── data/
│       │       │   ├── db/           # SQLDelight database setup
│       │       │   └── repository/   # Repository interfaces & implementations
│       │       ├── domain/
│       │       │   ├── model/        # Domain models (Invoice, Client, etc.)
│       │       │   └── usecase/      # Business use cases
│       │       └── util/             # Koin DI module
│       ├── androidMain/     # Android-specific implementations
│       └── iosMain/         # iOS-specific implementations
├── androidApp/              # Android application (Jetpack Compose)
└── iosApp/                  # iOS application (SwiftUI)
```

## Technology Stack

- **Kotlin Multiplatform Mobile (KMM)** — shared business logic across Android & iOS
- **Jetpack Compose** — Android UI
- **SwiftUI** — iOS UI
- **SQLDelight** — Cross-platform SQL database (offline persistence)
- **Koin** — Dependency injection

## Getting Started

### Android

1. Open the project in Android Studio (Hedgehog or newer).
2. Select the `androidApp` run configuration.
3. Run on an emulator or device (API 26+).

### iOS

1. Run `./gradlew :shared:assembleXCFramework` to build the shared framework.
2. Open `iosApp/iosApp.xcodeproj` in Xcode 14+.
3. Run on an iPhone simulator (iOS 16+).

## Building

```bash
# Build the shared module
./gradlew :shared:build

# Run shared module tests
./gradlew :shared:allTests

# Build Android app
./gradlew :androidApp:assembleDebug
```

