<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Cadastro de Cliente</title>
</head>
<body>
	<h2>Dados do cliente completados exibe cliente</h2>
	<form:form method="POST"  action="cadastroCliente" >
		<table>
			<tr>
				<td><form:label path="nome">Nome</form:label></td>
				<td>${nome}</td>
			</tr>
			<tr>
				<td><form:label path="cpf">CPF:</form:label></td>
				<td>${cpf}</td>
			</tr>
			<tr>
				<td><form:label path="contatos">Contatos:</form:label></td>
				<td>${contatos}</td>
			</tr>
			<tr>
			<tr>
				<td><form:label path="telefone">Telefone:</form:label></td>
				<td>${telefone}</td>
			</tr>
			<tr>
				<td><form:label path="email">Email:</form:label></td>
				<td>${email}</td>
			</tr>
				<tr>
				<td><form:label path="endereco.cep">cep:</form:label></td>
				<td>${cep}</td>
			</tr>
				<tr>
				<td><form:label path="endereco.logradouro">logradouro:</form:label></td>
				<td>${logradouro}</td>
			</tr>
			<tr>
				<td><form:label path="endereco.numero">numero:</form:label></td>
				<td>${numero}</td>
			</tr>
			<tr>
				<td><form:label path="endereco.complemento">complemento:</form:label></td>
				<td>${complemento}</td>
			</tr>
			<tr>
				<td><form:label path="endereco.bairro">bairro:</form:label></td>
				<td>${bairro}</td>
			</tr>
			<tr>
				<td><form:label path="endereco.localidade">localidade:</form:label></td>
				<td>${localidade}</td>
			</tr>
			<tr>
				<td><form:label path="endereco.uf">uf:</form:label></td>
				<td>${uf}</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
	<a href="/cliente/listaClientes">Lista</a>
</body>
</html>