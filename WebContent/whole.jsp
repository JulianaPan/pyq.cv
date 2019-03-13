<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="print.*" %>
<!doctype html>
<html lang="en" style="height: 100%;">
	<head>
		<!-- Required meta tags -->
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="bootstrap4/css/bootstrap.min.css" type="text/css">
		<link rel="stylesheet" href="css/style.css" type="text/css">
		<title>潘雨茜CV</title>
	</head>
	<body style="height: 100%;">
		<script  src="bootstrap4/jquery-3.3.1.slim.min.js" type="text/javascript"/>
		
		<script>
			printdiv = function(printpage){
				var newstr = printpage.innerHTML;
				var oldstr = document.body.innerHTML;
				document.body.innerHTML =newstr;
				window.print();
				document.body.innerHTML=oldstr;
				return false;
			}
			window.onload=function(){
				var bt=document.getElementById("printBtn");
				var div_print=document.getElementById("div_print");
				bt.onclick=function(){
					printdiv(div_print);
				}
			}
			
			//html文件转成pdf格式文件函数
		    downloadresume = function(){
		    	/*var pdf = new jsPDF('p', 'pt', 'a4');
	           	pdf.internal.scaleFactor = 1;
		        var options = {
		        	pagesplit: true
		        };
		        //$('.pdf-wrapper')
				pdf.addHTML($("#titBody"), options, function() {
					console.log(pdf);
					pdf.save('网页截屏.pdf');
				});*/
		    	$.ajax({
	                  type: "POST",
	                  url: "PrintServlet",
	                  data: "name=John&location=Boston",
	                  success: function(data){
	                      alert( "Data Saved: " + data );
	                  }
	              });
		    }
		    
		    
		</script>
		<%
			printPDF pdf=new printPDF();
		%> 
		<form action="PrintServlet" method="post">
			<!-- <button id="printBtn" class="btn btn-primary">Print</button> -->
			<button id="saveBtn" class="btn btn-primary" onclick="downloadresume()">Save</button>
		</form>
		<div class="whole_contain" id="div_print">
			<!--Name-->
			<div class="whole_name">
				<div class="whole_nameRight">
					<img src="img/person.jpg" width="150" height="150"/>
				</div>
				<div class="whole_nameLeft">
					<h1>PAN, Yuqian</h1>
					<p>
						age: 23</br>
						e-mail: pyq1009@yeah.net</br>
						phone: 13143129789
					</p>
				</div>
				
			</div>
			
			<!--Education-->
			<div class="whole_section">
				<div class="divider">
					<h3>Education</h3>
					<hr style="height:1px;" color="#987cb9" size=1/>
				</div>
				<div class="content">
					<h4>United International Colleage</h4>
					<h6>Beijing Normal University â Hong Kong Baptist University, Zhuhai</h6>
					<p>
						Bachelor candidate: September 2014 â June 2018</br>
						Major: Computer Science and Technology
					</p>
				</div>
			</div>
			<!--Experience-->
			<div class="whole_section">
				<div class="divider">
					<h3>Experience</h3>
					<hr style="height:1px;" color="#987cb9" size=1/>
				</div>
				<div class="content">
					<div class="blank">
						<h4>Boss Soft, Fuzhou</h4>
						<h6>Big Data Analyze</h6>
						<p style="text-align:justify;text-justify:inter-ideograph;">
							August â September 2017</br>
							
						</p>
					</div>
					<div class="blank">
						<h4>DELL China / EMC Department, Beijing</h4>
						<h6>Configuration EngineerâIntern</h6>
						<p style="text-align:justify;text-justify:inter-ideograph;">
							August â September 2017</br>
							Intern at Dell Chinaâs EMC Research Department. According to the customer requirements and the related data provided by presales, configurated storage device and software . Received pre job training, familiarized with the details of each product. Participated in the department daily meetings discussing problems and solutions. 
						</p>
					</div>
					<div class="blank">
						<h4>Bluehole IOT (Ningbo) Tech., Lim. Co., UIC, Zhuhai </h4>
						<h6>UI DesignerâIntern</h6>
						<p style="text-align:justify;text-justify:inter-ideograph;">
							June - August 2017 </br>
							Participated in âSmart City Starting from Smart Streetlightâ project. Assisted supervisor to develop Landong lighting management system for government departments. Independently completed UI design of the project. Using JavaScript, produced a variety of interface and operation for system. According to customerâs requirements, continuously modified the design and operation of the system. Created the best street lighting management system in Zhuhai, winning customer satisfaction. 
						</p>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>