<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Lista de Clientes Cadastrados</title>
</head>
<body>
    <h2>Lista de Clientes Cadastrados</h2>
  
    <c:if test="${not empty clientes}">
        <table>
            <tr>
                <td>Nome</td>               
                <td>Telefone</td>                
            </tr>
  
         
            <c:forEach var="listValue" items="${clientes}">
                 
                <tr>
                    <td>${listValue.nome}</td>                   
                    <td>${listValue.telefone}</td>
                                                    
                </tr>
            </c:forEach>
         
        </table>
  
    </c:if>
    <a href="/cliente/cliente">Cadastro</a>
     
</body>
</html>