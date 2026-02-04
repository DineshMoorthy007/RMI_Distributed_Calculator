# Distributed RMI Calculator

A simple distributed calculator with a static frontend and a Spring Boot backend. The frontend provides a minimal UI for arithmetic operations and the backend exposes REST endpoints for the calculations.

## Repository Layout

- Frontend (static):
  - index.html
  - styles.css
  - script.js
- Backend (Spring Boot):
  - calculator-backend/

## Features

- Add, subtract, multiply, divide
- Spring Boot REST API
- JaCoCo coverage reports
- GitHub Actions CI with SonarQube analysis

## Prerequisites

- Java 21
- Maven 3.9+
- (Optional) Node.js only if you later add a build step for the frontend

## Local Development

### Backend

```bash
cd calculator-backend
mvn clean test
mvn spring-boot:run
```

The backend runs on http://localhost:8080.

### Frontend

Open index.html directly in a browser or use any static server. If your frontend is configured to call the backend, ensure the backend base URL matches where it is running.

## API Endpoints

Base URL: http://localhost:8080

- POST /api/calculator/add
- POST /api/calculator/subtract
- POST /api/calculator/multiply
- POST /api/calculator/divide

Request body:

```json
{ "a": 10, "b": 5 }
```

Response:

```json
{ "result": 15 }
```

## Coverage Reports

JaCoCo HTML reports are generated at:

```
calculator-backend/target/site/jacoco/index.html
```

In CI, the report is copied to the frontend output and is accessible at /coverage/index.html when deployed.

## GitHub Actions CI

The workflow is defined in .github/workflows/ci.yml and does the following:

1. Checks out the repo
2. Builds and tests the backend
3. Generates JaCoCo reports
4. Copies the HTML report to a coverage/ folder
5. Uploads the report as a build artifact
6. Runs SonarQube analysis

### Required GitHub Secrets

- SONAR_TOKEN
- SONAR_HOST_URL (required for self-hosted SonarQube)
- SONAR_PROJECT_KEY

## Deploying the Frontend on GitHub Pages

GitHub Pages can host the static frontend only (HTML/CSS/JS). The Java backend must be deployed separately (Render, Railway, Fly.io, etc.). Update the frontend API base URL to point to the backend deployment.

## License

MIT
