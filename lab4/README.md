# Laboratorio 4: JDBC


## Setup
1. [Install the enviroment](../README.md#instalación-del-entorno)
2. Download and install [MySQL Community Server 8.1.0](https://dev.mysql.com/downloads/mysql/) and, optionally, [MySQL Workbench](https://dev.mysql.com/downloads/workbench/).
3. Download the [MySQL Java driver](https://dev.mysql.com/downloads/connector/j/) and save the `mysql-connector-j-8.1.0.jar` to `<payara-path>/glassfish/lib`.
4. Start MySQL server (if it's not started already)
    - Linux
        ```bash
        $ sudo systemctl start mysqld
        ```
    - Windows (MySQL path is usually `C:\Program Files\MySQL\MySQL Server 8.X`)
        ```powershell
        C:\> & <mysql-path>\bin\mysqld
        ```
5. Create and import the database
    1. Access the MySQL console
        - Linux
            ```bash
            $ mysql -u root
            ```
        - Windows
            ```powershell
            C:\> & <mysql-path>bin\mysql -u root
            ```
        If you have set a password for root on installation (here we'll assume the password is `root`), add the flag `-proot`.
    2. Create a database `songsdb`
        ```sql
        mysql> CREATE DATABASE songsdb;
        ```
    3. If you haven't set a password already, set it up.
        ```sql
        mysql> ALTER USER 'root'@'localhost' IDENTIFIED BY 'root';
        mysql> FLUSH PRIVILEGES;
        ```
    4. Exit MySQL.
        ```sql
        mysql> exit;
        ```
    5. Use the [`songsdbCreate.sql`](songsdbCreate.sql) script to create the `songsdb` table inside of the `songsdb` database.
        - Linux
            ```bash
            $ mysql -u root -proot songsdb < <path-to>/songsdbCreate.sql
            ```
        - Windows
            ```powershell
            C:\> & <mysql-path>\bin\mysql -u root -proot songsdb
            ```
            ```sql
            mysql> source <path-to>\songsdbCreate.sql
            mysql> exit;
            ```
6. Configure Eclipse Database Connection `MySQL8.1.0-songsdb` to the `songsdb` MySQL database.
    1. Got to `Data Source Explorer` → Right-Click on `Database Connections` → `New...`
    2. Select `MySQL`, in `Name` put `MySQL8.1.0-songsdb`
    3. Click the icon for `New driver definition` to the right of `Drivers:` 
    4. Select `MySQL JDBC Driver 5.1`
    5. Go to `JAR List` → select `mysql-connector-java-5.1.0-bin.jar` → click on `Edit JAR/Zip...` and select the MySQL Driver (`mysql-connector-j-8.1.0.jar` in `<payara-path>/glassfish/lib`) → `OK`
    6. Fill up the form:
        - `Database`: `songsdb`
        - `URL`: `jdbc:mysql://localhost:3306/songsdb?serverTimezone=UTC`
        - `User name`: `root`
        - `Password`: `root`
        - Check `Save password`
    7. Click on `Test Connection` to check it works.
    8. Click on `Finish`
7. Setup the Connection Pool (CLI) in Payara
    1. Enter the Payara asadmin console
        - Linux
            ```bash
            sudo <payara-path>/bin/asadmin
            ```
        - Windows
            ```powershell
            C:\> & <payara-path>\bin\asadmin
            ```
    2. Launch a server in a domain
        ```
        asadmin> start-domain -d
        ```
    3. Create the JDBC Connection Pool `MySQL8.1.0_jdbc/songsdb` to the `songsdb` database.
        ```
        asadmin> create-jdbc-connection-pool --datasourceclassname com.mysql.cj.jdbc.MysqlConnectionPoolDataSource --restype javax.sql.ConnectionPoolDataSource --property 'user=root:password=root:databaseName=songsdb:serverName=localhost:portNumber=3306:url=jdbc\:mysql\://localhost\:3306/songsdb:useSSL=false:serverTimezone=UTC:allowPublicKeyRetrieval=true' MySQL8.1.0_jdbc/songsdb
        ```
        (Note that all `:` that are part of the property value need to be escaped by `\`, and for that to work it must be enclosed in quotes, as demonstrated above. More info [here](https://github.com/payara/Payara/issues/1252#issuecomment-268782829).)
    4. Test the connection pool
        ```
        asadmin> ping-connection-pool MySQL8.1.0_jdbc/songsdb
        ```
8. Setup the JDBC resource `jdbc/songsdb` connected to the `MySQL8.1.0_jdbc/songsdb` connection pool in Payara  
    (Assuming server is started and we're in the asadmin console)  
    ```
    asadmin> create-jdbc-resource --enabled=true --connectionpoolid MySQL8.1.0_jdbc/songsdb jdbc/songsdb
    ```
    ```
    asadmin> exit
    ```
