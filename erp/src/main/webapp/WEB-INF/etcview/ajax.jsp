<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
		$(document).ready(function(){
			$("#noajaxbtn").on("click",function(){
				location.href="/erp/ajax/noajax?id="+$("#id1").val()
			})
			$("#ajaxbtn").on("click",function(){
				var querydata={"id":$("#id1").val()}
				$.ajax({
					url:"/erp/ajax/ajaxtest01",
					type:"get",
					data:querydata,
					success:success_run,
					error:error_run
				})//end ajax
			})//end click
			$("#guguajaxbtn").on("click",function(){
				var dan={"dan":$("#dan").val()}
				$.ajax({
					url:"/erp/ajax/gugu",
					type: "get",
					data:dan,
					success:function(data){
						$("#result2").html(data)
					},
					error:function(obj,msg,statusMsg){
						alert("error!!"+obj+" "+msg+" "+statusMsg)
					}
				
				})
			})
		})//end ready
		//ajax요청이 성공하면 자동으로 호출됨 서버의 실행결과가 success_run의 매개변수로 전달이 된다.
		function success_run(data){
			//alert(data);
			//성공하면 서버에서 전달받은 데이터를 이용해서 원하는 위치에 데이터를 출력하기
			$("#result").html("<h2>jquery:"+data+"</h2>");
		}
		//에러가 발생하면 호출되는 메소드 
		//obj - XMLHttpRequest객체 / msg - 응답메세지 / statusMsg - 에러메세지
		function error_run(obj,msg,statusMsg) {
			alert("오류발생"+obj+" "+msg+" "+statusMsg)
		}
</script>
<title>Insert title here</title>
</head>
<body>
	<h3>Ajax테스트하기</h3>
	<form name="myform">
		<input type="text" name="id" id="id1"/>
		<input type="text" name="name" id="name"/>
		<input type="button" id="noajaxbtn" value="no aajx테스트">
		<input type="button" id="ajaxbtn" value="ajax테스트">
	</form>
	<div id="result">${msg }</div>
	
	<h3>구구단출력하기</h3>
	<form name="myform">
		<input type="text" name="id" id="dan"/>
		<input type="button" id="guguajaxbtn" value="ajax테스트">
	</form>
	<div id="result2"></div>


	<h3>Ajax테스트하기(JQuery...post)</h3>
	<form name="myform">
		<input type="text" name="id" id="id3"/>
		<input type="button" id="ajaxbtn3" value="ajax테스트">
	</form>
	<div id="result3"></div>
</body>
</html>