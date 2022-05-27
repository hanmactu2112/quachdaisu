/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import controller.DTException;
import controller.TrongException;
import java.io.Serializable;

/**
 *
 * @author quach
 */
public class QLBH implements Serializable{

    private int soLuong;
    private DichVu dichVu;
    private NhanVien nhanVien;

    public QLBH() {
    }

    public QLBH(NhanVien nhanVien, DichVu dichVu, int soLuong) {
        this.nhanVien = nhanVien;
        this.dichVu = dichVu;
        this.soLuong = soLuong;
    }
    
    public DichVu getDichVu() {
        return dichVu;
    }
    
    public String getTenDichVu() {
        return getDichVu().getTen();
    }

    public void setDichVu(DichVu dichVu) {
        this.dichVu = dichVu;
    }
    public Double tinhTienCong(){
        return dichVu.getChiPhi()*soLuong*0.02;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }
    
    
    public String getTenNhanVien() {
        return getNhanVien().getTen();
    }
    
    public String getMaVaTen() {
        return nhanVien.getMaNV() + "\t" + nhanVien.getTen();
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
     public Object[] toObject(){
        return new Object[]{
            nhanVien.getMaNV(), nhanVien.getTen(),dichVu.getMa(),dichVu.getTen(),soLuong
        };
    }

    
//    public int compareTo(QLBH t) {
//        return t.getNhanVien().getTen().compareTo(getNhanVien().getTen());
//    }

   
}
