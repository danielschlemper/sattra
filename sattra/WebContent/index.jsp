<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Página Inicial</title>

<script type="text/javascript">

function redirecionarCadastrarCliente(){
		
	window.location.href = "cliente/paginaCadastroCliente";
}
function redirecionarEditarCliente(){
	
	window.location.href = "sistema/paginaEditarCliente";
}	
function redirecionarInserirCliente(){
	
	window.location.href = "sistema/paginaInserirCliente";
}	
function redirecionarBuscarEndereco(){
	
	window.location.href = "endereco/paginaBuscarEndereco";
}	
</script>

</head>
<body>

	<center>
		<h2>INICIANDO O SISTEMA SATTRA CADASTRO CLIENTE</h2>
		<h3>
			<a href="#" onclick="redirecionarCadastrarCliente();">Cadastrar clientes</a><br></br>
			<a href="#" onclick="redirecionarEditarCliente();">Editar clientes</a><br></br>
			<a href="#" onclick="redirecionarInserirCliente();">Inserir clientes</a></br>
			<a href="#" onclick="redirecionarBuscarEndereco();">Buscar Endereco</a>
		</h3>
	</center>
	
</body>
</html>