package model;

public class LinhKienDichVu {
	String id;
	String ten;
	float gia;
	String moTa;
	public LinhKienDichVu(String id, String ten, float gia, String mota) {
		super();
		this.id = id;
		this.ten = ten;
		this.gia = gia;
		this.moTa = mota;
	}
	public LinhKienDichVu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}
	public String getMota() {
		return moTa;
	}
	public void setMota(String mota) {
		this.moTa = mota;
	}
	
	

}
