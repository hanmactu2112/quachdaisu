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
public class OTo extends PTGT implements TinhGia{
    private int soCho;

    public OTo() {
    }

    public OTo(int soCho) {
        this.soCho = soCho;
    }

    public OTo( String soKhungXe, int namSX, double giaBan, String mau, int soCho) {
        super(soKhungXe, namSX, giaBan, mau);
        this.soCho = soCho;
    }
    

    public int getSoCho() {
        return soCho;
    }

    public void setSoCho(int soCho) {
        this.soCho = soCho;
    }

    
    
    @Override
    public double getGia() {
        if(checkNam()) return super.getGiaBan()*0.7;
        return getGiaBan();
    }

    @Override
    public String toString() {
        return super.getSoKhungXe()+"\t"+super.getNamSX()+ "\t"+getGia()+ "\t"+super.getMau()+"\t"+soCho;
    }
    
    
}
