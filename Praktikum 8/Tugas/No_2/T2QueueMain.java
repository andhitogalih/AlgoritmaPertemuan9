package Tugas.No_2;

import java.util.Scanner;

class T2QueueMain{
    public static void menu(){
        System.out.println("\nPilihan menu: ");
        System.out.println("1. Antrian baru");
        System.out.println("2. Antrian keluar");
        System.out.println("3. Cek Antrian terdepan");
        System.out.println("4. Cek Semua Antrian");
        System.out.println("5. Cek Antrian Paling Belakang");
        System.out.println("6. Cek Antrian Mahasiswa");
        System.out.println("7. Cetak Data Mahasiswa");
        System.out.println("8. Exit");
        System.out.println("---------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan kapasitas queue: ");
        int jumlah = sc.nextInt();
        Queue antri = new Queue(jumlah);

        int pilih;
        do{
            menu();
            pilih = sc.nextInt();
            sc.nextLine();
            switch(pilih){
                case 1:
                    System.out.print("NIM: ");
                    String nim = sc.nextLine();
                    System.out.print("Nama: ");
                    String nama = sc.nextLine();
                    System.out.print("Absen: ");
                    int absen = sc.nextInt();
                    System.out.print("IPK: ");
                    double ipk = sc.nextDouble();
                    T2Mahasiswa nb = new T2Mahasiswa(nim, nama, absen, ipk);
                    sc.nextLine();
                    antri.Enqueue(nb);
                    break;
                case 2:
                    T2Mahasiswa data = antri.Dequeue();
                    if(!"".equals(data.nim) && !"".equals(data.nama)
                    && data.absen !=0 && data.ipk !=0){
                        System.out.println("Antrian yang keluar: " + data.nim + " " + data.nama + " " 
                        + data.absen + " " + data.ipk);
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
                case 6:
                    System.out.print("NIM : ");
                    String cari = sc.nextLine();
                    int posisi = antri.peekPosition(cari);
                    if(posisi != -1){
                        System.out.println("Mahasiswa dengan NIM " +cari + " mendapatkan posisi antrian ke-"+(posisi+1));
                    }else{
                        System.out.println("NIM tidak ditemukan!");
                    }
                    break;
                case 7:
                    System.out.print("Masukkan Nomor Antrian: ");
                    int noAntrian = sc.nextInt();
                    antri.printMahasiswa(noAntrian);
                    break;
                case 8:
                    System.out.println("TERIMA KASIH....");
                    System.exit(0);
                    break;
            }
        } while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4 || pilih == 5 || 
                 pilih == 6 || pilih == 7 || pilih == 8);
    }
}