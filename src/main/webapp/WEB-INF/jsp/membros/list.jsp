<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Membros</title>
</head>
<body>
<a href='<c:url value="../logout" />'>Logout</a>
 <br/>
 <spring:url value="/membros/add" var="addURL" />
 <a href="${addURL }">Adicionar Membros</a>
 <br/>
 
 <h2>Lista de Membros</h2>
 <table width="100%" border="1">
  <tr>
   <th>ID Projeto</th>
   <th>ID Pessoa</th>
   <th>A��o</th>
  </tr>
  <c:forEach items="${listMembros }" var="membros" >
   <tr>
    <td>${membros.idprojeto }</td>
    <td>${membros.idpessoa }</td>
    <td>
     <spring:url value="/membros/delete/${membros.idprojeto }/${membros.idpessoa }" var="deleteURL" />
     <a href="${deleteURL }">Excluir</a>
    </td>
   </tr>    
  </c:forEach>
 </table>
 
</body>
</html>