package unittest;

import org.junit.Assert;
import org.junit.Test;

import dao.DAO;
import dao.HoaDonTamDAO;
import model.HoaDonTam;
import model.NhanVienKho;

public class testHoaDonTamDAO {
	HoaDonTamDAO testhdtDAO = new HoaDonTamDAO();

	// test getHoaDonTam()
	@Test
	public void getHoaDonTam_test1() {
		String mhdtest = "HD001";
		HoaDonTam testhdt = testhdtDAO.getHoaDonTam(mhdtest);
		Assert.assertNotNull(testhdt);
		Assert.assertEquals(mhdtest, testhdt.getId());
	}

	@Test
	public void getHoaDonTam_test2() {
		// TÃ¬m kiáº¿m hÃ³a Ä‘Æ¡n chÆ°a tá»“n táº¡i trong db
		String mhdtest = "HD100";
		HoaDonTam testhdt = testhdtDAO.getHoaDonTam(mhdtest);
		Assert.assertNull(testhdt.getId());
		System.out.println(testhdt.getId());
	}

	@Test
	public void getHoaDonTam_test3() {
		// TÃ¬m kiáº¿m hÃ³a Ä‘Æ¡n Ä‘Ã£ tá»“n táº¡i vÃ  chÆ°a Ä‘Æ°á»£c giao trong db
		String mhdtest = "HD007";
		HoaDonTam testhdt = testhdtDAO.getHoaDonTam(mhdtest);
		Assert.assertNotNull(testhdt);
		Assert.assertEquals(mhdtest, testhdt.getId());
		Assert.assertEquals(mhdtest, testhdt.getId());
		Assert.assertEquals("ChÆ°a giao", testhdt.getTinhTrang());
	}

	@Test
	public void getHoaDonTam_test4() {
		// TÃ¬m kiáº¿m hÃ³a Ä‘Æ¡n Ä‘Ã£ tá»“n táº¡i vÃ  Ä‘Ã£ Ä‘Æ°á»£c giao trong db
		String mhdtest = "HD001";
		HoaDonTam testhdt = testhdtDAO.getHoaDonTam(mhdtest);
		Assert.assertNotNull(testhdt);
		Assert.assertEquals(mhdtest, testhdt.getId());
		Assert.assertEquals(mhdtest, testhdt.getId());
		Assert.assertEquals("Ä�Ã£ giao", testhdt.getTinhTrang());
	}
	// end test getHoaDonTam()

	// test setTinhTrang()
	@Test
	public void getHoaDonTam_test5() {
		// MÃ£ hÃ³a Ä‘Æ¡n tá»“n táº¡i, chÆ°a giao, ngÆ°á»�i giao tá»“n táº¡i, ngÆ°á»�i giao lÃ  nhÃ¢n viÃªn
		// kho
		String mhdtest = "HD002";
		int nggiaotest = 12;
		try {
			DAO.con.setAutoCommit(false);
			boolean ok = testhdtDAO.setTinhTrang(mhdtest, nggiaotest);
			Assert.assertTrue(ok);
			// lay ra kiem tra
			HoaDonTam hdttestNew = testhdtDAO.getHoaDonTam(mhdtest);
			int nggiaotestNew = hdttestNew.getNguoiGiao().getId();
			Assert.assertNotNull(hdttestNew);
			Assert.assertNotNull(nggiaotestNew);
			Assert.assertEquals(mhdtest, hdttestNew.getId());
			Assert.assertEquals(nggiaotest, nggiaotestNew);
			Assert.assertEquals(hdttestNew.getTinhTrang(), "Ä�Ã£ giao");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DAO.con.rollback();
				DAO.con.setAutoCommit(true);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	@Test
	public void getHoaDonTam_test6() {
		// MÃ£ hÃ³a Ä‘Æ¡n tá»“n táº¡i, chÆ°a giao, ngÆ°á»�i giao tá»“n táº¡i, ngÆ°á»�i giao khÃ´ng pháº£i nhÃ¢n
		// viÃªn kho
		String mhdtest = "HD001";
		int nggiaotest = 13;
		boolean kq = testhdtDAO.setTinhTrang(mhdtest, nggiaotest);
		Assert.assertFalse(kq);
	}

	@Test
	public void getHoaDonTam_test7() {
		// MÃ£ hÃ³a Ä‘Æ¡n tá»“n táº¡i, chÆ°a giao, ngÆ°á»�i giao khÃ´ng tá»“n táº¡i
		String mhdtest = "HD002";
		int nggiaotest = 40;
		boolean kq = testhdtDAO.setTinhTrang(mhdtest, nggiaotest);
		Assert.assertFalse(kq);
	}

	@Test
	public void getHoaDonTam_test8() {
		// MÃ£ hÃ³a Ä‘Æ¡n khÃ´ng tá»“n táº¡i, ngÆ°á»�i giao khÃ´ng tá»“n táº¡i
		String mhdtest = "HD200";
		int nggiaotest = 40;
		boolean kq = testhdtDAO.setTinhTrang(mhdtest, nggiaotest);
		Assert.assertFalse(kq);
	}

	@Test
	public void getHoaDonTam_test9() {
		// MÃ£ Ä‘Æ¡n khÃ´ng tá»“n táº¡i, ngÆ°á»�i giao tá»“n táº¡i vÃ  ngÆ°á»�i giao lÃ  nhÃ¢n viÃªn kho
		String mhdtest = "HD200";
		int nggiaotest = 12;
		boolean kq = testhdtDAO.setTinhTrang(mhdtest, nggiaotest);
		Assert.assertFalse(kq);
	}

	@Test
	public void getHoaDonTam_test10() {
		// MÃ£ Ä‘Æ¡n khÃ´ng tá»“n táº¡i, ngÆ°á»�i giao tá»“n táº¡i vÃ  ngÆ°á»�i giao khÃ´ng pháº£i nhÃ¢n viÃªn
		// kho
		String mhdtest = "HD200";
		int nggiaotest = 14;
		boolean kq = testhdtDAO.setTinhTrang(mhdtest, nggiaotest);
		Assert.assertFalse(kq);
	}

	@Test
	public void getHoaDonTam_test11() {
		// MÃ£ hÃ³a Ä‘Æ¡n tá»“n táº¡i vÃ  Ä‘Ã£ Ä‘Æ°á»£c giao, ngÆ°á»�i giao khÃ´ng tá»“n táº¡i
		String mhdtest = "HD001";
		int nggiaotest = 94;
		boolean kq = testhdtDAO.setTinhTrang(mhdtest, nggiaotest);
		Assert.assertFalse(kq);
	}

	@Test
	public void getHoaDonTam_test12() {
		// MÃ£ hÃ³a Ä‘Æ¡n tá»“n táº¡i vÃ  Ä‘Ã£ Ä‘Æ°á»£c giao, ngÆ°á»�i giao lÃ  nhÃ¢n viÃªn kho
		String mhdtest = "HD001";
		int nggiaotest = 12;
		boolean kq = testhdtDAO.setTinhTrang(mhdtest, nggiaotest);
		Assert.assertFalse(kq);
	}

	@Test
	public void getHoaDonTam_test13() {
		// MÃ£ hÃ³a Ä‘Æ¡n tá»“n táº¡i vÃ  Ä‘Ã£ Ä‘Æ°á»£c giao, ngÆ°á»�i giao khÃ´ng pháº£i nhÃ¢n viÃªn kho
		String mhdtest = "HD001";
		int nggiaotest = 2;
		boolean kq = testhdtDAO.setTinhTrang(mhdtest, nggiaotest);
		Assert.assertFalse(kq);
	}

}
