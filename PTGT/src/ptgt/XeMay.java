/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptgt;

/**
 *
 * @author quach
 */
public class XeMay extends PTGT implements TinhGia{
    private double congSuat;

    public XeMay() {
    }

    public XeMay( String soKhungXe, int namSX, double giaBan, String mau,double congSuat) {
        super(soKhungXe, namSX, giaBan, mau);
        this.congSuat = congSuat;
    }
    

    public double getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(double congSuat) {
        this.congSuat = congSuat;
    }
    
    
    @Override
    public double getGia() {
        if(this.checkNam()) return this.getGiaBan() * 0.9;
        else return this.getGiaBan();
    }

  @Override
    public String toString() {
        return super.getSoKhungXe()+"\t"+super.getNamSX()+ "\t"+getGia()+ "\t"+super.getMau()+"\t"+congSuat;
    }
    
}
