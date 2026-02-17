# customer-complaint-tracking-system(ccts) – Backend

a robust and scalable **customer complaint tracking system** backend application built using **Java spring Boot** 
this system allows organizations to efficiently manage customer complaints through tickets, projects, categories, coments, and users.

---

## tech stack

- Java 17+
- spring Boot
- spring Web
- spring Data Jpa
- hibernate
- restful apis
- maven
- mysQL / h2 (configurable)

---

##  project architecture

the project follows a layered architecture:

```
        com.cts.springapp
        │
        ├── controller  
        ├── exception    
        ├── service      
        ├── repository   
        ├── model       
        └── config       
```

---

## Features

- create, update, delete, and retrieve users
- manage complaint tickets
- categorize complaints
- add and manage coments
- project management support
- pagination support
- sorting support
- restful api design
- proper htp status handling

---



#  api endpoints


## 1 - User apis  
**Base UrL:** `/api/users`

| method | endpoint | Description |
|--------|----------|------------|
| POST | `/` | create new user |
| GET | `/` | GET all users |
| GET | `/{id}` | GET user by iD |
| PUT | `/{id}` | Update user |
| GET | `/email/{email}` | GET user by email |
| GET | `/role/{role}` | GET users by role |
| GET | `/sortBy/{field}` | sort users by field |
| GET | `/page/{page}/{size}` | pagination |
| GET | `/page/{page}/{size}/{field}` | pagination + sorting |

---

## 2 - ticket apis  
**Base UrL:** `/ticket`

| method | endpoint | Description |
|--------|----------|------------|
| POST | `/add` | create ticket |
| GET | `/{id}` | GET ticket by iD |
| DELETE | `/delete/{id}` | Delete ticket |
| DELETE | `/delete/all` | Delete all tickets |
| GET | `/pages/{page}/{size}` | pagination |
| GET | `/sorted/{field}` | sort tickets |

---

## 3 - category apis  
**Base UrL:** `/category`

| method | endpoint | Description |
|--------|----------|------------|
| POST | `/add` | add category |
| GET | `/all` | GET all categories |
| GET | `/{id}` | GET category by iD |
| GET | `/{name}` | GET category by name |
| PUT | `/update/{id}` | Update category |
| DELETE | `/delete/{id}` | Delete category |
| DELETE | `/delete/all` | Delete all categories |
| GET | `/sorted/{field}` | sort categories |
| GET | `/{page}/{size}` | pagination |
| GET | `/{page}/{size}/{field}` | pagination + sorting |

---

## 4 - coment apis  
**Base UrL:** `/coment`

| method | endpoint | Description |
|--------|----------|------------|
| PUT | `/add` | add coment |
| GET | `/all` | GET all coments |
| GET | `/{id}` | GET coment by iD |
| DELETE | `/delete/{id}` | Delete coment |
| DELETE | `/delete/all` | Delete all coments |
| GET | `/sorted/{field}` | sort coments |
| GET | `/author/sorted` | sort coments by author |
| GET | `/{page}/{size}` | pagination |
| GET | `/{page}/{size}/{field}` | pagination + sorting |

---

## 5 - project apis  
**Base UrL:** `/`

| method | endpoint | Description |
|--------|----------|------------|
| PUT | `/add` | add project |
| GET | `/all` | GET all projects |
| GET | `/{id}` | GET project by iD |
| PUT | `/{id}` | Update project |
| DeLete | `/delete/{id}` | Delete project |
| DeLete | `/delete/all` | Delete all projects |
| GET | `/sorted/{field}` | sort projects |
| GET | `/{page}/{size}` | pagination |
| GET | `/{page}/{size}/{field}` | pagination + sorting |

---
#  setup & installation

##  clone repository

```bash
git clone htps://github.com/your-username/your-repo-name.git
cd your-repo-name
```

##  configure Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/cts
spring.datasource.username=root
spring.datasource.pasword=yourpasword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

##  Build & run

```bash
mvn clean install
mvn spring-boot:run
```

application runs at:

```
htp://localhost:8080
```
##  testing apis
 tested via postman




##  Fork and Contribute

Thank you for your interest in contributing! Follow these simple steps:

### 1. Fork the Repository
Click the **Fork** button at the top right of this repository on GitHub.  
This creates a copy under your GitHub account.

### 2. Clone Your Fork
```bash
git clone https://github.com/your-username/your-forked-repo.git
cd your-forked-repo
```

### 3. Create a New Branch
```bash
git checkout -b feature/your-feature-name
```

### 4. Make Your Changes
Edit the code and test your changes properly.

### 5. Commit and Push
```bash
git add .
git commit -m "Add: short description of your changes"
git push origin feature/your-feature-name
```

### 6. Create a Pull Request
Go to your fork on GitHub and click **Compare & Pull Request**, then submit it.

---

###  Contribution Guidelines

- Do not push directly to `main`
- Write clear commit messages
- Follow clean coding practices
- Test your changes before submitting

.
.
.


#  author
vidhesh parthiv.s aka `Zack Digits`


#  license

this project is licensed under the mit License

# in need 
hello mates if any one can add jwt that would be really appreciated and thank you for reading it. I hope ill get a pull request 
