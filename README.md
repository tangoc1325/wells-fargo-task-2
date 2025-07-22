# Wells Fargo Financial Portfolio Management Demo

I built this financial portfolio management system for the Wells Fargo Forage simulation using Spring Boot and React. It demonstrates full CRUD operations for Advisors and Clients, and shows how to connect a modern frontend to a Java backend using REST APIs.

## Features
- Add, edit, and delete financial advisors
- Add, edit, and delete clients (each assigned to an advisor)
- View all advisors and their clients in a visually organized dashboard
- Clean, modern UI with React
- Data stored in a relational database (H2, in-memory for demo)
- Well-commented code and clear project structure

## Tech Stack
- **Backend:** Java, Spring Boot, Spring Data JPA, H2 Database
- **Frontend:** React (Create React App), Fetch API, CSS

## Setup Instructions

### Backend (Spring Boot)
1. Make sure Java 17 and Maven are installed.
2. In the project root, run:
   ```
   ./mvnw spring-boot:run
   ```
3. The backend will start on [http://localhost:8080](http://localhost:8080)

### Frontend (React)
1. Open a new terminal and navigate to the `dashboard` directory:
   ```
   cd dashboard
   npm install
   npm start
   ```
2. The frontend will start on [http://localhost:3000](http://localhost:3000)

## Screenshots
![Dashboard Screenshot](./screenshots/your-screenshot.png)

## Project Structure
```
- src/        (Spring Boot Java code)
- dashboard/  (React frontend)
```

## Notes
- The backend uses an in-memory H2 database, so data will reset when the server restarts.
- CORS is enabled for local development.
- For a production system, you would use a persistent database and add authentication.

## Author
Ngoc Ta