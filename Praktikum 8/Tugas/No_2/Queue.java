package Tugas.No_2;

class Queue {
    T2Mahasiswa[] data;
    int front;
    int rear;
    int size;
    int max;

    public Queue(int n){
        max = n;
        data = new T2Mahasiswa[max];
        size = 0;
        front = rear = -1;
    }

    public boolean IsEmpty(){
        if(size == 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean IsFull(){
        if(size == max){
            return true;
        }else{
            return false;
        }
    }

    public void peek(){
        if(!IsEmpty()){
            System.out.println("Mahasiswa Antrian terdepan: " + data[front].nim + " " + data[front].nama + " " + 
            data[front].absen + " " + data[front].ipk);
        }else{
            System.out.println("Queue masih kosong");
        }
    }

    public void print(){
        if(IsEmpty()){
            System.out.println("Queue masih kosong");
        }else{
            int i = front;
            while (i != rear){
                System.out.println(data[i].nim + " " + data[i].nama + " " + data[i].absen + " " +
                data[i].ipk);
                i = (i+1) % max;
            }
            System.out.println(data[i].nim + " " + data[i].nama + " " + data[i].absen + " " +
            data[i].ipk);
            System.out.println("Jumlah Antrian = " + size);
        }
    }

    public void Enqueue(T2Mahasiswa antri){
        if(IsFull()){
            System.out.println("Queue sudah penuh");
        }else{
            if(IsEmpty()){
                front = rear = 0;
            }else{
                if(rear == max - 1){
                    rear = 0;
                }else{
                    rear++;
                }
            }
            data[rear] = antri;
            size++;
        }
    }

    public T2Mahasiswa Dequeue(){
        T2Mahasiswa dt = new T2Mahasiswa();
        if(IsEmpty()){
            System.out.println("Queue masih kosong");
        }else{
            dt = data[front];
            size--;
            if(IsEmpty()){
                front = rear = -1;
            }else{
                if(front == max - 1){
                    front =0;
                }else{
                    front++;
                }
            }
        }
        return dt;
    }

    public void peekRear(){
        if(!IsEmpty()){
            System.out.println("Antrian paling belakang: " + data[rear].nim + " " + data[rear].nama + " " + 
            data[rear].absen + " " + data[rear].ipk);
        }else{
            System.out.println("Queue masih kosong");
        }
    }
    
    public int peekPosition(String nim){
        int posisi = -1;
        if(!IsEmpty()){
            for(int j=0; j<data.length; j++){
                if(nim.equalsIgnoreCase(data[j].nim)){
                    posisi = j;
                    break;
                }
            }
        }else{
            System.out.println("Queue masih kosong");
        }
        return posisi;
    }
    
    public void printMahasiswa(int posisi){
        if(!IsEmpty()){
            System.out.println("                             DATA MAHASISWA                          ");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("NIM\t: " + data[posisi-1].nim);
            System.out.println("Nama\t: " + data[posisi-1].nama);
            System.out.println("Absen\t: " + data[posisi-1].absen);
            System.out.println("IPK\t: " + data[posisi-1].ipk);
        }else{
            System.out.println("Queue masih kosong");
        }
    }
}