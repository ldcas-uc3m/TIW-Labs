# Laboratorios de Tecnologías Informáticas para la Web
By Luis Daniel Casais Mezquida  
Tecnologías Informáticas para la Web 23/24  
Bachelor's Degree in Computer Science and Engineering  
Universidad Carlos III de Madrid


## Laboratorio 1: Servlets
El objetivo subyacente de este laboratorio es el desarrollo y configuración de una aplicación Web Dinamica (*.war)

## Laboratorio 2: JSPs
El objetivo subyacente de este laboratorio es el desarrollo y configuración de una aplicación Web Dinamica (*.war)

## Laboratorio 3: JDBC I
El objetivo es el primer acceso a una BBDD vía JDBC y se deja al alumn@ la generación de la salida vía una JSP.

## Laboratorio 4: JDBC II
Se pretende con este Lab que el alumno utlice JDBC y acceda a la BBDD en MySQL también mediante pool de conexiones (DataSource)


## Instalación del entorno.

El proyecto está desarrollado y pensado para ejecutarse en Eclipse con Payara, recomendamos las versiones específicas.  
Para importar el proyecto:
1. Descarga e instala [Java SE 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
2. Descarga e instala [Eclipse IDE for Enterprise Java and Web Developers 2023-09](https://www.eclipse.org/downloads/packages/release/2023-09/r/eclipse-ide-enterprise-java-and-web-developers)
3. Descarga y descomprime [Payara-5.2022.3](
https://nexus.payara.fish/#browse/browse:payara-community:fish%2Fpayara%2Fdistributions%2Fpayara%2F5.2022.3%2Fpayara-5.2022.3.zip)
3. Instala [Payara Tools para Eclipse](https://marketplace.eclipse.org/content/payara-tools), preferiblemente desde el Eclipse Marketplace (en Eclipse: `Help` → `Eclipse Marketplace` → `Search` → `Find` y escribir "`Payara Tools`" → `Install`)
4. Crea un servidor de Payara:
    1. Abre la vista `Servers` en `Window` → `Show View` → `Other` → `Server` → `Server`.
    2. Ve a la vista `Servers` (abajo) y haz clic en `No servers are available. Click this link to create new server...` → `Payara` → `Payara`, y selecciona la versión 17 de Java y la dirección de la carpeta de payara (`payara5/`).

## Ejecución
En Eclipse:
    1. Importa el proyecto deseado desde `File` → `Open Projects From File System...` → `Directory` → <projecto deseado, e.g `<path-to>tiwclase1/`> → `Finish`.
    2. Asegúrate de tener seleccionado el proyecto y haz clic en `Run` → `Run As` → `Run on Server` y selecciona tu servidor de Payara.
