# 🚀 Postify - Share & Connect

Welcome to **Postify - Share & Connect**, an interactive web application that allows users to create and participate in raffles. Users can engage with others by commenting, reacting, and customizing their profiles. This platform ensures a secure and intuitive experience for all users.

## 📌 Features

### 🔐 **Authentication & User Management**
- ✅ User registration and login with secure authentication.
- 🔄 Password recovery via email.
- 🛡️ Role-based access: **Admin** & **Regular User**.
- 👤 Profile customization with photo upload.

### 💬 **Comments & Interactions**
- 📜 Users can post and view comments.
- ✏️ Edit, delete, and reply to comments.
- ❤️ Like / 👎 Dislike system for comments.
- 🔗 See personal comment history.
- 🔍 View other users' profiles and their comments.

### 🎟️ **Raffles System**
- 🎯 Users can create public or private raffles.
- 🎟️ Purchase or receive raffle tickets.
- 🎉 Automatic winner selection system.
- 📢 Share raffles with other users.

### 🚨 **Security & Permissions**
- 🛡️ Only users can edit/delete their own comments.
- 👑 Admins can manage all users and content.
- 🔒 Secure API with token-based authentication.

## 📂 Project Structure
```plaintext
/postify-backend
│── .idea/                    # IntelliJ project settings
│── .mvn/                     # Maven wrapper
│── src/
│   ├── main/
│   │   ├── java/com/brayanalmengor04/postify/
│   │   │   ├── config/       # Configuration classes
│   │   │   ├── controller/   # REST Controllers
│   │   │   │   ├── IndexPrueba.java
│   │   │   ├── entity/       # Entity models
│   │   │   │   ├── Role.java
│   │   │   ├── enums/        # Enumerations
│   │   │   ├── repository/   # Data access layer
│   │   │   ├── security/     # Security configuration
│   │   │   ├── service/      # Business logic
│   │   │   ├── PostifyApplication.java  # Main application class
│   │   ├── resources/        # Static resources
│   ├── test/                 # Test cases
│── target/                   # Compiled output
│── .gitignore                 # Git ignore rules
│── .gitattributes             # Git attributes
│── docker-compose.yml         # Docker configuration
│── README.md                  # Project overview
```
## ⚙️ Tech Stack
- **Frontend:** React, TailwindCSS
- **Backend:** Spring Boot, REST API
- **Database:** MySQL 8.0.3
- **Authentication:** JWT (JSON Web Token)

## 🚀 Getting Started
### 1️⃣ Clone the repository
```bash
git clone https://github.com/yourusername/postify.git
cd postify
```

### 2️⃣ Backend Setup
```bash
cd backend
mvn spring-boot:run
```

### 3️⃣ Frontend Setup
```bash
cd frontend
npm install
npm run dev
```

## 📜 API Endpoints
### 🔐 Authentication
| Method | Endpoint        | Description          |
|--------|----------------|----------------------|
| POST   | `/auth/login`  | User login          |
| POST   | `/auth/signup` | Register new user   |
| POST   | `/auth/logout` | User logout         |

### 💬 Comments
| Method | Endpoint       | Description             |
|--------|---------------|-------------------------|
| GET    | `/comments`   | Fetch all comments     |
| POST   | `/comments`   | Create a new comment   |
| PUT    | `/comments/:id` | Edit a comment      |
| DELETE | `/comments/:id` | Delete a comment   |

## 📌 Roadmap
- [x] User authentication ✅
- [x] Comment system ✅
- [ ] Raffle creation 🛠️
- [ ] Ticket purchasing system 🛠️
- [ ] Admin dashboard 🛠️

## 💡 Contributing
Want to contribute? Follow these steps:
1. **Fork** the project 🍴
2. **Create a new branch** (`git checkout -b feature-branch`) 🌱
3. **Commit changes** (`git commit -m 'New feature added'`) 💾
4. **Push to branch** (`git push origin feature-branch`) 🚀
5. **Submit a Pull Request** 📩

## 📜 License
This project is licensed under the **MIT License**. See the `LICENSE` file for details.

---
**Let's build something amazing together! 🚀🔥**