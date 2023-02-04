package model;

public class Xe {
	int id;
	String ten;
	String bienSo;
	String moTa;
	KhachHang khachHang;
	String tinhTrang;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getBienso() {
		return bienSo;
	}
	public void setBienso(String bienso) {
		this.bienSo = bienso;
	}
	public String getMota() {
		return moTa;
	}
	public void setMota(String mota) {
		this.moTa = mota;
	}
	public KhachHang getKh() {
		return khachHang;
	}
	public void setKh(KhachHang kh) {
		this.khachHang = kh;
	}
	public String getTinhtrang() {
		return tinhTrang;
	}
	public void setTinhtrang(String tinhtrang) {
		this.tinhTrang = tinhtrang;
	}
	public Xe(int id, String ten, String bienso, String mota, KhachHang kh, String tinhtrang) {
		super();
		this.id = id;
		this.ten = ten;
		this.bienSo = bienso;
		this.moTa = mota;
		this.khachHang = kh;
		this.tinhTrang = tinhtrang;
	}
	public Xe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
