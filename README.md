# 🚀 Postify - Share & Connect

Welcome to **Postify - Share & Connect**, an interactive web application where users can create posts, comment, and participate in raffles. Engage with others, customize your profile, and enjoy a seamless social experience. 💬🎉

---

## 📌 Features
- ✍️ **Create & Share**: Post your thoughts and engage with others.
- 💬 **Comments & Replies**: Interact with posts through comments and replies.
- 🎟️ **Raffles & Rewards**: Participate in exciting raffles.
- 🎨 **Customizable Profiles**: Personalize your experience.

---

## 📂 Project Structure
```
└── 📁src  
    └── 📁main  
        └── 📁java  
            └── 📁com  
                └── 📁brayanalmengor04  
                    └── 📁postifyv1  // 📌 Main package of the Postify backend  
                        └── 📁config  // 📌 Contains general system configurations  
                            └── SecurityConfig.java  // 🔒 Security configuration using Spring Security  
                        └── 📁controller  // 📌 Controllers handling HTTP requests  
                            └── AuthController.java  // 🔑 Handles authentication and session management  
                            └── CommentController.java  // 💬 Manages comments  
                            └── ReplyController.java  // 🔄 Manages replies to comments  
                            └── RoleController.java  // 🎭 Manages user roles and permissions  
                            └── UserController.java  // 👤 Manages user-related operations  
                        └── 📁dto  // 📌 DTO (Data Transfer Object) classes for data transfer between layers  
                            └── CommentDTO.java  // 💬 DTO for comment data  
                            └── ReplyDTO.java  // 🔄 DTO for reply data  
                            └── UserDTO.java  // 👤 DTO for user data  
                        └── 📁entity  // 📌 Entity classes representing database models  
                            └── Comment.java  // 💬 Entity for comments  
                            └── Reply.java  // 🔄 Entity for replies  
                            └── Role.java  // 🎭 Entity for user roles  
                            └── User.java  // 👤 Entity for users  
                        └── 📁enums  // 📌 Enumerations used in the system  
                            └── Permission.java  // 🎭 Enum defining user permissions  
                        └── Postifyv1Application.java  // 🚀 Main class to start the Spring Boot application  
                        └── 📁repository  // 📌 Interfaces for database access  
                            └── CommentRepository.java  // 💬 Repository for comments  
                            └── ReplyRepository.java  // 🔄 Repository for replies  
                            └── RoleRepository.java  // 🎭 Repository for roles  
                            └── UserRepository.java  // 👤 Repository for users  
                        └── 📁security  // 📌 Security-related implementations  
                        └── 📁seeder  // 📌 Classes for inserting initial data into the database  
                            └── DatabaseSeeder.java  // 🌱 Seeds initial data (roles, users, etc.)  
                        └── 📁service  // 📌 Business logic and system rules  
                            └── CommentService.java  // 💬 Service for managing comments  
                            └── ICommentService.java  // 💬 Interface for comment service  
                            └── ImageService.java  // 🖼️ Service for handling images  
                            └── IReplyService.java  // 🔄 Interface for reply service  
                            └── IRoleService.java  // 🎭 Interface for role service  
                            └── IUserService.java  // 👤 Interface for user service  
                            └── ReplyService.java  // 🔄 Service for managing replies  
                            └── RoleService.java  // 🎭 Service for managing roles  
                            └── UserService.java  // 👤 Service for managing users  
                        └── 📁util  // 📌 Utility classes and helper functions  
        └── 📁resources  // 📌 Configuration files and application resources  
            └── application.properties  // ⚙️ General system configuration (database, logs, etc.)  
            └── logback-spring.xml  // 📜 Logback configuration for logging  
            └── 📁static  // 📌 Static files (images, CSS, JS)  
            └── 📁templates  // 📌 Templates (if using a view engine like Thymeleaf)  
    └── 📁test  // 📌 Unit and integration tests  
        └── 📁java  
            └── 📁com  
                └── 📁brayanalmengor04  
                    └── 📁postifyv1  
                        └── Postifyv1ApplicationTests.java  // ✅ Class for automated tests  

```

---

## ⚙️ Tech Stack
| **Category**    | **Technologies**             |
|----------------|-----------------------------|
| **Frontend**   | React, TailwindCSS          |
| **Backend**    | Spring Boot, REST API       |
| **Database**   | MySQL 8.0.3                  |

---

## 🚀 Getting Started
### 1️⃣ Clone the repositories
```bash
git clone https://github.com/brayanalmengor04/postify-backend.git
cd postify
```
For the frontend, clone the repository:
```bash
git clone https://github.com/brayanalmengor04/postify-frontend.git
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
---
## 🖼️ Screenshots
### 🔐 Login Page
![Login Page](github/demo/login.jpg)  
_Users can log in using their credentials to access the platform._

### 📊 Dashboard
![Dashboard](github/demo/dasboard.png)
_Overview of user activities, including posts, comments, and interactions._

### 💬 Comments Section
![Comments](github/demo/comentarios.png)
_Users can comment on posts and engage in discussions._

### 🆕 New User Registration
![New User](github/demo/newuser.png)
_New users can sign up and create an account to start posting._

---

## 📜 API Endpoints
### 🔐 Authentication
| Method | Endpoint               | Description   |
|--------|------------------------|---------------|
| POST   | /auth/signin           | User login    |
| POST   | /auth/signup           | User signup   |

### 💬 Comments
| Method | Endpoint              | Description          |
|--------|----------------------|----------------------|
| GET    | /comment             | Fetch all comments  |
| POST   | /comment-add         | Create a comment    |
| PUT    | /comment/{id}        | Update a comment    |
| DELETE | /comment/{id}        | Delete a comment    | 

### 💬 Replies
| Method | Endpoint             | Description           |
|--------|----------------------|-----------------------|
| GET    | /reply/all           | Fetch all replies     |
| POST   | /reply/user          | Create a reply        |
| GET    | /reply/user/{userId} | Fetch reply by userID |

### 🛡️ Roles
| Method | Endpoint             | Description       |
|--------|----------------------|-------------------|
| GET    | /role               | Get all roles    |
| POST   | /role-add           | Add a new role   |
| GET    | /role/{id}          | Get role by ID   |
| PUT    | /role/{id}          | Update a role    |
| DELETE | /role/{id}          | Delete a role    |

---
## 💡 Contributing
We welcome contributions to make **Postify** more efficient, clean, and maintainable! 🚀

### 🛠️ How You Can Help
We aim for a **clean code** approach, prioritizing readability, simplicity, and performance. Contributions can include:

- **Refactoring code** to enhance clarity and maintainability.
- **Optimizing database queries** for better performance.
- **Improving API efficiency** to reduce response times.
- **Enhancing security** by following best practices.
- **Writing comprehensive tests** to ensure stability.

### 📝 Contribution Guidelines
1. **Fork** the repository 🍴
2. **Create a feature branch** (`git checkout -b improve-backend`) 🌱
3. **Follow best practices** (SOLID principles, DRY, KISS) 📜
4. **Document your changes** clearly in the code 💡
5. **Commit changes** (`git commit -m 'Optimized backend query handling'`) 💾
6. **Push to branch** (`git push origin improve-backend`) 🚀
7. **Submit a Pull Request** with a clear explanation 📩

We encourage meaningful discussions and improvements. Let’s build a scalable and efficient platform together! 🔥
---
## 📜 License
This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for details.

---

**🚀 Join us and start sharing today! Let’s build something amazing together! 🔥**

