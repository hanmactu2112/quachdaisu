/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import controller.TrongException;
import java.io.Serializable;

/**
 *
 * @author quach
 */
public class DichVu implements Serializable{
    private int ma;
    private String ten, nhomDV;
    private double chiPhi,giaCuoc;
    private static int sma=1000;

    public DichVu() {
    }

    public DichVu(int ma, String ten, String nhomDV, double chiPhi, double giaCuoc) {
        this.ma = ma;
        this.ten = ten;
        this.nhomDV = nhomDV;
        this.chiPhi = chiPhi;
        this.giaCuoc = giaCuoc;
    }
    
    public DichVu( String ten, String nhomDV, double chiPhi, double giaCuoc) throws TrongException{
        if(ten.isEmpty()) throw new TrongException();
        this.ma = sma++;
        this.ten = ten;
        this.nhomDV = nhomDV;
        this.chiPhi = chiPhi;
        this.giaCuoc = giaCuoc;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNhomDV() {
        return nhomDV;
    }

    public void setNhomDV(String nhomDV) {
        this.nhomDV = nhomDV;
    }

    public double getChiPhi() {
        return chiPhi;
    }

    public void setChiPhi(double chiPhi) {
        this.chiPhi = chiPhi;
    }

    public double getGiaCuoc() {
        return giaCuoc;
    }

    public void setGiaCuoc(double giaCuoc) {
        this.giaCuoc = giaCuoc;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        DichVu.sma = sma;
    }
    public Object[] toObject(){
        return new Object[]{
            ma,ten,nhomDV,chiPhi,giaCuoc
        };
    }
    
}
