## Instalation
1. Install [Maven](https://maven.apache.org/install.html) and [Java SE 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) (or [OpenJDK 17](https://openjdk.org/projects/jdk/17/)).
2. Remember to set the `JAVA_HOME` environment variable.
3. Download and install [MongoDB](https://www.mongodb.com/) and, optionally, [MongoDB Compass](https://www.mongodb.com/products/tools/compass).
4. Create the MongoDB `mensajes` collection inside the `mschat` database.
    - In Linux:
        ```bash
        mongosh --file db_create.js
        ```
5. (OPTIONAL) Install [Postman](https://www.postman.com/downloads/). If you're using Linux, make sure to also install `openssl`.


### VSCode extensions (optional)
- [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
- [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack)



## Execution
1. Remember to launch MongoDB.
2. Run the WS with:
    - Linux
        ```bash
        mvn spring-boot:run
        ```
    - Windows (PowerShell)
        ```powershell
        & .\mvnw.cmd spring-boot:run
        ```


Use GET request http://localhost:8030/mensajes.

<!-- You can import the collection [`labspringsecurity.postman_collection.json`](equiposWS.postman_collection.json) into [Postman](https://www.postman.com) in order to run the predefined requests (you could also use `curl` to generate the requests). -->
