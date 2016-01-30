<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>main</title>
		<script src="/js/jquery-1.7.2.min.js" type="text/javascript"></script>
		<script type="text/javascript">
		$(function($){
			$.ajax({
              type: "POST",
              url: "/paging/pageInfo.htm",
              data: "curPage=1&pageSize=5",
              success: function(data){
                  
             }
           });
		});
	</script>
	</head>
	<body>
	
	</body>
</html>
