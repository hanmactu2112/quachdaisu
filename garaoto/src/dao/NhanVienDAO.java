package dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;

import model.HoTen;
import model.NhanVien;

public class NhanVienDAO extends DAO {

	public NhanVienDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public boolean checkLogin(NhanVien nv){
        boolean kq = false;
        String sql = "SELECT * FROM tblnhanvien WHERE Username = ? AND Password = ?"; 
        
        try{
            CallableStatement cs = con.prepareCall(sql);
            cs.setString(1,nv.getUsername());
            cs.setString(2,nv.getPassword());
            ResultSet rs = cs.executeQuery();
             
            if(rs.next()){
            	nv.setViTri(rs.getString("ViTri"));
            	nv.setId(rs.getInt("ThanhvienId"));
            	kq=true;
            }
            
            String sql2 = "SELECT * FROM tblhoten WHERE ThanhvienId = ?";
            CallableStatement cs2 = con.prepareCall(sql2);
            cs2.setInt(1, nv.getId());
            ResultSet rs2 = cs2.executeQuery();
            HoTen ht = new HoTen();
            if(rs2.next()) {
            	ht.setHo(rs2.getString("Ho"));
            	ht.setTen(rs2.getString("Ten"));
            	ht.setTenDem(rs2.getString("TenDem"));
            	nv.setHoTen(ht);
            }
            
        }catch(Exception e){
            e.printStackTrace();
            kq = false;
        }
        return kq;
    }
}
