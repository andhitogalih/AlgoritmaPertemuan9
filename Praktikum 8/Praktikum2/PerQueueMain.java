package Praktikum2;

import java.util.Scanner;

public class PerQueueMain {
        public static void menu(){
            System.out.println("Pilihan menu: ");
            System.out.println("1. Antrian baru");
            System.out.println("2. Antrian keluar");
            System.out.println("3. Cek Antrian terdepan");
            System.out.println("4. Cek Semua Antrian");
            System.out.println("5. Cek Antrian Paling Belakang");
            System.out.println("---------------------------");
        }
    
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Masukkan kapasitas queue: ");
            int jumlah = sc.nextInt();
            PerQueue antri = new PerQueue(jumlah);
    
            int pilih;
            do{
                menu();
                pilih = sc.nextInt();
                sc.nextLine();
                switch(pilih){
                    case 1:
                        System.out.print("No Rekening: ");
                        String norek = sc.nextLine();
                        System.out.print("Nama: ");
                        String nama = sc.nextLine();
                        System.out.print("Alamat: ");
                        String alamat = sc.nextLine();
                        System.out.print("Umur: ");
                        int umur = sc.nextInt();
                        System.out.print("Saldo: ");
                        double saldo = sc.nextDouble();
                        PerNasabah nb = new PerNasabah(norek, nama, alamat, umur, saldo);
                        sc.nextLine();
                        antri.Enqueue(nb);
                        break;
                    case 2:
                        PerNasabah data = antri.Dequeue();
                        if(!"".equals(data.norek) && !"".equals(data.nama) && !"".equals(data.alamat)
                        && data.umur !=0 && data.saldo !=0){
                            System.out.println("Antrian yang keluar: " + data.norek + " " + data.nama + " " + 
                            data.alamat + " " + data.umur + " " + data.saldo);
                            break;
                        }
                    case 3:
                        antri.peek();
                        break;
                    case 4:
                        antri.print();
                        break;
                    case 5:
                        antri.peekRear();
                        break;
                }
            } while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4 || pilih == 5);
        }
    }

