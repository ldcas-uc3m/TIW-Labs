



## Setup
1. Download [MySQL 8.1.0] and [MySQL Workbench](https://dev.mysql.com/downloads/workbench/)
2. Download the [MySQL driver](https://dev.mysql.com/downloads/connector/j/) and save the `mysql-connector-j-8.1.0.jar` to `<PAYARA_PATH>/glassfish/lib`
3. Start MySQL
   ```
   sudo systemctl start mysqld
   ```
4. Create and import the database
    ```bash
    $ mysql -u root
    ```
    ```
    mysql> CREATE DATABASE songsdb;
    mysql> ALTER USER 'root'@'localhost' IDENTIFIED BY 'root';
    mysql> FLUSH PRIVILEGES;
    mysql> exit;
    ```
    ```bash
    $ mysql -u root -p songsdb < songsdbCreate.sql
    # the password is 'root'
    ```
5. Setup the connection pool
    1. Run the payara server
    2. Access the admin console at https://localhost:4848
    <!-- TODO -->
6. Setup a JDBC resource
    <!-- TODO -->
7. Configure eclipse DataBase Connection
    <!-- TODO -->