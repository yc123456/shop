<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>main</title>
		<script src="/js/jquery-1.7.2.min.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" href="/styles/bootstrap.min.css">
	</head>
	<body>
	<form>
	<table class="table table-hover">
	  <tr>
      <th>username</th>
      <th>email</th>
      <th>createdAt</th>
      <th>roleId</th>
      </tr>
      <#list pagelist as page> 
       <tr>
       <td>${page.username?if_exists}</td>
       <td>${page.email?if_exists}</td>
       <td>${page.createdAt?if_exists}</td>
       <td>${page.roleId!'10001'}</td>
       </tr>
      </#list>
      </table>
      </form>
	</body>
</html>