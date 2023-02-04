package model;

public class LinhKien extends LinhKienDichVu{
	int soLuongCon;

	public LinhKien(String id, String ten, float gia, String mota, int soluongcon) {
		super(id, ten, gia, mota);
		this.soLuongCon = soluongcon;
	}

	public LinhKien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LinhKien(String id, String ten, float gia, String mota) {
		super(id, ten, gia, mota);
		// TODO Auto-generated constructor stub
	}

	public int getSoluongcon() {
		return soLuongCon;
	}

	public void setSoluongcon(int soluongcon) {
		this.soLuongCon = soluongcon;
	}
	
	

}
