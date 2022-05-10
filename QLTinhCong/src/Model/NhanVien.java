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
public class NhanVien implements Serializable{
    private int maNV;
    private String ten, diaChi,sdt;
    private static int sma=1000;
    public NhanVien() {
    }

    public NhanVien(int maNV,  String ten, String diaChi,String sdt) {
        this.maNV = maNV;
        this.sdt = sdt;
        this.ten = ten;
        this.diaChi = diaChi;
    }
    
    public NhanVien(String ten, String diaChi, String sdt) throws TrongException, DTException{
        if(ten.isEmpty()||diaChi.isEmpty()) throw new TrongException();
        if(!sdt.matches("\\d+")) throw new DTException();
        this.maNV = sma++;
        this.sdt = sdt;
        this.ten = ten;
        this.diaChi = diaChi;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        NhanVien.sma = sma;
    }
    public Object[] toObject(){
        return new Object[]{
            maNV,ten,diaChi,sdt
        };
    }
    
}
