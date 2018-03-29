<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CEP</title>
</head>
<body>
	<center>		
		<h2>
			${mensagem}
		</h2>
		<h2>Endereco</h2>
	</center>
	
	<form method="get" action="resultadoEndereco?cep="+cep>
	
	 <table>    
         <tr>    
          <td>Cep : </td>   
          <td>
          <input name="cep" type="text" id="cep" value="" size="10" maxlength="9" /></label>
          <td>
         </tr>   
          <tr>    
          <td colspan="2"><input type="submit" value="Buscar" /></td>    
         </tr>    
	</table>     
        
   
      </form>
</body>
</html>