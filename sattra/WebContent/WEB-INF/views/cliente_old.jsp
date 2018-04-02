<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Cadastro de Cliente</title>
</head>
<body>
	<h2>Formulário de Cadastro de Cliente</h2>
	<form action="cliente/cadastroCliente" method="post">
		Nome: <br /> <input type="text" name="nome" /> <br /> Email: <br />
		<input type="text" name="email" /> <br /> Contatos: <br /> <input
			type="text" name="contatos" /> <br /> <input type="submit"
			value="Inserir">
	</form>
	<a href="/cliente/listaClientes">Lista</a>
</body>
</html>