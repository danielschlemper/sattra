<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Exibe Detalhes do Cliente</title>
</head>
<body>
 
<h2>Detalhes do Cliente Cadastrado</h2>
   <table>
    <tr>
        <td>Nome:</td>
        <td>${nome}</td>
    </tr>
    <tr>
        <td>CPF:</td>
        <td>${cpf}</td>
    </tr>
    <tr>
        <td>Contato:</td>
        <td>${contato}</td>
    </tr>
        <td>Telefone:</td>
        <td>${telefone}</td>
    </tr>
    <tr>
        <td>Email:</td>
        <td>${email}</td>
    </tr>
  
</table>  
<a href="/cliente/cliente">Cadastro</a>
<a href="/cliente/listaClientes">Lista</a>
 
</body>
</html>