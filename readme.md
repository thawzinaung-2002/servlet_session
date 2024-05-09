# Log in, Log out controlled by Servlet and Session
### Requirements
* Eclipse J2EE IDE
* JDK 21
* Apache Tomcat 10.1
* Servlet Technology
* Application Scope
* Session Scope 
### How does it work?
* It is just log in, log out controlled by session
- Registered users is stored in application scope by Generics (ArrayList<User>)
- Logged in user is stored in session scope 
- After logged out, user will be deleted from both
