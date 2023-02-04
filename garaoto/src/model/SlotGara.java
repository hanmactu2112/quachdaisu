package model;

public class SlotGara {
	int id;
	String tenSlot;
	String trangThai;
	String moTa;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenSlot() {
		return tenSlot;
	}
	public void setTenSlot(String tenSlot) {
		this.tenSlot = tenSlot;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public SlotGara(int id, String tenSlot, String trangThai, String moTa) {
		super();
		this.id = id;
		this.tenSlot = tenSlot;
		this.trangThai = trangThai;
		this.moTa = moTa;
	}
	public SlotGara() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
