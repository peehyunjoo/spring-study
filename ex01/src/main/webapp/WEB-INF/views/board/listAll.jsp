<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<script>
    console.log('${msg}');
	var result = '${msg}';
	console.log(result);
	if(result == 'SUCCESS'){
		alert("처리가 완료 되었습니다");
	}
</script>
<table class="table table-bordered">
	<tr>
		<th style="width: 10px">BNO</th>
		<th>Title</th>
		<th>Writer</th>
		<th>REGDATE</th>
		<th style="width: 40px">VIEWCNT</th>
	</tr>
</table>