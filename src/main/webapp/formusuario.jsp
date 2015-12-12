<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

Novo Form com JSTL

	<form action="usucontroller" method="post">
		
		<input type="hidden" name="id" value="${requestScope.usuario.id}"/>  
	
		Nome:
		<input type="text" name="nome" value="${requestScope.usuario.nome}"/>  
		
		Login:
		<input type="text" name="login" value="${requestScope.usuario.login}"/> 
		
		Senha:
		<input type="password" name="senha" value="${requestScope.usuario.senha}"/>
		
		<input type="submit" value="Salvar"/>
	
	</form>
</body>
</html>