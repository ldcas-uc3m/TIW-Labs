# Laboratorio 2: JSPs
Hay provisto un archivo [`jspPractice.war`](jspPractice.war) que se utiliza como punto de partida para esta hoja de ejercicios.


## Ejercicio 1 - Scriptlets y variables implícitas

Define una JSP llamada [`ShowRequestParameters.jsp`](jspPractice/src/main/webapp/ShowRequestParameters.jsp) que espera 2 parámetros (que introduciremos directamente en la URL e.g. `/ShowRequestParameters.jsp?p=1&q=2`), con nombres `p` y `q`, números enteros; y muestra los parámetros que se incluyen en la petición. Si no se incluyen parámetros en la petición, la página muestra un mensaje que lo indica.

> 💡 Utiliza para ello la variable implícita `request` tal y como lo harías para programar un servlet.


## Ejercicio 2 - Mostrando una Lista dinámica
En el contexto de la aplicación dada (`ServletContext`), existe un atributo llamado `songDB` que contiene una lista de objetos del tipo `Song` (ver [`beans/Song.java`](jspPractice/src/main/java/beans/Song.java)). Crea una página JSP llamada [`SongListing.jsp`](jspPractice/src/main/webapp/SongListing.jsp) que muestra la información de todas las canciones en una tabla usando _Scriptlets_, _Directives_ y _Expressions_.  
Incluye la siguiente línea de código en tu JSP para asegurarte de que la lista de canciones existe en el
`ServletContext` antes de intentar acceder a esta:
```java
request.getRequestDispatcher("/utils/PopulateSongs").include(request,response);
```

> 💡 Recuerda que para usar clases no definidas en una JSP, necesitamos importarlas, para lo cual usamos las _Directives_, por tanto, tendremos que usarlas para importar las colecciones (listas) y la clase `Song`.


## Ejercicio 3 - Declarations

Crea una variable global para una JSP que se llame [`AccessCounting.jsp`](jspPractice/src/main/webapp/AccessCounting.jsp) que almacene el número de veces que se ha accedido la página, actualizándola cada vez que se produce cualquier tipo de request a la misma.  
Utiliza una _JSP Declaration_ para crear un método auxiliar llamado `UpdateCounter` que se encarga de actualizar la variable.


## Ejercicio 4 - Gestión de errores

Crea una página llamada [`JSP-ErrorPage.jsp`](jspPractice/src/main/webapp/JSP-ErrorPage.jsp) a la cual redirigiremos todas las excepciones.

>💡 Recuerda que para definir qué página enviar al cliente cuando se produce una excepción o código de error, es conveniente hacerlo en el archivo [`web.xml`](jspPractice/src/main/webapp/WEB-INF/web.xml).

Modifica la anterior JSP y el archivo [`web.xml`](jspPractice/src/main/webapp/WEB-INF/web.xml) para que esta página sea mostrada también cuando se producen los códigos de error `404` y `401`. Cuando esto ocurre, la página muestra el código de error en vez de mostrar información del objeto `exception` (variable implícita).

> 💡 El código de error se puede obtener de la variable implícita `response`.


## Ejercicio 5 - JSP Include y Page Consistency
Crea una página [`header.html`](jspPractice/src/main/webapp/header.html) que represente la cabecera estándar de tu web y usa una directive del tipo
`<% @include file="<path>.html" %>` para hacer que aparezca en todas las JSPs existentes.


## Ejercicio 6 - Usando Java Beans: Las JSP en MVC
> En un proyecto normalmente conviene separar las capas de vista, procesamiento de la información y persistencia. Es por ello que las JSP deben usarse solamente para definir lo que ve el usuario.

> Por ejemplo, conviene utilizar Servlets para realizar operaciones y luego encapsular información necesaria en algún atributo (de response, sesión, etc.) para que luego la JSP muestre aquello que se le proporciona y ya.

Al llamar a `/ShowShoppingCart`, un _Servlet_ (ver [`ShowShoppingCartServlet.java`](jspPractice/src/main/java/servlets/ShowShoppingCartServlet.java)) genera un atributo llamado `cart` en el contexto de la sesión.  
Crea una JSP llamada [`ShoppingCartPage.jsp`](jspPractice/src/main/webapp/ShoppingCartPage.jsp) y extrae la información y muéstrala usando _JSP Actions_ (`<jsp:getProperty>`, `<jsp:getAttribute>`, etc.)
