<!DOCTYPE html>
<%@page import="br.com.fabricadeprogramador.entidades.Usuario"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	//Pegando o usuario vindo do servlet
	Usuario usuario = (Usuario)request.getAttribute("usuario");
%>
	<form action="usucontroller" method="post">
		
		<input type="hidden" name="id" value="<%=usuario.getId()%>"/>  
	
		Nome:
		<input type="text" name="nome" value="<%=usuario.getNome()%>"/>  
		
		Login:
		<input type="text" name="login" value="<%=usuario.getLogin()%>"/> 
		
		Senha:
		<input type="password" name="senha" value="<%=usuario.getSenha()%>"/>
		
		<input type="submit" value="Salvar"/>
	
	</form>
</body>
</html>