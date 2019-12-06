<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
 <a href='<c:url value="/logout" />'>Logout</a>
 <br/>
 <a href='<c:url value="/projeto/list" />'>Listar Projetos</a>
 <br/>
 <a href='<c:url value="/pessoa/list" />'>Listar Pessoas</a>
 <br/>
 <a href='<c:url value="/membros/list" />'>Associar Membros</a>
 <br/>
 <a href='<c:url value="/user/list" />'>Listar Usu�rios</a>
 <h1>Seja bem-vindo, 
 <c:if test="${pageContext.request.userPrincipal.name != null }">
 ${pageContext.request.userPrincipal.name }!
 </c:if> </h1>
</body>
</html>