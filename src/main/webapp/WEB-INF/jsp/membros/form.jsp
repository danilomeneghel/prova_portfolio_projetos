<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Membros</title>
</head>
<body>
<a href='../membros/list'>Voltar</a>
 <br/>
 
 <h2>Cadastro de Membros</h2>
 <spring:url value="/membros/save" var="saveURL" />
 <form:form modelAttribute="membrosForm" method="post" action="${saveURL }" >
  <table>
   <tr>
    <td>ID Projeto: </td>
    <td>
     <form:select path="idprojeto" items="${listProjetos}" itemLabel="nome" itemValue="id"/>
    </td>
   </tr>
   <tr>
    <td>ID Pessoa: </td>
    <td>
     <form:select path="idpessoa" items="${listPessoas}" itemLabel="nome" itemValue="id"/>
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