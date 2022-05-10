/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptgt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 *
 * @author quach
 */
public class QLGTPT implements ChucNang {

    private ArrayList<PTGT> list;
    private Scanner in = new Scanner(System.in);

    public QLGTPT() {
        list = new ArrayList<>();
        list.add(new OTo("A111111111", 2018, 1300, "Xanh", 4));
        list.add(new OTo("A111111114", 2018, 3000, "Xanh", 4));
        list.add(new OTo("A111111115", 2018, 6000, "Xanh", 4));
        list.add(new OTo("A111111117", 2021, 1600, "Do", 4));
        list.add(new OTo("A111111112", 2021, 2200, "Do", 4));
        list.add(new OTo("A111111118", 2015, 1700, "Tim", 4));
        list.add(new OTo("A111111113", 2015, 3600, "Tim", 4));
        list.add(new XeMay("A111111121", 2020, 300, "Xanh", 150));
        list.add(new XeMay("A111111122", 2020, 350, "Xanh", 150));
        list.add(new XeMay("A111111123", 2022, 200, "den", 110));
        list.add(new XeMay("A111111124", 2022, 460, "den", 110));
        list.add(new XeMay("A111111125", 2018, 700, "trang", 100));
        list.add(new XeMay("A111111126", 2018, 900, "trang", 100));
    }

    private int tontai(String ma) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getSoKhungXe().equalsIgnoreCase(ma)) {
                return i;
            }
        }
        return -1;
    }

    private PTGT nhap() {
        String soKhungXe;
        int namSX;
        double giaBan;
        String mau;
        String reg = "^[a-zA-Z0-9]{10}$";
        while (true) {
            System.out.println("Nhap so khung xe:");
            soKhungXe = in.nextLine();
            if (tontai(soKhungXe) == -1 && soKhungXe.matches(reg)) {
                break;
            }
            System.err.println(" Nhap lai!");
        }
        System.out.println("Nhap nam san xuat: ");
        namSX = Integer.parseInt(in.nextLine());
        System.out.println("Nhap gia ban: ");
        giaBan = Double.parseDouble(in.nextLine());
        System.out.println("Nhap mau: ");
        mau = in.nextLine();
        return new PTGT(soKhungXe, namSX, giaBan, mau);
    }

    @Override
    public void nhapOTo() {
        PTGT p = nhap();
        System.out.println("Nhap so cho: ");
        int sc = Integer.parseInt(in.nextLine());
        list.add(new OTo(p.getSoKhungXe(), p.getNamSX(), p.getGiaBan(), p.getMau(), sc));
    }

    @Override
    public void nhapXeMay() {
        PTGT p = nhap();
        System.out.println("Nhap cong suat: ");
        int cs = Integer.parseInt(in.nextLine());
        list.add(new XeMay(p.getSoKhungXe(), p.getNamSX(), p.getGiaBan(), p.getMau(), cs));
    }

    @Override
    public void in() {
        System.out.println("Danh sach oto");
        int ts = 0;
        for (PTGT i : list) {
            if (i instanceof OTo) {
                System.out.println(i);
                ts++;
            }

        }
        System.out.println("Tong so oto " + ts);

        System.out.println("---------------------");
        System.out.println("Danh sach xe may");
        for (PTGT i : list) {
            if (i instanceof XeMay) {
                System.out.println(i);
            }

        }
        ts = list.size() - ts;
        System.out.println("Tong so xe may " + ts);
        System.out.println("---------------------");
    }

    @Override
    public void sua() {
        System.out.println("Nhap so khung xe can sua: ");
        String ma = in.nextLine();
        int vitri = tontai(ma);
        if (vitri == -1) {
            System.out.println("Khong tim thay ma can sua");
        } else {
            PTGT p = list.get(vitri);
            System.out.println("Nhap so khung xe: ");
            String soKhungXe = in.nextLine();
            System.out.println("Nhap  nam san xuat: ");
            int namsx = Integer.parseInt(in.nextLine());
            System.out.println("Nhap gia ban: ");
            double giaban = Double.parseDouble(in.nextLine());
            System.out.println("Nhap mau: ");
            String mau = in.nextLine();
            p.setSoKhungXe(soKhungXe);
            p.setNamSX(namsx);
            p.setGiaBan(giaban);
            p.setMau(mau);
            if (p instanceof OTo) {
                System.out.println("Nhap so cho: ");
                int socho = Integer.parseInt(in.nextLine());
                ((OTo) p).setSoCho(socho);
            } else {
                System.out.println("Nhap cong suat: ");
                double congsuat = Double.parseDouble(in.nextLine());
                ((XeMay) p).setCongSuat(congsuat);
            }
        }
    }

    @Override
    public void sapxep() {
        Collections.sort(list);
    }

    @Override
    public void datDo() {
        
        Map<String,PTGT> o = list.stream().collect(Collectors.groupingBy(PTGT::getMau,Collectors.collectingAndThen(Collectors.reducing((PTGT p1,PTGT p2)->p1.getGiaBan()>p2.getGiaBan()?p1:p2),Optional::get)));
        Iterator i=o.keySet().iterator();
        while (i.hasNext()) {            
            String key = (String)i.next();
            PTGT value = o.get(key);
            System.out.println(key);
            System.out.println(value);
        }
    }

    @Override
    public void timkiem() {
        System.out.println("Nhap ma can tim");
        String ma = in.nextLine();
        if (tontai(ma)!=-1) {
            int vitri = tontai(ma);
            System.out.println(list.get(vitri));
        }
        else System.out.println("Khong co ma");
    }

    @Override
    public void xoa() {
        System.out.println("Nhap ma xe can xoa");
        String ma = in.nextLine();
        int vitri = tontai(ma);
        if (vitri==-1) {
            System.out.println("Khong co ma can xoa");
        }
        else {
            list.remove(vitri);
            System.out.println("Xoa thanh cong");
        }
        
    }

    @Override
    public void timtheomau() {
        System.out.println("Nhap nam can tim");
        String mau = in.nextLine();
        boolean co = false;
//        for (int i = 0; i < list.size(); i++) {
//            
//            int nam1=(int) list.get(i).getNamSX();
//            if (nam1==nam) {
//                System.out.println(list.get(i));
//                co = true;
//            }
//           
//        }
        for (PTGT i : list) {
            if(i.getMau().toLowerCase().equalsIgnoreCase(mau)){
                System.out.println(i);
                co = true;
            }
        }
         if (!co) {
                System.out.println("Khong tim thay");
            }
    }

    @Override
    public void demtheomau() {
        Map<String,Long> count = list.stream().collect(Collectors.groupingBy(PTGT:: getMau,Collectors.counting()));
        System.out.println(count);
    }
    

    @Override
    public void tongtheonam() {
        Map<Integer,Double> count = list.stream().collect(Collectors.groupingBy(PTGT::getNamSX,Collectors.summingDouble(PTGT::getGiaBan)));
        System.out.println(count);
        
    }

    @Override
    public void maxtheogia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
