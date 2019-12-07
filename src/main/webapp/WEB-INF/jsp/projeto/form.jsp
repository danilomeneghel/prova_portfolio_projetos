<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Projeto</title>
</head>
<body>
<a href='../projeto/list'>Voltar</a>
 <br/>
 
 <h2>Cadastro de Projeto</h2>
 <spring:url value="/projeto/save" var="saveURL" />
 <form:form modelAttribute="projetoForm" method="post" action="${saveURL }" >
  <form:hidden path="id"/>
  <table>
   <tr>
    <td>Nome: </td>
    <td>
     <form:input path="nome"/>
    </td>
   </tr>
   <tr>
    <td>Data Inicio: (yyyy/mm/dd)</td>
    <td>
     <form:input path="data_inicio"/>
    </td>
   </tr>
   <tr>
    <td>Data Previsão Fim: (yyyy/mm/dd)</td>
    <td>
     <form:input path="data_previsao_fim"/>
    </td>
   </tr>
   <tr>
    <td>Data Fim: (yyyy/mm/dd)</td>
    <td>
     <form:input path="data_fim"/>
    </td>
   </tr>
   <tr>
    <td>Descrição: </td>
    <td>
     <form:input path="descricao"/>
    </td>
   </tr>
   <tr>
    <td>Status: </td>
    <td>
     <form:select  path="status">
    	<form:option value="Em Análise">Em Análise</form:option>
    	<form:option value="Análise Realizada">Análise Realizada</form:option>
    	<form:option value="Análise Aprovada">Análise Aprovada</form:option>
    	<form:option value="Iniciado">Iniciado</form:option>
    	<form:option value="Planejado">Planejado</form:option>
    	<form:option value="Em Andamento">Em Andamento</form:option>
    	<form:option value="Encerrado">Encerrado</form:option>
    	<form:option value="Cancelado">Cancelado</form:option>
  	 </form:select>
    </td>
   </tr>
   <tr>
    <td>Orçamento: </td>
    <td>
     <form:input path="orcamento"/>
    </td>
   </tr>
   <tr>
    <td>Risco: </td>
    <td>
     <form:select  path="risco">
    	<form:option value="Baixo Risco">Baixo Risco</form:option>
    	<form:option value="Médio Risco">Médio Risco</form:option>
    	<form:option value="Alto Risco">Alto Risco</form:option>
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