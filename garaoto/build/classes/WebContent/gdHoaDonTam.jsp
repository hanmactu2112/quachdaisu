<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.HoaDonTam"%>
<%@page import="model.HoaDonLinhKien"%>
<%@page import="model.HoaDonDichVu"%>
<%@page import="dao.HoaDonTamDAO"%>
<%@page import="model.NhanVien"%>
<%@page import="model.ThanhVien"%>


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
<title>Hóa đơn tạm</title>
</head>

<body>

	<%
		NhanVien nv = (NhanVien) session.getAttribute("nhanvien");
		HoaDonTam hdt = (HoaDonTam) session.getAttribute("hoadontam");
		if (nv == null) {
			response.sendRedirect("./gddangnhap.jsp");
			
		}
	%>
	<%
	String idHoaDonTam = "";
	int nguoiGiao;
	
		
	
	if(request.getParameter("idhoadon")!=null ){
		nguoiGiao = nv.getId();
		idHoaDonTam = request.getParameter("idhoadon");
		HoaDonTamDAO stt = new HoaDonTamDAO();
		boolean kq2 = stt.setTinhTrang(idHoaDonTam,nguoiGiao);
		
			if (kq2 && !hdt.getTinhTrang().equals("Đã giao")) {
				%>
				<script type="text/javascript">
					alert("Giao linh kiện thành công");
					window.location.href = "./gdTimHoaDonTam.jsp";
				</script>

				<%
				session.setAttribute("nhanvien", nv);
			}
			else if(hdt.getTinhTrang().equals("Đã giao")){
				%>
				<script type="text/javascript">
					alert("Hóa đơn đã được giao");
					window.location.href = "./gdTimHoaDonTam.jsp";
				</script>
				<%						
			}
			else {
				%>
				<script type="text/javascript">
					alert("Giao linh kiện thất bại");
					window.location.href = "./gdTimHoaDonTam.jsp";
				</script>
				<%						
			}
		
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
	<div class="hoadontam">
		<div class="container">
			<% if(nv!=null){
						%>
			<div class="hoadontam-inner">
				<div class=" flex">
					<div class="title-hd">Hóa đơn tạm</div>
				</div>
				<div class="content">

					<div class="content-list">
						Mã hóa đơn:
						<%=hdt.getId()%>
					</div>
					<div class="content-list">
						Khách Hàng:
						<%=hdt.getXe().getKh().getHoTen().getHo()+" "+hdt.getXe().getKh().getHoTen().getTenDem()+" "+hdt.getXe().getKh().getHoTen().getTen()%>
					</div>
					<div class="content-list">
						Tên xe:
						<%=hdt.getXe().getTen()%>
					</div>
					<div class="content-list">
						Biển số xe:
						<%=hdt.getXe().getBienso()%>
					</div>
					<div class="content-list">
						Slotgara:
						<%=hdt.getSlotGara().getTenSlot()%>
					</div>
					<div class="content-list">
						Ngày lập:
						<%=hdt.getNgayLap()%>
					</div>
					<div class="content-list">
						Người lập:
						<%=hdt.getNguoiLap().getHoTen().getHo()+" "+hdt.getNguoiLap().getHoTen().getTenDem()+" "+hdt.getNguoiLap().getHoTen().getTen()%>
					</div>
					<div class="content-list">
						Tình trạng:
						<%=hdt.getTinhTrang()%>
					</div>
				</div>

				<table class="line-items-container">
					<thead>
						<tr>
							<th class="heading-quantity">Số lượng </th>
							<th class="heading-description">Tên linh kiện/dịch vụ</th>
							<th class="heading-description">Mô tả</th>
							<th class="heading-description2">Giá xuất</th>
							<th class="heading-description2">Thành tiền</th>
						
						</tr>
					</thead>
					<tbody>

						<% for(HoaDonLinhKien hdlk: hdt.getDsHoaDonLinhKiens()){%>
						<tr class="linhkien">
							<td><%=hdlk.getSoluongxuat()%></td>
							<td><%=hdlk.getLinhkien().getTen()%></td>
							<td><%=hdlk.getLinhkien().getMota()%></td>
							<td class="phai"><%=(long)hdlk.getGiaxuat()%>VNĐ</td>
							<td><%=(long)hdlk.getGiaxuat()*hdlk.getSoluongxuat()%>VNĐ
							</td>
						</tr>
						<%}
							%>
						<% for(HoaDonDichVu hddv: hdt.getDsHoaDonDichVus()){%>
						<tr>
							<td><%=hddv.getSoLuong()%></td>
							<td><%=hddv.getDichVu().getTen()%></td>
							<td><%=hddv.getDichVu().getMota()%></td>
							<td class="phai"><%=(long)hddv.getDichVu().getGia()%>VNĐ</td>
							<td><%=(long)hddv.getDichVu().getGia()*hddv.getSoLuong()%>VNĐ
							</td>
						</tr>
						<%}
							%>
						</tbody>
						<table class="line-items-container has-bottom-border">

						</table>
						<div class="button-hd flex">
							<a href="./gdTimHoaDonTam.jsp"><button type="button"
									class="btn btn-primary dagiao">Quay lại</button></a> 
									<a href="gdHoaDonTam.jsp?idhoadon=<%=hdt.getId()%>"><button class="btn btn-primary dagiao">Đã giao</button></a>
						</div>
						</table>

						</div>
						
						<%
						}
						
						%>
						
						</div>
						</div>

						<div class="footer">
							<div class="container">
								<div class="footer-top">
									<div class="footer-left">
										<div class="footer-left-inner">
											<div class="footer-left-tittle">Về chúng tôi</div>
											<div class="footer-left-des">
												<div class="text">Là một địa chỉ chuyên cung cấp dịch
													vụ dịch vụ bảo trì, bảo dưỡng và sửa chữa xe ô tô tại Hà
													Nội. Uy tín, chất lượng, chuyên nghiệp, tận tình, nhanh
													chóng, giá tốt nhất</div>
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
									<a href="https://www.google.com/maps/place/%C4%90%C6%B0%E1%BB%9Dng+Nguy%E1%BB%85n+Tr%C3%A3i,+H%C3%A0+%C4%90%C3%B4ng,+H%C3%A0+N%E1%BB%99i,+Vi%E1%BB%87t+Nam/@20.9762166,105.7707207,16z/data=!4m20!1m14!4m13!1m4!2m2!1d105.7703291!2d20.9802753!4e1!1m6!1m2!1s0x3134532b86f53cbf:0xbc72c28369179eac!2zxJDGsOG7nW5nIE5ndXnhu4VuIFRyw6NpLCBIw6AgxJDDtG5nLCBIw6AgTuG7mWk!2m2!1d105.7798913!2d20.9718128!3e0!3m4!1s0x3134532b86f53cbf:0xbc72c28369179eac!8m2!3d20.9718128!4d105.7798913"><i class="far fa-map" target="_blank"></i></a>
								</div>
								<div class="description">
									<a href="https://www.google.com/maps/place/%C4%90%C6%B0%E1%BB%9Dng+Nguy%E1%BB%85n+Tr%C3%A3i,+H%C3%A0+%C4%90%C3%B4ng,+H%C3%A0+N%E1%BB%99i,+Vi%E1%BB%87t+Nam/@20.9762166,105.7707207,16z/data=!4m20!1m14!4m13!1m4!2m2!1d105.7703291!2d20.9802753!4e1!1m6!1m2!1s0x3134532b86f53cbf:0xbc72c28369179eac!2zxJDGsOG7nW5nIE5ndXnhu4VuIFRyw6NpLCBIw6AgxJDDtG5nLCBIw6AgTuG7mWk!2m2!1d105.7798913!2d20.9718128!3e0!3m4!1s0x3134532b86f53cbf:0xbc72c28369179eac!8m2!3d20.9718128!4d105.7798913" target="_blank">Km10 Trần Phú, Hà Đông, Hà Nội</a>
								</div>
												</div>
												<div class="phone-number flex">
													<div class="icon">
														<a href="callto:+84386115804"><i class="fas fa-phone-alt"></i></a>
													</div>
													<div class="description">
														<a href="callto:+84386115804">+1 23456789</a>
													</div>
												</div>
												<div class="email flex">
													<div class="icon">
														<a href="mailto:webmaster@example.com"><i class="far fa-envelope"></i></a>
													</div>
													<div class="description">
														<a href="mailto:webmaster@example.com">garaoto@hotmail.com</a>
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