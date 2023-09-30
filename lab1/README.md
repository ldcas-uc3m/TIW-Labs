# Laboratorio 1: Servlets
Hay provisto un archivo [`tiwclase1.war`](tiwclase1.war) que se utiliza como punto de partida para esta hoja de ejercicios. La solución se encuentra en [`tiwclase1_sols.war`](tiwclase1_sols.war)

## Ejercicio 1 - Familiarizándonos con el Deployment Descriptor (web.xml)

El proyecto tiene un documento HTML llamado 1-servlets.html.  
Crea o modifica archivo web.xml para que la página de bienvenida de la aplicación a web sea esa página HTML. El archivo web.xml se encuentra siempre en la carpeta webapp/WEB-INF.

> **Hints:** utiliza los tags `<welcome-file-list>` y `<welcome-file>`.

Comprueba que al ejecutar la aplicación web la siguiente url muestra la página esperada: http://localhost:8080/tiwclase1/


## Ejercicio 2 - El Servlet multipropósito
Crea un nuevo Servlet llamado `SongCreateServlet` que responde a las peticiones de tipo `GET` y `POST` a las
urls con formato `/SongCreate` y `/SongCreation` . Para ello, crea una nueva clase con el nombre propuesto y
modifica el web.xml de forma que ambas urls dirijan peticiones a la clase que hemos creado
(`SongCreateServlet`).

> 🧐 **Hint:** en el deployment descriptor, usa `<servlet>` para definir el nombre del servlet y la clase asociada este (con `<servlet-name>` y `<servlet-class>` ) . Utiliza luego `<servlet-mapping>` para describir las urls a las que responderá el nuevo servlet ( enlazando un `<servlet-name>` con un `<url-pattern>` ).

El comportamiento del Servlet será el siguiente:
- Al realizar una petición de tipo `GET`, el Servlet devolverá el siguiente código generado de forma dinámica implementando el método `doGet()`:
    ```html
    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="UTF-8">
        <title>[TIW] Ejercicio 1 - SongCreate</title>
    </head>
    <body>
    <h1> Provide information for a new song: </h1>
    <hr/>
    <form method="post" >
        <label for='f1'> Song Name:</label>
        <input type='text' id='f1' name='songName'/>
        <br/>
        <label for='f2'> Song Duration :</label>
        <input type='number' id='f2' name='duration'/>
        <br/>
        <label for='f3'> Artist :</label>
        <input type='text' id='f3' name='artist'/>
        <br/>
        <label for='score' > Score (1-5):</label>
        <input type='radio' name='score' value='1'>
        <input type='radio' name='score' value='2'>
        <input type='radio' name='score' value='3'>
        <input type='radio' name='score' value='4'>
        <input type='radio' name='score' value='5'>
        <br/>
        <input type='submit' value='CREATE'/>
    </form>
    </body>
    </html>
    ```
- Al realizar una petición `POST` al mismo Servlet, se mostrará toda la información recabada mediante el formulario (implementando `doPost()`). Resultando en una respuesta similar a la siguiente.

## Ejercicio 3 - Redirección y composición con RequestDispatcher

### A) Request Forwarding

Crea un nuevo servlet llamado `MyDispatcher` que maneja la siguiente ruta: `/TakeMeSomewhereElse`.

Utiliza _annotations_ si lo prefieres a modificar el archivo web.xml para definir las rutas a utilizar.

Este Servlet recibe un fragmento de url en un campo del formulario y redirige al usuario a la página deseada al
hacer una petición `POST` a esa misma ruta.

> 🧐 Hints: para obtener un `RequestDispatcher`, obtén el contexto de la aplicación web por medio del método `getServletContext()` directamente accesible en cualquier `HttpServlet`. Luego usa `getRequestDispatcher(path)` para obtener un objeto `RequestDispatcher` asociado a una url deseada.

### B) Include.

Crea un Servlet llamado `ParagraphGenerateForm` que responda al usuario en la url `/ParagraphGenerator` con un formulario en el que introducir un número entero que indica el número de párrafos idénticos a generar a continuación, al realizarse una petición `POST`.

> 🧐 Hint: El proyecto ya contiene un Servlet que se encarga de generar N párrafos HTML (`ParagraphGenServlet`). Utiliza el método `include(path)` de `RequestDispatcher` para generar tantos párrafos como indique el usuario delegando esa tarea al Servlet preexistente.
