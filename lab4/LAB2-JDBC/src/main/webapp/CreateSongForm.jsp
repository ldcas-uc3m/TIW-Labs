<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create song</title>
</head>

<body>

	<header>
		<jsp:include page="cabecera.html" />
	</header>


	<h1>Crea una nueva canci&oacuten:</h1>

	<form action="CreateSong" method="post">

		<label for="i-name"> Nombre </label> <input id="i-name" type="text"
			name="name" /> <br> <label for="i-duration"> Duration </label>
		<input id="i-duration" type="text" name="duration" /> <br> <label
			for="i-artist"> Artist </label> <input id="i-artist" type="text"
			name="artist" /> <br> <label for="i-score"> Score </label> <input
			id="i-score" type="text" name="score" /> <br> <input
			type="submit" value="Submit" />
	</form>

	<footer>
		<jsp:include page="pie.html" />
	</footer>
</body>
</html>