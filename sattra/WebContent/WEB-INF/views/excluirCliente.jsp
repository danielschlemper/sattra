<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Cadastro de Cliente</title>
</head>
<body>
	<h2>Formulário de Cadastro de Cliente</h2>
	<form:form method="GET"  action="excluirCliente" >
	<table>
			<tr>
			<td><form:label path="cpf">CPF:</form:label></td>
				<td><form:input path="cpf" /></td>
				<td><input type="submit" value="Deletar Cliente" /></td>				
			</tr>
			<tr>
				<td colspan="2">${error}</td>				
			</tr>
			</table>
	</form:form>
		
	<a href="/cliente/listaClientes">Lista</a>
</body>
</html>