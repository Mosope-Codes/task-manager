# Task Manager Application

## Description

Welcome to Task Manager Application for managing tasks.

## API Documentation

[Click here](https://documenter.getpostman.com/view/19639188/2s9YsT6TrG) to view the API documentation.

## Key Features

- CRUD Operations
- Pagination 

## Getting Started

### Prerequisites

- [Java 17](https://www.oracle.com/java/technologies/downloads/#java17)
- [Maven](https://maven.apache.org/download.cgi)
- [PostgreSQL](https://www.postgresql.org/download/)

### Installation

1. Clone the repo

   ```sh
   git clone

   ```

2. Install Maven dependencies

   ```sh
    mvn install
   ```

3. Create a PostgreSQL database

   ```sh
   createdb task_management
   ```

## Usage

### Running the Application

1. Update src\main\resources\application.properties with your database credentials

2. Start the backend server
   ```sh
   mvn spring-boot:run
   ```
3. Navigate to http://localhost:8000/