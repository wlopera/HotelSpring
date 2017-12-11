<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Solicitar Ofertas del Mes</title>
</head>
<body>
	<h1>Solicitar Ofertas del Mes</h1>
	<hr>

	<form:form modelAttribute="formulario">
		<form:select path="mes">
			<form:options items="${listadoMeses}" itemValue="id" itemLabel="nombre"/>
		</form:select>
		<input type="submit" value="Ofertas" />
	</form:form>
</body>
</html>

