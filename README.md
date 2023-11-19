# Graminconnect

Graminconnect is a full-stack software application designed to address the healthcare challenges faced by rural communities in India. It provides a centralized platform for ASHA workers to manage medicine delivery orders, track pharmacy locations, attend emergency calls, and provide first aid assistance. Graminconnect also facilitates AI-assisted telemedicine, connecting patients with expert doctors via the e-sanjeevani app. The application utilizes Firebase Cloud Firestore for data storage, Firebase Auth with OTP for user authentication, and Bing Map API for location tracking.

## Features

* **Medicine Delivery Management:**
    * View and accept medicine delivery orders
    * Track delivery status and pharmacy locations
    * Update order status and delivery timestamps

* **Emergency Call Handling:**
    * Receive and respond to emergency calls from patients
    * Verify call details and assess the need for immediate assistance
    * Provide initial guidance and instructions until arrival at the kiosk

* **First Aid Assistance:**
    * Access and unlock the first aid section of the kiosk upon receiving an emergency call
    * Utilize available first aid supplies and provide necessary medical attention
    * Record patient information and first aid procedures in Cloud Firestore

* **Performance Tracking:**
    * Monitor personal performance metrics, including orders handled, emergency calls attended, and first aid provided
    * Analyze trends and identify areas for improvement
    * Receive recognition and incentives for outstanding contributions

* **AI-Assisted Telemedicine:**
    * Connect patients with expert doctors via the e-sanjeevani app for AI-powered initial consultations and expert doctor consultations

## Technologies

* **Android Studio:** IDE for developing Android applications
* **Kotlin:** Programming language for Android development
* **Jetpack Compose:** Modern toolkit for building native UI with less code
* **WebView:** Android component for displaying web content, used for integrating Bing Map
* **Firebase Cloud Firestore:** NoSQL database for storing user data, medicine orders, patient information, pharmacy locations, and emergency call details.
* **Firebase Auth with OTP:** Secure user authentication using one-time passwords (OTPs)
* **Bing Maps API:** Enables real-time tracking of ASHA worker locations and pharmacy locations on a map.

## Installation

To install and run the Graminconnect Android application, follow these steps:

1. Clone the Graminconnect repository from GitHub:

   ```bash
   git clone https://github.com/karthidreamr/graminconnect.git
   ```

2. Open the Graminconnect project in Android Studio.

3. Configure Firebase and Bing Maps API keys in the project's build.gradle file.

4. Connect your Android device to your computer and run the Graminconnect application in Android Studio.

## Usage

Once the Graminconnect application is installed and running, you can access its features by following these steps:

1. Launch the Graminconnect application on your Android device.

2. Login using your ASHA worker credentials.

3. The Graminconnect dashboard will be displayed, providing access to all the application's features.

4. To manage medicine delivery orders, navigate to the Medicine Delivery section of the dashboard.

5. To handle emergency calls, navigate to the Emergency Calls section of the dashboard.

6. To provide first aid assistance, navigate to the First Aid section of the dashboard.

7. To access AI-assisted telemedicine, navigate to the Telemedicine section of the dashboard.

## Contributing

If you are interested in contributing to the Graminconnect project, please follow the guidelines in the CONTRIBUTING.md file.

## License

Graminconnect is licensed under the MIT License. For more information, please refer to the LICENSE file.
