<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Añadir Nuevo Jugador</title>
    <meta property="og:title" content="Añadir nuevo jugador - Atleti">
    <link rel="stylesheet" href="styles/style.css" />
  </head>
  <body>
  
  <% String index = request.getParameter("index"); %>
  
  <h2>Jugador <%= index %></h2>
  
    <div>

      <div class="añadir-jugador-container00">
        <div class="añadir-jugador-body">
          <div class="añadir-jugador-container01">
            <div class="añadir-jugador-title">
              <h1 class="añadir-jugador-heading">Editar jugador:</h1>
            </div>
            
            <div class="añadir-jugador-formulario">
              <form action="EditarJugadorServlet?index=<%=index%>" method="post" class="añadir-jugador-form">
                <div class="añadir-jugador-campo1">
                  <div class="añadir-jugador-container02">
                    <label class="añadir-jugador-text0">Nombre:</label>
                  </div>
                  <div class="añadir-jugadorcontainer03">
                    <input type="text" class="añadir-jugador-textinput input" name="nombre"/>
                  </div>
                </div>
                <div class="añadir-jugador-campo2">
                  <div class="añadir-jugador-container04">
                    <label class="añadir-jugador-text1">Apellidos:</label>
                  </div>
                  <div class="añadir-jugador-container05">
                    <input type="text" class="input" name="apellidos"/>
                  </div>
                </div>
                <div class="añadir-jugador-campo3">
                  <div class="añadir-jugador-container06">
                    <label class="añadir-jugador-text2">DNI:</label>
                  </div>
                  <div class="añadir-jugador-container07">
                    <input type="text" class="input" name="DNI"/>
                  </div>
                </div>
                <div class="añadir-jugador-campo4">
                  <div class="añadir-jugador-container08">
                    <label class="añadir-jugador-text3">Alias:</label>
                  </div>
                  <div class="añadir-jugador-container09">
                    <input type="text" class="input" name="alias"/>
                  </div>
                </div>
                <div class="añadir-jugador-campo5">
                  <div class="añadir-jugador-container10">
                    <label class="añadir-jugador-text4">Posición:</label>
                    <select name="posicion">
                      <option value="Portero">Portero</option>
                      <option value="Defensa">Defensa</option>
                      <option value="Medio">Medio</option>
                      <option value="Delantero">Delantero</option>
                    </select>
                  </div>
                </div>

                <div class="añadir-jugador-button">
                  <div class="solid-button-container">
                    <button type="submit" class="solid-button-button button">
                      <span>Guardar Cambios</span>
                    </button>
                  </div>
                </div>
              </form>
              
              <div class="añadir-jugador-container14">
                <div class="solid-button-container">
                  <button class="solid-button-button button">
                    <span><a href="index.jsp">Cancelar</a></span>
                  </button>
	              </div>
	            </div>
              
			      </div>
	        </div>
	      </div>
	    </div>
    </div>
  </body>
</html>