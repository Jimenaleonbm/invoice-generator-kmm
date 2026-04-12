# Set up Kotlin Multiplatform boilerplate project

We need to set up a basic starter project for the Kotlin Multiplatform invoice generator application. The project should have support for Android (Jetpack Compose UI), iOS (SwiftUI), and a shared module for business logic. Include a Gradle build setup and an appropriate directory structure as described in the discussions.

### Tasks:
1. Initialize the Kotlin Multiplatform project using a KMM template.
2. Set up modules for shared, Android, and iOS targets.
3. Include configurations for a shared library with SQLDelight for persistence.
4. Add basic directories for business logic, models, and platform-specific code.
5. Test the build and ensure it works for both targets (Android and iOS).

### Acceptance Criteria:
- The repository contains a basic KMM project structure.
- Both Android and iOS targets build successfully.
- A basic shared module exists with example code.