
<%@page import="br.com.fabricadeprogramador.entidades.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<a href="usucontroller?acao=novo"> NOVO </a>

<table border="1">


	<tr>
		<th> Id </th>
		<th>Nome </th>
		<th> Login </th>
		<th> Ação </th>
	</tr>
	<%
		//Pegando a lista vinda do Servlet Controller
		List<Usuario> lista = (List<Usuario>) request.getAttribute("lista");

		for (Usuario usu : lista) {
	%>
	<tr>
		<td><%=usu.getId() %>  </td>
		<td><%=usu.getNome() %> </td>
		<td><%=usu.getLogin() %></td>
		<td> 
		
		<a href="javascript:confirma(<%=usu.getId()%>)"> Excluir</a>
		|
		<a href="usucontroller?acao=edit&id=<%=usu.getId()%>"> Editar</a>
		
		
		 </td>
		
	
	</tr>
	
	<%
		}
	%>
	
	
</table>

</body>
</html>