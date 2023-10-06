<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buscador canciones</title>
</head>
<body>

	<header>
		<jsp:include page="cabecera.html" />
	</header>

	<form method="post" action="SearchSongByIdForEdit">

		<label for="i-id"> Id de canción a editar: </label> <input
			type="number" id="i-id" name="id" /> <input type="submit"
			value="Go!" />

	</form>


	<footer>
		<jsp:include page="pie.html" />
	</footer>

</body>
</html>