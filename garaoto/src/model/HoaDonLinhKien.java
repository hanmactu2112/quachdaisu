package model;

public class HoaDonLinhKien {
	String id;
	LinhKien linhKien;
	int soLuongXuat;
	float thanhTien;
	float giaXuat;
	NhanVienKyThuat nhanVienKyThuat;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LinhKien getLinhkien() {
		return linhKien;
	}

	public void setLinhkien(LinhKien linhkien) {
		this.linhKien = linhkien;
	}

	public int getSoluongxuat() {
		return soLuongXuat;
	}

	public void setSoluongxuat(int soluongxuat) {
		this.soLuongXuat = soluongxuat;
	}

	public float getThanhtien() {
		return thanhTien;
	}

	public void setThanhtien(float thanhTien) {
		this.thanhTien = thanhTien;
	}

	public float getGiaxuat() {
		return giaXuat;
	}

	public void setGiaxuat(float giaxuat) {
		this.giaXuat = giaxuat;
	}

	public NhanVienKyThuat getNhanvienkythuat() {
		return nhanVienKyThuat;
	}

	public void setNhanvienkythuat(NhanVienKyThuat nhanVienKyThuat) {
		this.nhanVienKyThuat = nhanVienKyThuat;
	}

	public HoaDonLinhKien(String id, LinhKien linhkien,float thanhTien, int soluongxuat, float giaxuat,
			NhanVienKyThuat nhanVienKyThuat) {
		super();
		this.id = id;
		this.linhKien = linhkien;
		this.soLuongXuat = soluongxuat;
		this.thanhTien = thanhTien;
		this.giaXuat = giaxuat;
		this.nhanVienKyThuat = nhanVienKyThuat;
	}

	public HoaDonLinhKien() {
		super();
		// TODO Auto-generated constructor stub
	}
}
