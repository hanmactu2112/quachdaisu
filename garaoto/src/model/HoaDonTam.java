package model;

import java.util.ArrayList;
import java.util.Date;

public class HoaDonTam {
	String id;
	Date ngayLap;
	String tinhTrang;
	ArrayList<HoaDonLinhKien> dsHoaDonLinhKiens;
	ArrayList<HoaDonDichVu> dsHoaDonDichVus;
	Xe xe;
	PhuTrachKyThuat nguoiLap;
	SlotGara slotGara;
	NhanVienKho nguoiGiao;

	

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public Date getNgayLap() {
		return ngayLap;
	}



	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}



	public String getTinhTrang() {
		return tinhTrang;
	}



	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}



	public ArrayList<HoaDonLinhKien> getDsHoaDonLinhKiens() {
		return dsHoaDonLinhKiens;
	}



	public void setDsHoaDonLinhKiens(ArrayList<HoaDonLinhKien> dsHoaDonLinhKiens) {
		this.dsHoaDonLinhKiens = dsHoaDonLinhKiens;
	}



	public ArrayList<HoaDonDichVu> getDsHoaDonDichVus() {
		return dsHoaDonDichVus;
	}



	public void setDsHoaDonDichVus(ArrayList<HoaDonDichVu> dsHoaDonDichVus) {
		this.dsHoaDonDichVus = dsHoaDonDichVus;
	}



	public Xe getXe() {
		return xe;
	}



	public void setXe(Xe xe) {
		this.xe = xe;
	}



	public PhuTrachKyThuat getNguoiLap() {
		return nguoiLap;
	}



	public void setNguoiLap(PhuTrachKyThuat nguoiLap) {
		this.nguoiLap = nguoiLap;
	}



	public SlotGara getSlotGara() {
		return slotGara;
	}



	public void setSlotGara(SlotGara slotGara) {
		this.slotGara = slotGara;
	}



	public NhanVienKho getNguoiGiao() {
		return nguoiGiao;
	}



	public void setNguoiGiao(NhanVienKho nguoiGiao) {
		this.nguoiGiao = nguoiGiao;
	}



	public HoaDonTam() {
		super();
		// TODO Auto-generated constructor stub
	}



	public HoaDonTam(String id, Date ngayLap, String tinhTrang, ArrayList<HoaDonLinhKien> dsHoaDonLinhKiens,
			ArrayList<HoaDonDichVu> dsHoaDonDichVus, Xe xe, PhuTrachKyThuat nguoiLap, SlotGara slotGara,
			NhanVienKho nguoiGiao) {
		super();
		this.id = id;
		this.ngayLap = ngayLap;
		this.tinhTrang = tinhTrang;
		this.dsHoaDonLinhKiens = dsHoaDonLinhKiens;
		this.dsHoaDonDichVus = dsHoaDonDichVus;
		this.xe = xe;
		this.nguoiLap = nguoiLap;
		this.slotGara = slotGara;
		this.nguoiGiao = nguoiGiao;
	}



	

}
