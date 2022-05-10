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
public class QLBH implements Serializable {

    private int maNV;
    private int maDV, soLuong;

    public QLBH() {
    }

    public QLBH(int maNV, int maDV, String soLuong) throws TrongException {
        if (soLuong.isEmpty() || soLuong.isEmpty()) {
            throw new TrongException();
        }
        this.maNV = maNV;
        this.maDV = maDV;
        this.soLuong = Integer.parseInt(soLuong);
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public int getMaDV() {
        return maDV;
    }

    public void setMaDV(int maDV) {
        this.maDV = maDV;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Object[] toObject() {
        return new Object[]{
            maNV, maDV, soLuong
        };
    }
}
