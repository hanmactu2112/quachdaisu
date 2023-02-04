<%@page import="model.NhanVien"%>
<%@page import="model.ThanhVien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/all.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap"
	rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Mochiy+Pop+P+One&display=swap"
	rel="stylesheet">
<title>Hệ thống quản lí Gara</title>
</head>

<body>
	<%
		NhanVien nv = (NhanVien) session.getAttribute("nhanvien");
		if (nv == null) {
			response.sendRedirect("./gddangnhap.jsp");
		} else if (request.getParameter("nhanvienkho") != null
				&& request.getParameter("nhanvienkho").equals("Nhân viên kho")) {
			response.sendRedirect("./gdTimHoaDonTam.jsp");
			session.setAttribute("nhanvien", nv);
		} else if (request.getParameter("nhanvienkho") != null) {
	%>
	<script type="text/javascript">
		alert("Bạn không phải nhân viên kho!");
	</script>

	<%
		}
	%>
	<div class="container-fluid b1">
		<div class="container">
			<div class="header">
				<div class="header-inner">
					<div class="logo">
						<a href="./gdTrangChu.jsp">GARA &nbsp;PTIT</a>
					</div>
					<div class="contact">
						<div class="sdt">
							<a href="callto:+84386115804"><i class="fas fa-phone icon"></i></a><a
								href="callto:+84386115804">+84386115804</a>
						</div>
						<div class="email">
							<a href="mailto:webmaster@example.com"><i
								class="fas fa-envelope icon"></i></a><a
								href="mailto:webmaster@example.com">garaoto@hotmail.com</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="menu">
		<div class="container">

			<div class="menu-iner flex">
				<div class="btn-group-vertical">


					<div class="tennv-iner flex">
						<%
							if (nv != null) {
						%>
						<div class="vitri"><%=nv.getViTri()%>:
						</div>

						<div class="ten">
							&nbsp;<%=nv.getHoTen().getHo() + " " + nv.getHoTen().getTenDem() + " " + nv.getHoTen().getTen()%></div>

					</div>
					<a href="./gdTrangChu.jsp?nhanvienkho=<%=nv.getViTri()%>"><button
							class="btn btn-primary">Giao linh kiện</button></a> <a
						style="padding-top: 10px" href="./">Đăng xuất</a>
					<%
						}
					%>
				</div>
			</div>
		</div>
	</div>
	<div class="footer">
		<div class="container">
			<div class="footer-top">
				<div class="footer-left">
					<div class="footer-left-inner">
						<div class="footer-left-tittle">Về chúng tôi</div>
						<div class="footer-left-des">
							<div class="text">Là một địa chỉ chuyên cung cấp dịch vụ
								dịch vụ bảo trì, bảo dưỡng và sửa chữa xe ô tô tại Hà Nội. Uy
								tín, chất lượng, chuyên nghiệp, tận tình, nhanh chóng, giá tốt
								nhất</div>
							<div class="social-icon">
								<a href="#"><i class="fab fa-twitter"></i> </a> <a href="#"><i
									class="fab fa-linkedin-in"></i></a> <a href="#"><i
									class="fab fa-behance-square"></i> </a> <a href="#"><i
									class="fas fa-basketball-ball"></i></a>
							</div>
						</div>

					</div>
				</div>
				<div class="footer-right">
					<div class="footer-right-inner">
						<div class="footer-right-tittle">Địa chỉ Gara</div>
						<div class="footer-right-des">
							<div class="address flex">
								<div class="icon">
									<a href="https://www.google.com/maps/place/%C4%90%C6%B0%E1%BB%9Dng+Nguy%E1%BB%85n+Tr%C3%A3i,+H%C3%A0+%C4%90%C3%B4ng,+H%C3%A0+N%E1%BB%99i,+Vi%E1%BB%87t+Nam/@20.9762166,105.7707207,16z/data=!4m20!1m14!4m13!1m4!2m2!1d105.7703291!2d20.9802753!4e1!1m6!1m2!1s0x3134532b86f53cbf:0xbc72c28369179eac!2zxJDGsOG7nW5nIE5ndXnhu4VuIFRyw6NpLCBIw6AgxJDDtG5nLCBIw6AgTuG7mWk!2m2!1d105.7798913!2d20.9718128!3e0!3m4!1s0x3134532b86f53cbf:0xbc72c28369179eac!8m2!3d20.9718128!4d105.7798913" target="_blank"><i class="far fa-map"></i></a>
								</div>
								<div class="description">
									<a href="https://www.google.com/maps/place/%C4%90%C6%B0%E1%BB%9Dng+Nguy%E1%BB%85n+Tr%C3%A3i,+H%C3%A0+%C4%90%C3%B4ng,+H%C3%A0+N%E1%BB%99i,+Vi%E1%BB%87t+Nam/@20.9762166,105.7707207,16z/data=!4m20!1m14!4m13!1m4!2m2!1d105.7703291!2d20.9802753!4e1!1m6!1m2!1s0x3134532b86f53cbf:0xbc72c28369179eac!2zxJDGsOG7nW5nIE5ndXnhu4VuIFRyw6NpLCBIw6AgxJDDtG5nLCBIw6AgTuG7mWk!2m2!1d105.7798913!2d20.9718128!3e0!3m4!1s0x3134532b86f53cbf:0xbc72c28369179eac!8m2!3d20.9718128!4d105.7798913" target="_blank">Km10 Trần Phú, Hà Đông, Hà Nội</a>
								</div>
							</div>
							<div class="phone-number flex">
								<div class="icon">
									<a href="tel:+1 23456789"><i class="fas fa-phone-alt"></i></a>
								</div>
								<div class="description">
									<a href="tel:+1 23456789">+1 23456789</a>
								</div>
							</div>
							<div class="email flex">
								<div class="icon">
									<a href="mailto:webmaster@example.com"><i class="far fa-envelope"></i></a>
								</div>
								<div class="description">
									<a href="mailto:garaoto@hotmail.com">garaoto@hotmail.com</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="footer-bottom">
				<div class="container">
					<div class="footer-bottom-inner">
						<div class="footer-bottom-left">
							© Copyright 2021 & Made with by <i class="fas fa-heart"></i>&nbsp;<span
								class="white-text">PTIT</span>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>