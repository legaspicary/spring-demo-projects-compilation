<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>

<html>
	<head>
		<title>Student Confirmation</title>
	</head>
	
	<body>
	
	The student is confirmed: ${student.firstName} ${student.lastName} who lives at ${student.address}
	<br><br>
	Number of courses taken: ${student.coursesCount}
	<br><br>
	Program and Year: ${student.programAndYear}
	<br><br>
	Favorite Language: ${ student.programmingLanguage }
	<br><br>
	Operating Systems:
	
	<ul>
		<c:forEach var="os" items="${student.operatingSystems}">
			<li>${os}</li>
		</c:forEach>
	</ul>

	</body>

</html>