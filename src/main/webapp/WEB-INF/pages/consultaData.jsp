<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/css/estilos.css"/>
<style type="text/css">
  .error { color: red; font-family: Verdana; font-size:small}
</style>

<title>Solicitar Ofertas del Mes</title>
</head>
<body>
	<h1>Solicitar Ofertas del Mes</h1>
	<hr>

	<form:form modelAttribute="formulario">
		Mes:
		<form:select path="mes">
			<form:options items="${listadoMeses}" itemValue="id" itemLabel="nombre"/>
		</form:select>
		<form:errors path="mes" cssClass="error"/>
		<br><br>
		Días: 
		<form:input path="dias"/> 
		<form:errors path="dias" cssClass="error"/>
		<br><br>
		Precio Máximo:
		<form:input path="precioMax"/>
		<form:errors path="precioMax" cssClass="error"/>
		<br><br>
		
		<input type="submit" value="Ofertas" />
	</form:form>
</body>
</html>

