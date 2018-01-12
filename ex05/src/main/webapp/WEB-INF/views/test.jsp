<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ajax test page</title>
<style>
	#modDiv{
		width : 300px;
		height : 100px;
		background-color : gray;
		position : absolute;
		top : 50%;
		left : 50%;
		margin-top : -50px;
		margin-left : 150px;
		padding : 10px;
		z-index : 1000;
	}
</style>
<script src="/resources/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<script>

	function getAllList(bno){
		
		var str ="";
		$.getJSON("/replies/all/"+ bno, function(data){
			console.log(data.length);
			
			$(data).each(function(){
				str += "<li data-rno='" + this.rno + "' class='replyLi'>" 
					+ this.rno + ":" + this.replytext
					+ "<button>수정</button></li>";
					
			});
			
			
			$("#replies").html(str);
		});
	}
	
	function getPageList(bno,page){
		$.getJSON("/replies/" + bno + "/" + page, function(data){
			console.log(data.length);
			
			var str ="";
			
			$(data.list).each(function(){
				str += "<li data-rno='" + this.rno + "'class='replyLi'>"
					+ this.rno + " : " + this.replytext
					+ "<button>수정</button></li>";
			});
			
			$("#replies").html(str);
			
			printPaging(data.pageMaker);
		});
	}
	
	function printPaging(pageMaker){
		var str = "";
		if(pageMaker.prev){
			str += "<li><a href='" + (pageMaker.stratPage -1)+"'> << </a></li>";
			
		}
		
		for(var i = pageMaker.startPage, len = pageMaker.endPage; i<= len; i++){
			var strClass = pageMaker.cri.page == i ? 'class=active' : '';
			str += "<li " + strClass + "><a href='" + i + "'>" + i + "</a></li>";
		}
		
		if(pageMaker.next){
			str += "<li><a href='" + (pageMaker.endPage +1) + "'> >> </a></li>";
		}
		$('.pagination').html(str);
	}
	$(document).ready(function(){
		var bno = 65526;
		//getAllList(bno);
		getPageList(bno,1);
		$("#replyAddBtn").click(function(){
			var replyer = $("#newReplyWriter").val();
			var replytext = $("#newReplyText").val();
			
			$.ajax({
				type : 'post',
				url : '/replies',
				headers : {
					"Content-Type" :  "application/json",
					"X-HTTP-Method-Override" : "POST"
				},
				dataType : 'text',
				data :JSON.stringify({
					bno : bno,
					replyer : replyer,
					replytext : replytext
				}),
				success : function(result){
					if(result =='SUCCESS'){
						alert('등록되었습니다');
						getAllList(bno);
					}
				}
			});
		});
		$("#replies").on("click",".replyLi button",function(){
			var reply = $(this).parent();
			var rno = reply.attr("data-rno");
			var replytext = reply.text();
			
			$(".modal-title").html(rno);
			$("#replytext").val(replytext);
			$("#modDiv").show('slow');
		});
		
		$("#replyDelBtn").click(function(){
			var rno = $(".modal-title").html();
			var replytext = $("#replytext").val();
			
			$.ajax({
				type : 'delete',
				url : '/replies/' + rno,
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "DELETE"
				},
				dataType : 'text',
				success : function(result){
					console.log("result : " + result);
					if(result == 'SUCCESS'){
						alert("삭제 되었습니다.");
						$("#modDiv").hide("slow");
						getAllList(bno);
					}
				}
			})
		});
		
		$("#replyModBtn").click(function(){
			var rno = $(".modal-title").html();
			var replytext = $("#replytext").val();
			$.ajax({
				type : 'PUT',
				url : '/replies/' + rno,
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "PUT"
				},
				data: JSON.stringify({replytext:replytext}),
				dataType : 'text',
				success : function(result){
					console.log("result : " + result);
					if(result == 'SUCCESS'){
						alert("수정 되었습니다.");
						$("#modDiv").hide("slow");
						getAllList(bno);
						//getPageList(replypage);
					}
				}
			})

		});
		$(".pagination").on("click","li a",function(event){
			event.preventDefault();
			var replyPage = $(this).attr("href");
			getPageList(bno,replyPage);
		});
		$("#closeBtn").click(function(){
			$("#modDiv").css("display","none");
		});
	});
</script>
</head>
<body>
	<h2>ajax test page</h2>
	
	<ul id ="replies"></ul>
	
	<ul class="pagination"></ul>
	<div id = "modDiv" style= "display:none;">
		<div class = "modal-title"></div>
		<div>
			<input type="text" id ="replytext">
		</div>
		<div>
			<button id="replyModBtn">수정하기</button>
			<button id="replyDelBtn">삭제하기</button>
			<button id="closeBtn">닫기</button>
		</div>
	</div>
	<div>
		<div>
			Replyer <input type = "text" name = "replyer" id = "newReplyWriter">
		</div>
		<div>
			Reply text <input type = "text" name = "replytext" id = "newReplyText"> 
		</div>
	</div>
	<button id = "replyAddBtn">ADD REPLY</button>
</body>
</html>