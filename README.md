# Firebase Auth Tutorial 🔥

**Firebase Example** is a concise Android educational project designed to demonstrate how to implement **Authentication** using **Firebase** and **Jetpack Compose**. This repository serves as a practical tutorial for handling user registration, login flows, and protected screens in a modern Android application.

## 📺 Tutorial & Demo (French)

This project is accompanied by a video tutorial explaining the implementation details.

**[🎥 Watch the Presentation / Tutorial Video](https://youtu.be/q3qNXi5R8Dc)**

> **Note:** The video commentary and explanation are in **French** 🇫🇷.

## ✨ Features

* **User Registration**: detailed Sign-Up screen allowing new users to create an account using Email and Password.
* **Authentication**: Secure Sign-In interface with error handling (wrong password, user not found).
* **Protected Home Screen**: A secured dashboard that is only accessible to authenticated users.
* **State Management**: seamless UI state handling using `ViewModel` and `StateFlow`.
* **Modern UI**: Built entirely with **Jetpack Compose** and Material Design 3.

## 🛠️ Tech Stack

* **Language**: [Kotlin](https://kotlinlang.org/)
* **UI Framework**: [Jetpack Compose](https://developer.android.com/jetpack/compose)
* **Backend**: [Firebase Authentication](https://firebase.google.com/docs/auth)
* **Architecture**: MVVM (Model-View-ViewModel)
* **Navigation**: Android Navigation Compose

## 🚀 Getting Started

Follow these steps to get the project running on your local machine.

### Prerequisites

* Android Studio (latest stable version recommended)
* JDK 11 or higher
* A Firebase Console account

### Installation

1.  **Clone the repository**
    ```bash
    git clone [https://github.com/your-username/firebase-example.git](https://github.com/your-username/firebase-example.git)
    ```

2.  **Firebase Configuration (Crucial Step)**
    * Go to the [Firebase Console](https://console.firebase.google.com/).
    * Create a new project.
    * Add an Android app with the package name: `com.company.firebaseexample` (check your `AndroidManifest.xml` to confirm).
    * **Enable Authentication**: Go to Build > Authentication > Sign-in method and enable **Email/Password**.
    * Download the `google-services.json` file.
    * **Move the file**: Place `google-services.json` into the `app/` directory of your project.

3.  **Build and Run**
    * Open the project in Android Studio.
    * Let Gradle sync the dependencies.
    * Run the app on an emulator or physical device.

## 📂 Project Structure

* **`ui/screens/signup`**: Contains the UI and logic for registering a new user.
* **`ui/screens/signin`**: Contains the UI and logic for logging in.
* **`ui/screens/home`**: The destination screen after a successful login.
* **`ui/theme`**: definitions for colors, typography, and themes.
