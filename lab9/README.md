# Laboratorio 9: JMS


## Setup
1. [Install the enviroment](../README.md#instalación-del-entorno)
2. Setup the JMS Connection Factory `jms/connectionfactory`
    1. Enter the Payara asadmin console (web): https://localhost:4848
    2. Go to Resources → JMS Resources → Connection Factories → New
    3. Fill up the form:
        - JNDI Name: `jms/connectionfactory`
        - Resource type: `javax.jms.ConnectionFactory`
3. Setup the JMS Resource `jms/labjms`
    1. Enter the Payara asadmin console (web): https://localhost:4848
    2. Go to Resources → JMS Resources → Destination Resource → New
    3. Fill up the form:
        - In JNDI Name put `jms/labjms`
        - Physical destination: `aaaa`
        - Resource type: `javax.jms.Queue`

## Run
1. Run the project in Eclipse












4. Run the project in Eclipse and Payara