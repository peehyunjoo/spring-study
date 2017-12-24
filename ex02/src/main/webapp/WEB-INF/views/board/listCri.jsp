<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ page session="false" %>
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
	
	<c:forEach items="${list}" var="boardVO">
		<tr>
			<td>${boardVO.bno}</td>
			<td><a href="/board/read?bno=${boardVO.bno}">${boardVO.title}</a></td>
			<td>${boardVO.writer}</td>
			<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVO.regdate}"/>
			</td>
			<td><span class="badge bg-red">${boardVO.viewcnt}</span></td>	
		</tr>
	</c:forEach>
</table>