<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="java.util.ArrayList,dao.*,model.*"%>
<%
String username = (String) request.getParameter("username");
String password = (String) request.getParameter("password");
NhanVien nv = new NhanVien();
nv.setUsername(username);
nv.setPassword(password);

NhanVienDAO daodn = new NhanVienDAO();
boolean kq = daodn.checkLogin(nv);

if (kq == true) {
	response.sendRedirect("./gdTrangChu.jsp");
	session.setAttribute("nhanvien", nv);
	

	
}

else{
	response.sendRedirect("gddangnhap.jsp?err=fail");
}
%>