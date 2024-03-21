# MVC vs WebFlux Performance Test: Simple Web Crawler Module

## Module Features:

- **POST Endpoint**: Crawls titles from websites and saves them in the database.
- **GET Endpoint**: Retrieves the first data from the database.

## Test:

- Send GET and POST requests to each module simultaneously with 1000 threads (users).
- Evaluate the scalability and throughput of each module when handling multiple concurrent requests.
- Use MongoDB
- Use Apache benchmark and Wrk

## Result Summary

- **There is no significant difference when concurrency is low, but as the concurrency increases, webflux looks better
  in stability and response speed**