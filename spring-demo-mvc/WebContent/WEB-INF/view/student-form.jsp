<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
	<head>
		<title>Student Form</title>
		<style type="text/css">
			.error {color: red;}
		</style>
	</head>
	
	<body>
		<form:form action="process-form" modelAttribute="student">
			First name: <form:input path="firstName" />
			<br><br>
			Last name*: <form:input path="lastName" />
			<form:errors path="lastName" cssClass="error" />
			<br><br>
			
			<!-- <form:select path="address">
				<form:option value="Dalaguete" label="Dalaguete"/>
				<form:option value="Tuba" label="Tuba"/>
				<form:option value="Oslob" label="Oslob"/>
				<form:option value="Poblaction" label="Poblaction"/>
			</form:select> -->
			
			<form:select path="address">
				<form:options items="${student.addressOptions}"/>
			</form:select>
			
			<br><br>
			Favorite language:
			
			<form:radiobutton path="programmingLanguage" value="Java"/> Java
			<form:radiobutton path="programmingLanguage" value="C#"/> C# 
			<form:radiobutton path="programmingLanguage" value="TypeScript"/> TypeScript 
			<form:radiobutton path="programmingLanguage" value="Python"/> Python 
			
			<br><br>
			Operating Systems:
			
			<form:checkbox path="operatingSystems" value="Linux"/> Linux
			<form:checkbox path="operatingSystems" value="Windows"/> Windows
			<form:checkbox path="operatingSystems" value="MacOS"/> MacOS
			
			<br><br>
			Number of courses taken <form:input path="coursesCount" />
			<form:errors path="coursesCount" cssClass="error" />
			<br><br>
			Program and Year <form:input path="programAndYear" />
			<form:errors path="programAndYear" cssClass="error" />
			
			<br><br>
			<input type="submit" value="Submit" />
		</form:form>
	</body>

</html>