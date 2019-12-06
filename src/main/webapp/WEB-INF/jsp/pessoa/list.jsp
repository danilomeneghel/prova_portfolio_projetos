<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Pessoas</title>
</head>
<body>
<a href='<c:url value="../logout" />'>Logout</a>
 <br/>
 <spring:url value="/pessoa/add" var="addURL" />
 <a href="${addURL }">Adicionar Pessoa</a>
 <br/>
 
 <h2>Lista de Pessoas</h2>
 <table width="100%" border="1">
  <tr>
   <th>ID</th>
   <th>Nome</th>
   <th>Data Nasc</th>
   <th>CPF</th>
   <th>Funcionário</th>
   <th colspan="2">Ação</th>
  </tr>
  <c:forEach items="${listPessoa }" var="pessoa" >
   <tr>
    <td>${pessoa.id }</td>
    <td>${pessoa.nome }</td>
    <td>${pessoa.datanascimento }</td>
    <td>${pessoa.cpf }</td>
    <td>${pessoa.funcionario }</td>
    <td>
     <spring:url value="/pessoa/update/${pessoa.id }" var="updateURL" />
     <a href="${updateURL }">Atualizar</a>
    </td>
    <td>
     <spring:url value="/pessoa/delete/${pessoa.id }" var="deleteURL" />
     <a href="${deleteURL }">Excluir</a>
    </td>
   </tr>    
  </c:forEach>
 </table>
 
</body>
</html>