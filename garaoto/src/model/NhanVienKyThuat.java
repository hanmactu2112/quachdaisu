package model;

public class NhanVienKyThuat extends NhanVien{
	String tinhTrang;

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public NhanVienKyThuat(String tinhTrang) {
		super();
		this.tinhTrang = tinhTrang;
	}

	public NhanVienKyThuat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
