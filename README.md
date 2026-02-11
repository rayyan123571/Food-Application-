# 🍔 The 7th Bite – Food Delivery Android App

A fully functional food delivery application built with **Kotlin** in **Android Studio**. This app connects users with food vendors for seamless online ordering, payment, and delivery.

---

## 📱 Screenshots

<p align="center">
  <img src="Screen-Shots/screenshot1.png" width="200" alt="Splash Screen"/>
  <img src="Screen-Shots/screenshot2.png" width="200" alt="Dashboard"/>
  <img src="Screen-Shots/screenshot3.png" width="200" alt="Food Details"/>
  <img src="Screen-Shots/screenshot4.png" width="200" alt="Cart"/>
</p>

---

## ✨ Key Features

### User Features
- 🔐 **User Authentication** - Secure registration & login with Firebase
- 🏠 **Dashboard** - Browse food items by category (Burgers, Pizza, Drinks, etc.)
- 🔍 **Search** - Find food items with search history
- ❤️ **Favorites** - Save and manage favorite food items (persistent)
- 🛒 **Shopping Cart** - Add/remove items with quantity management (persistent)
- 💳 **Checkout** - Multiple payment options (Card/Cash on Delivery)
- 🗺️ **Location** - Google Maps integration for delivery address
- 🧾 **Order Bill** - Detailed bill generation after order

### Admin Features
- 📦 **Product Management** - Add, edit, and delete food items
- 📂 **Category Management** - Organize products by categories
- 🔑 **Admin Login** - Separate admin authentication

---

## 🛠️ Technologies Used

| Technology | Purpose |
|------------|---------|
| **Kotlin** | Primary programming language |
| **Android Studio** | Development IDE |
| **Firebase Auth** | User authentication |
| **Firebase Firestore** | Cloud database |
| **Google Maps API** | Location services |
| **Glide** | Image loading |
| **Lottie** | Animations |
| **ViewBinding** | View access |
| **SharedPreferences** | Local data persistence |
| **Gson** | JSON serialization |

---

## 📂 Project Structure

```
app/src/main/java/com/example/foodapplication/
├── FoodApplication.kt      # Application class - initializes managers
├── Food.kt                 # Data model for food items
├── FoodRepository.kt       # Central food data repository
├── FoodAdapter.kt          # RecyclerView adapter for food lists
│
├── dashboard.kt            # Main user dashboard
├── activity_search.kt      # Search functionality
├── activity_food_detail.kt # Food item details
│
├── CartManager.kt          # Shopping cart management (persistent)
├── CartAdapter.kt          # Cart RecyclerView adapter
├── MyCartActivity.kt       # Cart screen
├── CheckoutActivity.kt     # Checkout & payment
├── BillPageActivity.kt     # Order confirmation bill
│
├── FavoriteManager.kt      # Favorites management (persistent)
├── FavouriteActivity.kt    # Favorites screen
│
├── login_page.kt           # User login
├── signup.kt               # User registration
├── forgotpassword.kt       # Password recovery
│
├── admin_page.kt           # Admin dashboard
├── AddProductActivity.kt   # Add new products
├── EditFoodActivity.kt     # Edit existing products
│
├── MapActivity.kt          # Google Maps location picker
├── profile.kt              # User profile
├── Settings_page.kt        # App settings
└── NotificationPage.kt     # Notifications
```

---

## 🚀 Getting Started

### Prerequisites
- Android Studio Arctic Fox or later
- JDK 11 or higher
- Android SDK 24+ (minSdk)
- Google Maps API Key
- Firebase Project

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/rayyan123571/Food-Application-.git
   cd Food-Application-
   ```

2. **Open in Android Studio**
   - File → Open → Select the project folder

3. **Configure Firebase**
   - Create a Firebase project at [Firebase Console](https://console.firebase.google.com)
   - Add your Android app (package: `com.example.foodapplication`)
   - Download `google-services.json` and place in `app/` folder
   - Enable Authentication (Email/Password)
   - Enable Firestore Database

4. **Configure Google Maps**
   - Get API key from [Google Cloud Console](https://console.cloud.google.com)
   - Add key in `AndroidManifest.xml`:
     ```xml
     <meta-data
         android:name="com.google.android.geo.API_KEY"
         android:value="YOUR_API_KEY"/>
     ```

5. **Build and Run**
   ```bash
   ./gradlew assembleDebug
   ```

---

## 📋 Dependencies

```kotlin
// Core Android
implementation(libs.androidx.core.ktx)
implementation(libs.androidx.appcompat)
implementation(libs.material)
implementation(libs.androidx.constraintlayout)

// Navigation
implementation(libs.androidx.navigation.fragment.ktx)
implementation(libs.androidx.navigation.ui.ktx)

// Firebase
implementation(platform(libs.firebase.bom))
implementation(libs.firebase.auth.ktx)
implementation(libs.firebase.firestore.ktx)

// Google Services
implementation(libs.play.services.maps)
implementation(libs.play.services.location)

// Image Loading
implementation(libs.glide)
kapt(libs.compiler)

// Animations
implementation(libs.lottie)

// Utilities
implementation(libs.gson)
implementation(libs.circleimageview)
```

---

## 🔒 Security Notes

- Card CVV is **never stored** locally (PCI-DSS compliance)
- Only last 4 digits of card number are saved
- Firebase Authentication for secure login
- Admin credentials should be moved to Firebase Custom Claims for production

---

## 📝 Recent Updates

- ✅ Added persistent storage for Cart (survives app restart)
- ✅ Added persistent storage for Favorites (survives app restart)
- ✅ Fixed deprecated API usage (`packagingOptions` → `packaging`)
- ✅ Improved null safety to prevent crashes
- ✅ Strengthened password validation (8+ chars, uppercase, number required)
- ✅ Removed unused dependencies and imports
- ✅ Fixed security issue with CVV storage

---

## 👨‍💻 Contributors

- **Rayyan** - [@rayyan123571](https://github.com/rayyan123571)
- **Danish Butt** - Original Author

---

## 📄 License

This project is for educational purposes. 

> **⚠️ Academic Use Only** - No part of this codebase may be reused, copied, or modified without explicit permission.

---

## ⭐ Show Your Support

Give a ⭐ if this project helped you!
