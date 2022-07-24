# ComtradeAssignment

---
Comtrade test Java based web application

## Description

To run build this project you will need:
- Java JDK
- Maven
````shell
.\mvnw clean install
````
Login credentials:
- username: admin
- password: admin

Following paths are available:
- / - homepage
- /hello?lang=[value] - displays "Hello World" in 10 different languages depending on input value
- /add-language - form for entering new language pairs
- /hello-api?lang=[value] - translates "Hello World" using API depending on language value