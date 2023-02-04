package model;

public class NhanVien extends ThanhVien{
	String username, password, viTri;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getViTri() {
		return viTri;
	}

	public void setViTri(String viTri) {
		this.viTri = viTri;
	}

	public NhanVien(String username, String password, String viTri) {
		super();
		this.username = username;
		this.password = password;
		this.viTri = viTri;
	}

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
