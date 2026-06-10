<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
 <h1> test </h1>
 netstat -ano
 startup
 taskkill /f /pid <내 pid>
 
 export해서 ROOT.war로 저장하고 
 톰캣에 있는 webapps폴더안에 넣어준다. 
 기존 root 파일은 다 삭제해야함.


톰캣안에 bin폴더 안에 있는 startup.bat누르면 켜짐.
  
</body>
</html>