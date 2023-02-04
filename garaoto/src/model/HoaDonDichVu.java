package model;


public class HoaDonDichVu {
	int id;
	DichVu dichVu;
	int soLuong;
	float thanhTien;
	NhanVienKyThuat nhanVienKyThuat;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DichVu getDichVu() {
		return dichVu;
	}

	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	

	public float getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(float thanhTien ) {
		this.thanhTien = thanhTien;
	}

	public NhanVienKyThuat getNhanvienkythuat() {
		return nhanVienKyThuat;
	}

	public void setNhanvienkythuat(NhanVienKyThuat nhanVienKyThuat) {
		this.nhanVienKyThuat = nhanVienKyThuat;
	}

	public HoaDonDichVu(int id, DichVu dichVu, int soLuong,float thanhTien, NhanVienKyThuat nhanVienKyThuat) {
		super();
		this.id = id;
		this.dichVu = dichVu;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
		this.nhanVienKyThuat = nhanVienKyThuat;
	}

	public HoaDonDichVu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return dichVu.getTen() + " " + dichVu.getGia() + " " + dichVu.getMota() + " " + soLuong;
	}

}
