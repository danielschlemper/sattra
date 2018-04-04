<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Cadastro de Cliente</title>
</head>
<body>
	<h2>Formulário de Cadastro de Cliente</h2>
	<form:form method="GET"  action="buscaCliente" >
	<table>
			<tr>
			<td><form:label path="cpf">CPF:</form:label></td>
				<td><form:input path="cpf" /></td>
				<td><input type="submit" value="Buscar CPF" /></td>				
			</tr>
			<tr>
				<td colspan="2">${error}</td>				
			</tr>
			</table>
	</form:form>
	<form:form method="POST"  action="editarCliente" >
		<table>		
			<tr>
				<td><form:label path="nome">Nome</form:label></td>
				<td><form:input path="nome" /></td>
			</tr>
			<tr>
				<td><form:label path="contatos">Contatos:</form:label></td>
				<td><form:input path="contatos" /></td>
			</tr>
			<tr>
			<tr>
				<td><form:label path="telefone">Telefone:</form:label></td>
				<td><form:input path="telefone" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Email:</form:label></td>
				<td><form:input path="email" /></td>
			</tr>
				<tr>
				<td><form:label path="endereco.cep">cep:</form:label></td>
				<td><form:input path="endereco.cep" /></td>				
			</tr>
			<tr>
				<td><form:label path="endereco.logradouro">logradouro:</form:label></td>
				<td><form:input path="endereco.logradouro" /></td>
			</tr>
			<tr>
				<td><form:label path="endereco.numero">numero:</form:label></td>
				<td><form:input path="endereco.numero" /></td>
			</tr>
			<tr>
				<td><form:label path="endereco.complemento">complemento:</form:label></td>
				<td><form:input path="endereco.complemento" /></td>
			</tr>
			<tr>
				<td><form:label path="endereco.bairro">bairro:</form:label></td>
				<td><form:input path="endereco.bairro" /></td>
			</tr>
			<tr>
				<td><form:label path="endereco.localidade">localidade:</form:label></td>
				<td><form:input path="endereco.localidade" /></td>
			</tr>
			<tr>
				<td><form:label path="endereco.uf">uf:</form:label></td>
				<td><form:input path="endereco.uf" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Alterar" /></td>
			</tr>
		</table>
	</form:form>
	<a href="/cliente/listaClientes">Lista</a>
</body>
</html>