
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function confirma(id){
		
		if (window.confirm("Deseja Realmente Excluir?") ){
			
			location.href="usucontroller?acao=exc&id="+id;
			
		}
		
	}

</script>

</head>
<body>

Lista de Usuários JSTL
<br/>
<a href="usucontroller?acao=novo"> NOVO </a>

<table border="1">
	<tr>
		<th> Id </th>
		<th>Nome </th>
		<th> Login </th>
		<th> Ação </th>
	</tr>
<c:forEach items="${requestScope.lista}" var="usu">
	<tr>
		<td>${usu.id}  </td>
		<td>${usu.nome} </td>
		<td>${usu.login}</td>
		<td> 
		<a href="javascript:confirma(${usu.id})"> Excluir</a>
		|
		<a href="usucontroller?acao=edit&id=${usu.id}"> Editar</a>
		 </td>
	</tr>
</c:forEach>
	
	
</table>

</body>
</html>