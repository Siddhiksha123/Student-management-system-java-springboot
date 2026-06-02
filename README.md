Once the server is running, open your web browser and go to this URL: 👉 http://localhost:8080/api/v1/swagger-ui/index.html (Note: included /api/v1 because that is our configured context path).




### Configured Static Authentication Credentials

**Before:**
When Spring Security was added to the project, it automatically generated a random security password in the console logs every time the application started, using the default username `user`. This was inconvenient for testing because the password changed on every restart.

**After:**
We overrode Spring Security's default behavior by hardcoding a static username and password in the `application.properties` file:
- **Username:** `swati`
- **Password:** `password123`

**Impact:**
- The application no longer generates random passwords in the console on startup.
- We can consistently test our secured endpoints (like POST/DELETE) in Postman or Swagger UI using these fixed credentials.

What to do next:
Restart your Spring Boot application (you will notice it no longer prints the generated password in the console).

<img width="952" height="398" alt="image" src="https://github.com/user-attachments/assets/08205cea-f061-4c49-83ca-1613fdba0a07" />


<img width="801" height="610" alt="image" src="https://github.com/user-attachments/assets/8abb18b0-231b-41ca-9042-b11c44ead0c6" />
