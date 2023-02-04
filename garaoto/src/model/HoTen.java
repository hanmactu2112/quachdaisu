package model;

public class HoTen {
	int id;
	String ten;
	String tenDem, ho;
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
	public String getTenDem() {
		return tenDem;
	}
	public void setTenDem(String tenDem) {
		this.tenDem = tenDem;
	}
	public String getHo() {
		return ho;
	}
	public void setHo(String ho) {
		this.ho = ho;
	}
	public HoTen(int id, String ten, String tenDem, String ho) {
		super();
		this.id = id;
		this.ten = ten;
		this.tenDem = tenDem;
		this.ho = ho;
	}
	public HoTen() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
