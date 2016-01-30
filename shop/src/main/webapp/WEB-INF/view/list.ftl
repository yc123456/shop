<!DOCTYPE html>
<html>
	<head>
		<title>main</title>
		<script src="/js/jquery-1.12.0.min.js" type="text/javascript" charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="/styles/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="/styles/red.css">
		<script src="/js/icheck.js" type="text/javascript"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$('input').iCheck({
					checkboxClass: 'icheckbox_flat-red',
				});
			});

			function check() {
				var a = document.getElementsByName("pages");
				var url = "";
				for (var i = 0; i < a.length; i++) {
					if (a[i].checked == true) {
						url = url + a[i].id + ".";
					}
				}
				$.ajax({
					type: "DELETE",
					url: "/paging/delete/"+url,
					success: function(msg) {
						alert(msg);
						document.location.reload();
					}
				});
			}
		</script>

	</head>

	<body>

		<form>
			<table class="table table-hover">
				<tr>
					<th>condition</th>
					<th>id</th>
					<th>username</th>
					<th>email</th>
					<th>createdAt</th>
					<th>roleId</th>
				</tr>
				<#list pagelist as page>
					<tr>
						<td>
							<input type="checkbox" id="${page.id}" name="pages">
						</td>
						<td>${page.id?if_exists}</td>
						<td>${page.username?if_exists?upper_case}</td>
						<td>${page.email?if_exists}</td>
						<td>${page.createdAt?if_exists}</td>
						<td>${page.roleId!'10001'}</td>
					</tr>
				</#list>
			</table>
			<button type="button" class="btn btn-success" onclick="check()">删除</button>
		</form>

		<!--分页 -->
		<ul class="pagination">
			<#if count.curPage=1>
				<li>
					<a href="#" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					</a>
				</li>
				<#else>
					<li>
						<a href="/paging/list/${count.curPage-1}" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
						</a>
					</li>
			</#if>

			<#list 1..count.pageCount as c>
				<#if c==count.curPage>
					<li class="active"><a href="/paging/list/${c}">${c}</a></li>
					<#else>
						<li><a href="/paging/list/${c}">${c}</a></li>
				</#if>

				<#if c==3>
					<li><a>...</a></li>
				</#if>
			</#list>

			<#if count.curPage=count.pageCount>
				<li>
					<a href="#" aria-label="Next">
						<span aria-hidden="true">&raquo;</span>
					</a>
				</li>
				<#else>
					<li>
						<a href="/paging/list/${count.curPage+1}" aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
						</a>
					</li>
			</#if>
		</ul>
		<#include "/copyright.ftl">
	</body>
</html>