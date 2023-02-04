package dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.DichVu;
import model.HoTen;
import model.HoaDonDichVu;
import model.HoaDonLinhKien;
import model.HoaDonTam;
import model.KhachHang;
import model.LinhKien;
import model.NhanVienKho;
import model.NhanVienKyThuat;
import model.PhuTrachKyThuat;
import model.SlotGara;
import model.Xe;

public class HoaDonTamDAO extends DAO {

	public HoaDonTamDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HoaDonTam getHoaDonTam(String maHoaDon) {
		HoaDonTam hdt = new HoaDonTam();
		String sql = "SELECT hdt.Id, hdt.Ngaylap, hdt.Tinhtrang, hdt.NguoiGiao, ptkt.tblNhanvienThanhVienId"
				+ ", x.Ten, x.Bienso, x.KhachhangThanhvienId, sg.Tenslot"
				+ " FROM dbgara.tblhoadontam hdt, tblxe x, tblphutrachkythuat ptkt, tblslotgara sg"
				+ " WHERE x.Id = hdt.XeId AND sg.Id = hdt.SlotGaraId"
				+ " AND ptkt.tblNhanvienThanhVienId = hdt.tblPhutrachkythuattblNhanvienThanhVienId" + " AND hdt.Id = ?";

		try {
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, maHoaDon);
			ResultSet rs = cs.executeQuery();

			if (rs.next()) {
				hdt.setId(rs.getString("Id"));
				hdt.setNgayLap(rs.getDate("Ngaylap"));
				hdt.setTinhTrang(rs.getString("Tinhtrang"));
				NhanVienKho nVienKho = new NhanVienKho();
				nVienKho.setId(rs.getInt("NguoiGiao"));
				hdt.setNguoiGiao(nVienKho);
				PhuTrachKyThuat ptkt = new PhuTrachKyThuat();
				int ptktId = rs.getInt("tblNhanvienThanhVienId");

				String sql2 = "SELECT ht.Ho, ht.TenDem, ht.Ten"
						+ " FROM tblhoten ht, tblthanhvien tv, tblnhanvien nv, tblphutrachkythuat ptkt"
						+ " WHERE tv.Id = ht.ThanhvienId AND tv.Id = nv.ThanhvienId"
						+ " AND nv.ThanhvienId = ptkt.tblNhanvienThanhVienId" + " AND ptkt.tblNhanvienThanhVienId = ?";
				try {
					CallableStatement cs2 = con.prepareCall(sql2);
					cs2.setInt(1, ptktId);
					ResultSet rs2 = cs2.executeQuery();

					if (rs2.next()) {
						HoTen htPTKT = new HoTen();
						htPTKT.setHo(rs2.getString("Ho"));
						htPTKT.setTenDem(rs2.getString("TenDem"));
						htPTKT.setTen(rs2.getString("Ten"));
						ptkt.setHoTen(htPTKT);
						hdt.setNguoiLap(ptkt);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				Xe xe = new Xe();
				xe.setTen(rs.getString("Ten"));
				xe.setBienso(rs.getString("Bienso"));

				KhachHang kh = new KhachHang();
				int khId = rs.getInt("KhachhangThanhvienId");

				String sql3 = "SELECT ht.Ho, ht.TenDem, ht.Ten"
						+ " FROM tblhoten ht, tblthanhvien tv, tblkhachhang kh, tblxe x"
						+ " WHERE tv.Id = ht.ThanhvienId AND tv.Id = kh.ThanhvienId"
						+ " AND kh.ThanhvienId = x.KhachhangThanhvienId" + " AND x.KhachhangThanhvienId = ?";

				try {
					CallableStatement cs3 = con.prepareCall(sql3);
					cs3.setInt(1, khId);
					ResultSet rs3 = cs3.executeQuery();

					if (rs3.next()) {
						HoTen htKH = new HoTen();
						htKH.setHo(rs3.getString("Ho"));
						htKH.setTenDem(rs3.getString("TenDem"));
						htKH.setTen(rs3.getString("Ten"));
						kh.setHoTen(htKH);
						xe.setKh(kh);
						hdt.setXe(xe);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				SlotGara slotGara = new SlotGara();
				slotGara.setTenSlot(rs.getString("Tenslot"));
				hdt.setSlotGara(slotGara);
				ArrayList<HoaDonLinhKien> dsHoaDonLinhKiens = new ArrayList<>();
				String sql4 = "SELECT lkdv.Ten, hdlk.GiaXuat, lkdv.Mota, hdlk.Soluongxuat" 
						+ " FROM tblhoadontam hdt, tblhoadonlinhkien hdlk, tbllinhkien lk, tbllinhkiendichvu lkdv"
						+ " WHERE lkdv.Id = lk.LinhkienDichvuId AND lk.LinhkienDichvuId = hdlk.LinhkienLinhkienDichvuId"
						+ " AND hdlk.HoaDonTamId = hdt.Id" + " AND hdt.Id = ?";
				try {
					CallableStatement cs4 = con.prepareCall(sql4);
					cs4.setString(1, hdt.getId());
					ResultSet rs4 = cs4.executeQuery();

					while (rs4.next()) {
						HoaDonLinhKien hdlk = new HoaDonLinhKien();
						LinhKien lk = new LinhKien();
						lk.setTen(rs4.getString("Ten"));
						lk.setMota(rs4.getString("Mota"));
						hdlk.setGiaxuat(rs4.getFloat("GiaXuat"));						
						hdlk.setLinhkien(lk);
						hdlk.setSoluongxuat(rs4.getInt("Soluongxuat"));
						dsHoaDonLinhKiens.add(hdlk);
					}
					hdt.setDsHoaDonLinhKiens(dsHoaDonLinhKiens);
				} catch (Exception e) {
					e.printStackTrace();
				}

				ArrayList<HoaDonDichVu> dsHoaDonDichVus = new ArrayList<>();

				String sql5 = "SELECT lkdv.Ten, lkdv.Gia, lkdv.Mota, hddv.Soluong"
						+ " FROM tblhoadontam hdt, tblhoadondichvu hddv, tbldichvu dv, tbllinhkiendichvu lkdv"
						+ " WHERE lkdv.Id = dv.LinhkienDichvuId AND dv.LinhkienDichvuId = hddv.DichvuLinhkienDichvuId"
						+ " AND hddv.HoaDonTamId = hdt.Id" + " AND hdt.Id = ?";

				try {
					CallableStatement cs5 = con.prepareCall(sql5);
					cs5.setString(1, hdt.getId());
					ResultSet rs5 = cs5.executeQuery();
					while (rs5.next()) {
						HoaDonDichVu hddv = new HoaDonDichVu();
						DichVu dv = new DichVu();						
						dv.setTen(rs5.getString("Ten"));
						dv.setGia(rs5.getFloat("Gia"));
						dv.setMota(rs5.getString("Mota"));
						hddv.setDichVu(dv);
						hddv.setSoLuong(rs5.getInt("Soluong"));
						dsHoaDonDichVus.add(hddv);
					}
					hdt.setDsHoaDonDichVus(dsHoaDonDichVus);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hdt;
	}

	public boolean setTinhTrang(String maHoaDonGiao, int nguoiGiao) {
		boolean kq = false;

		String sql8 = "SELECT COUNT(*) FROM tblnhanvienkho" + " WHERE tblNhanvienThanhvienId = ?";
		try {

			CallableStatement cs8 = con.prepareCall(sql8);

			cs8.setInt(1, nguoiGiao);
			ResultSet rs = cs8.executeQuery();
			if (rs.next()) {

				kq = rs.getInt(1) > 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			kq = false;
		}
		if (kq) {
			String sql7 = "UPDATE dbgara.tblhoadontam SET Tinhtrang=?, NguoiGiao=? WHERE Id=?";
			try {
				this.con.setAutoCommit(false);
				CallableStatement cs7 = con.prepareCall(sql7);
				cs7.setString(1, "Đã giao");
				cs7.setInt(2, nguoiGiao);
				cs7.setString(3, maHoaDonGiao);
				cs7.executeUpdate();
				this.con.commit();// cmt dong nay ney chay che do JUnit test

			} catch (Exception e) {
				try {
					this.con.rollback();// cmt dong nay ney chay che do JUnit test
				} catch (Exception ee) {
					kq = false;
					ee.printStackTrace();
				}
				e.printStackTrace();
			} finally {
				try {
					this.con.setAutoCommit(true);// cmt dong nay neu chay che do JUnit test
				} catch (Exception e) {
					kq = false;
					e.printStackTrace();
				}
			}
		}
		return kq;
	}
}
