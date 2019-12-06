<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Projetos</title>
</head>
<body>
<a href='<c:url value="../logout" />'>Logout</a>
 <br/>
 <spring:url value="/projeto/add" var="addURL" />
 <a href="${addURL }">Adicionar Projeto</a>
 <br/>
 
 <h2>Lista de Projetos</h2>
 <table width="100%" border="1">
  <tr>
   <th>ID</th>
   <th>Nome</th>
   <th>Data Nasc</th>
   <th>CPF</th>
   <th>Funcionário</th>
   <th colspan="2">Ação</th>
  </tr>
  <c:forEach items="${listProjeto }" var="projeto" >
   <tr>
    <td>${projeto.id }</td>
    <td>${projeto.nome }</td>
    <td>${projeto.data_inicio }</td>
    <td>${projeto.data_previsao_fim }</td>
    <td>${projeto.data_fim }</td>
    <td>${projeto.descricao }</td>
    <td>${projeto.status }</td>
    <td>${projeto.orcamento }</td>
    <td>${projeto.risco }</td>
    <td>
     <spring:url value="/projeto/update/${projeto.id }" var="updateURL" />
     <a href="${updateURL }">Atualizar</a>
    </td>
    <td>
     <spring:url value="/projeto/delete/${projeto.id }" var="deleteURL" />
     <a href="${deleteURL }">Excluir</a>
    </td>
   </tr>    
  </c:forEach>
 </table>
 
</body>
</html>