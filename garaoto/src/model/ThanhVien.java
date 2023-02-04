package model;

import java.util.Date;

public class ThanhVien {
	int id;
	String email, ghiChu;
	Date ngaySinh;
	int sdt;
	HoTen hoTen;
	DiaChi diaChi;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public int getSdt() {
		return sdt;
	}
	public void setSdt(int sdt) {
		this.sdt = sdt;
	}
	public HoTen getHoTen() {
		return hoTen;
	}
	public void setHoTen(HoTen hoTen) {
		this.hoTen = hoTen;
	}
	public DiaChi getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(DiaChi diaChi) {
		this.diaChi = diaChi;
	}
	public ThanhVien(int id, String email, String ghiChu, Date ngaySinh, int sdt, HoTen hoTen, DiaChi diaChi) {
		super();
		this.id = id;
		this.email = email;
		this.ghiChu = ghiChu;
		this.ngaySinh = ngaySinh;
		this.sdt = sdt;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
	}
	public ThanhVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
