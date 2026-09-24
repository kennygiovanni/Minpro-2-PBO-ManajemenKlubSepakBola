package com.mycompany.miniproject;

import java.util.Scanner;
import model.Pemain;
import model.Pelatih;
import model.Pertandingan;
import controller.ManajemenKlub;
import view.TampilanView;

public class Main {

    public static void main(String[] args) {
        
      Scanner scanner = new Scanner (System.in);
      ManajemenKlub klub = new ManajemenKlub();
      TampilanView menuView = new TampilanView();
      int pilihan;
        
      menuView.tampilkanSambutan();
        
      do {
        menuView.tampilkanMenu();
        System.out.print("Pilih Menu: ");  
        
        while (!scanner.hasNextInt()) {
            menuView.tampilkanPesan("Pilihan tidak valid, harus berupa angka (1-9).");
            scanner.next();
            System.out.print("Pilih Menu: ");
        }
        pilihan = scanner.nextInt();
        scanner.nextLine();
        
        switch (pilihan){
            case 1:
                System.out.print("Nama Pemain: ");
                String namaPemain = scanner.nextLine();

                System.out.print("Posisi (GK/CB/LB/RB/CDM/CM/CAM/LW/RW/ST): ");
                String posisi = scanner.nextLine();

                System.out.print("Nomor Punggung (1-99): ");
                while (!scanner.hasNextInt()) {
                    menuView.tampilkanPesan("Pilihan tidak valid, harus berupa angka (1-99).");
                    scanner.next();
                }
                int nomor = scanner.nextInt();
            
                System.out.print("Usia: ");
                while (!scanner.hasNextInt()) {
                    menuView.tampilkanPesan("Pilihan tidak valid, harus berupa angka.");
                    scanner.next();
                }
                int usia = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Status Kesehatan (Tersedia/Cedera): ");
                String status = scanner.nextLine();

                Pemain pemainBaru = new Pemain(namaPemain, posisi, nomor, usia, status);
                klub.tambahPemain(pemainBaru);
                menuView.tampilkanPesan("Pemain Berhasil Ditambahkan");
                break;
        
            case 2:
                klub.tampilkanSemuaPemain();
                menuView.tampilkanPesan("Tekan Enter untuk kembali ke menu.");
                scanner.nextLine();
                break;

            case 3:
                System.out.print("Masukkan Nama Pemain: ");
                String namaHapus = scanner.nextLine();
                boolean berhasilHapus = klub.hapusPemain(namaHapus);
                if (berhasilHapus) {
                    menuView.tampilkanPesan("Pemain Sudah Dihapus.");
                }
                else {
                    menuView.tampilkanPesan("Pemain dengan nama tersebut tidak ada.");
                }
                break;

            case 4:
                System.out.print("Masukkan Nama Pemain: ");
                String namaUpdate = scanner.nextLine();
                System.out.print("Status Kesehatan Baru (Tersedia/Cedera): ");
                String statusBaru = scanner.nextLine();
                boolean berhasilUpdate = klub.updateStatusPemain(namaUpdate, statusBaru);
                if (berhasilUpdate) {
                    menuView.tampilkanPesan("Update Status Pemain Berhasil");
                } 
                else {
                    menuView.tampilkanPesan("Pemain dengan nama tersebut tidak ditemukan.");
                }
                break;

            case 5:
                System.out.print("Masukkan Nama Tim Lawan: ");
                String lawan = scanner.nextLine();

                System.out.print("Tanggal (dd-mm-yy): ");
                String tanggal = scanner.nextLine();

                System.out.print("Kompetisi: ");
                String kompetisi = scanner.nextLine();

                System.out.print("Skor Klub Kita: ");
                while (!scanner.hasNextInt()) {
                    menuView.tampilkanPesan("Pilihan tidak valid, harus berupa angka.");
                    scanner.next();
                }
                int skorKlub = scanner.nextInt();

                System.out.print("Skor Klub Lawan: ");
                while (!scanner.hasNextInt()) {
                    menuView.tampilkanPesan("Pilihan tidak valid, harus berupa angka.");
                    scanner.next();
                }
                int skorLawan = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Lokasi (Kandang/Tandang): ");
                String lokasi = scanner.nextLine();

                Pertandingan p = new Pertandingan(lawan, tanggal, kompetisi, skorKlub, skorLawan, lokasi);

                klub.tambahPertandingan(p);
                menuView.tampilkanPesan("Pertandingan Berhasil Ditambahkan ");
                break;

            case 6:
                klub.tampilkanRiwayatPertandingan();
                menuView.tampilkanPesan("Tekan Enter untuk kembali ke menu.");
                scanner.nextLine();
                break;

            case 7:
                System.out.print("Nama Pelatih: ");
                String namaPelatih = scanner.nextLine();

                System.out.print("Spesialisasi: ");
                String spesialisasi = scanner.nextLine();

                System.out.print("Pengalaman (tahun): ");
                while (!scanner.hasNextInt()) {
                    menuView.tampilkanPesan("Pilihan tidak valid, harus berupa angka.");
                    scanner.next();
                }
                int pengalaman = scanner.nextInt();
                scanner.nextLine();

                Pelatih pelatihBaru = new Pelatih(namaPelatih, spesialisasi, pengalaman);
                klub.tambahPelatih(pelatihBaru);
                menuView.tampilkanPesan("Pelatih Berhasil Ditambahkan");
                break;

            case 8:
                klub.tampilkanSemuaPelatih();
                menuView.tampilkanPesan("Tekan Enter untuk kembali ke menu.");
                scanner.nextLine();
                break;

            case 9:
                menuView.tampilkanPesan("Sampai Jumpa");
                break;

            default:
                menuView.tampilkanPesan("Pilihan tidak valid, harus berupa angka (1-9).");
        }
      } 
           while (pilihan != 9);

         scanner.close();
    }
}