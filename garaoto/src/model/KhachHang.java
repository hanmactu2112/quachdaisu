package model;

import java.util.ArrayList;

public class KhachHang extends ThanhVien{
	ArrayList<Xe> xe;

	public ArrayList<Xe> getXe() {
		return xe;
	}

	public void setXe(ArrayList<Xe> xe) {
		this.xe = xe;
	}

	public KhachHang(ArrayList<Xe> xe) {
		super();
		this.xe = xe;
	}

	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	
}
