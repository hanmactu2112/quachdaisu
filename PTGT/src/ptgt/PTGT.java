/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptgt;

import java.util.Calendar;

/**
 *
 * @author quach
 */
public class PTGT implements Comparable<PTGT>{
   private String soKhungXe;
   private int namSX;
   private double giaBan;
   private String mau;

    public PTGT() {
    }

    public PTGT(String soKhungXe, int namSX, double giaBan, String mau) {
        this.soKhungXe = soKhungXe;
        this.namSX = namSX;
        this.giaBan = giaBan;
        this.mau = mau;
    }
   
   

    public String getSoKhungXe() {
        return soKhungXe;
    }

    public void setSoKhungXe(String soKhungXe) {
        this.soKhungXe = soKhungXe;
    }

    public int getNamSX() {
        return namSX;
    }

    public void setNamSX(int namSX) {
        this.namSX = namSX;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }
   
   public boolean checkNam(){
       Calendar instance = Calendar.getInstance();
        int year = instance.get(Calendar.YEAR);
       if(year - this.namSX > 2) return false;
       return true;
       
   }

    @Override
    public int compareTo(PTGT t) {
        if (t.namSX - namSX < 0) {
            return 1;
        }
        return -1;
    }
}
