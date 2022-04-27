package Tugas.No_1;
import java.util.Scanner;
class T1QueueMain{
    public static void menu(){
        System.out.println("Masukkan operasi yang diinginkan:");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Print");
        System.out.println("4. Peek");
        System.out.println("5. Peek Position");
        System.out.println("6. Peek At");
        System.out.println("7. Clear");
        System.out.println("8. Exit");
        System.out.println("----------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan kapasitas queue: ");
        int n = sc.nextInt();

        Queue Q = new Queue(n);
        int pilih;
        do{
            menu();
            pilih = sc.nextInt();
            switch(pilih){
                case 1:
                    System.out.print("Masukkan data baru: ");
                    int dataMasuk = sc.nextInt();
                    Q.Enqueue(dataMasuk);
                    break;
                case 2:
                    int dataKeluar = Q.Dequeue();
                    if(dataKeluar != 0){
                        System.out.println("Data yang dikeluarkan: "+ dataKeluar);
                        break;
                    }
                case 3:
                    Q.print();
                    break;
                case 4:
                    Q.peek();
                    break;
                case 5:
                    System.out.print("Masukkan data: ");
                    int cari = sc.nextInt();
                    int posisi = Q.peekPosition(cari);
                    if(posisi != -1){
                        System.out.println("Data " +cari + " berada di posisi urutan ke-"+(posisi+1));
                    }else{
                        System.out.println("Data tidak ditemukan!");
                    }
                    break;
                case 6:
                    System.out.print("Masukkan urutan data: ");
                    int dataCari = sc.nextInt();
                    Q.peekAt(dataCari);
                    break;
                case 7:
                    Q.clear();
                    break;
                case 8:
                System.out.println("TERIMA KASIH......");
                    System.exit(0);
                    break;
            }
        }while(pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4 || pilih == 5 ||
               pilih == 6 || pilih == 7 || pilih == 8);
    }
}
