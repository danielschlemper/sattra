<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Cadastro de Cliente</title>
</head>
<body>
	<h2>Formulário de Cadastro de Cliente</h2>
	<form:form method="POST"  action="cadastroCliente" >
		<table>
			<tr>
				<td><form:label path="nome">Nome</form:label></td>
				<td><form:input path="nome" /></td>
			</tr>
			<tr>
				<td><form:label path="cpf">CPF:</form:label></td>
				<td><form:input path="cpf" /></td>
			</tr>
			<tr>
				<td><form:label path="contatos">Contatos:</form:label></td>
				<td><form:input path="contatos" /></td>
			</tr>
			<tr>
			<tr>
				<td><form:label path="telefone">Telefone:</form:label></td>
				<td><form:textarea path="telefone" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Email:</form:label></td>
				<td><form:textarea path="email" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
	<a href="/cliente/listaClientes">Lista</a>
</body>
</html>