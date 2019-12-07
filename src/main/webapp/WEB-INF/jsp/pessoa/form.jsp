<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Pessoa</title>
</head>
<body>
<a href='../pessoa/list'>Voltar</a>
 <br/>
 
 <h2>Cadastro de Pessoa</h2>
 <spring:url value="/pessoa/save" var="saveURL" />
 <form:form modelAttribute="pessoaForm" method="post" action="${saveURL }" >
  <form:hidden path="id"/>
  <table>
   <tr>
    <td>Nome: </td>
    <td>
     <form:input path="nome"/>
    </td>
   </tr>
   <tr>
    <td>Data Nasc: (yyyy/mm/dd)</td>
    <td>
     <form:input path="datanascimento"/>
    </td>
   </tr>
   <tr>
    <td>CPF: </td>
    <td>
     <form:input path="cpf"/>
    </td>
   </tr>
   <tr>
    <td>Funcionário: </td>
    <td>
     <form:select  path="funcionario">
    	<form:option value="1">Sim</form:option>
    	<form:option value="0">Não</form:option>
  	 </form:select>
    </td>
   </tr>
   <tr>
    <td></td>
    <td>
     <button type="submit">Salvar</button>
    </td>
   </tr>
  </table>  
 </form:form>
 
</body>
</html>