<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ofertas del Mes</title>
</head>
<body>
	<h1>Hacer Pédido</h1>
	<hr>

	<c:if test="${not empty ofertas}">

		<ul>
			<c:forEach items="${ofertas}" var="o">
				<li>Habitación ${o.tipoHab} un mínimo de ${o.minNoches} noches
					por solo ${o.precio} USD. por noche</li>
			</c:forEach>
		</ul>
	</c:if>
	<c:if test="${empty ofertas}">
		<h4>No hay ofertas para esta temporada</h4>
	</c:if>
</body>
</html>
