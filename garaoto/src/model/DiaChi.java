package model;

public class DiaChi {
	int id, soNha;
	String toaNha, xomPho, quanHuyen, tinhThanh;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSoNha() {
		return soNha;
	}
	public void setSoNha(int soNha) {
		this.soNha = soNha;
	}
	public String getToaNha() {
		return toaNha;
	}
	public void setToaNha(String toaNha) {
		this.toaNha = toaNha;
	}
	public String getXomPho() {
		return xomPho;
	}
	public void setXomPho(String xomPho) {
		this.xomPho = xomPho;
	}
	public String getQuanHuyen() {
		return quanHuyen;
	}
	public void setQuanHuyen(String quanHuyen) {
		this.quanHuyen = quanHuyen;
	}
	public String getTinhThanh() {
		return tinhThanh;
	}
	public void setTinhThanh(String tinhThanh) {
		this.tinhThanh = tinhThanh;
	}
	public DiaChi(int id, int soNha, String toaNha, String xomPho, String quanHuyen, String tinhThanh) {
		super();
		this.id = id;
		this.soNha = soNha;
		this.toaNha = toaNha;
		this.xomPho = xomPho;
		this.quanHuyen = quanHuyen;
		this.tinhThanh = tinhThanh;
	}
	public DiaChi() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
