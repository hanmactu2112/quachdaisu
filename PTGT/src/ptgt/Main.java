/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptgt;

import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author quach
 */
public class Main {
    public static void main(String[] args) {
        QLGTPT q = new QLGTPT();
        while (true) {            
            System.out.println("-----MENU-----");
            System.out.println("1. Nhap oto");
            System.out.println("2. Nhap xe may");
            System.out.println("3. In ra danh sach");
            System.out.println("4. Sua");
            System.out.println("5. Sap xep");
            System.out.println("6. Dua ra phuong tien dat do");
            System.out.println("7. Tim kiem");
            System.out.println("8. xoa");
            System.out.println("9. Tim theo mau");
            System.out.println("10. dem theo mau");
            System.out.println("11. tong theo nam");
            System.out.println("0. Thoat");
            
            int chon;
            Scanner in = new Scanner(System.in);
            chon = Integer.parseInt(in.nextLine());
           switch(chon){
               case 0: System.out.println("Bye!!");
                        System.exit(0);
               case 1: q.nhapOTo();
                        break;
               case 2: q.nhapXeMay();
                        break;
               case 3: q.in();
                        break;
               case 4: q.sua();
                        break;         
               case 5: q.sapxep();
                        break;
               case 6: q.datDo();
                        break;     
               case 7: q.timkiem();
                        break;
               case 8: q.xoa();
               break;
               case 9: q.timtheomau();
               break;
                case 10: q.demtheomau();
               break;
                case 11: q.tongtheonam();
               break;
           }
        }
    }
}
