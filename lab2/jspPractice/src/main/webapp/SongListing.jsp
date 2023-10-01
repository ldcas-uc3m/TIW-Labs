<%@
	page language="java"
	contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
	import = "beans.Song"
	import = "java.util.ArrayList"
%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>SongListing</title>
</head>
<body>

<h1>Lista de canciones</h1>

<%
// rellenar lista
request.getRequestDispatcher("/utils/PopulateSongs").include(request, response);

// generar lista
ArrayList<Song> fakeSongDB = (ArrayList<Song>) getServletContext().getAttribute("songDB");
%>
<ul>
<%
for (Song fakeSong : fakeSongDB) {
	%>
	<li><%=fakeSong.getSongName()%> - <%=fakeSong.getArtist()%> (<%=fakeSong.getDuration()%>)
	Score: <%=fakeSong.getScore()%>
	</li>
<%
}
%>
</ul>

</body>
</html>