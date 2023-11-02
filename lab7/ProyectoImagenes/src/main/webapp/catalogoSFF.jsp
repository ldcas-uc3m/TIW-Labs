<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,java.util.ArrayList,model.*,org.apache.commons.codec.binary.StringUtils,org.apache.commons.codec.binary.Base64;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="controlador?accion=catalogoBBDD">Opcion guardar fotos en la base de datos</a>
<h3> Formulario para subir nueva foto</h3>
<form action="controlador" method="post" enctype="multipart/form-data">
	<input type="hidden" name="accion" value="insertarSFF">
    Select image to upload:
    <input type="file" name="fileToUpload" id="fileToUpload">
    Titulo:
     <input type="text" name="titulo">
    <input type="submit" value="Upload Image" name="submit">
</form>
<h3> Formulario para hacer una busqueda por titulo </h3>
<form action="controlador" method="post" >
	<input type="hidden" name="accion" value="consultaSFF">
    Que contenga en el titulo:
    <input type="text" name="palabra">
    <input type="submit" value="Buscar" name="submit">
</form>
<h3> Resultado o contenido en la base de datos </h3> <a href="controlador?accion=catalogoSFF">Ver totos los elementos</a>
<% 
List<Imagenensff> elementos= new ArrayList<Imagenensff>();
Object lista = request.getAttribute("lista");
  if (lista != null){
	if(lista instanceof List){
		 elementos = (List<Imagenensff>)lista;
		for(Imagenensff elemento: elementos){ %>
			<h5>Titulo:<%=elemento.getTitulo() %> (Id_Imagen: <%=elemento.getIdImagen() %>) </h5>
			<!--  Esta manera de mostrar una imagen requiere descargar una libreria de apache
			      https://commons.apache.org/proper/commons-codec/download_codec.cgi
			       y colocar el .jar dentro de la carpeta WebContent/WEB-INF/lib/   -->
			<!--  Todo el siguiente código quedaría bonito en una clase con un método estático
			que fuera un util para catalogo.jsp -->
			<img style="height: 50px;" src="visualizarImagenSFF?id=<%=elemento.getIdImagen() %>">
		<% }
	}
}%>

</body>
</html>