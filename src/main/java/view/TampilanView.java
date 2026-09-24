package view;

import java.util.ArrayList;
import model.AnggotaKlub;
import model.Pemain;
import model.Pelatih;
import model.Pertandingan;

public class TampilanView {
    
    //=== MENU DAN PESAN AWAL ===
    public void tampilkanSambutan() {
        System.out.println("=== SISTEM MANAJEMEN KLUB SEPAK BOLA");
        System.out.println("Selamat Datang, Manajer");
    }
    
    public void tampilkanMenu() {
        System.out.println("=== MENU ===");
        System.out.println("1. Tambah Pemain");
        System.out.println("2. Lihat Semua Pemain");
        System.out.println("3. Hapus Pemain");
        System.out.println("4. Update Status Pemain");
        System.out.println("5. Tambah Pertandingan");
        System.out.println("6. Lihat Riwayat Pertandingan");
        System.out.println("7. Tambah Pelatih");
        System.out.println("8. Lihat Semua Pelatih");
        System.out.println("9. Keluar");
    }
    
    public void tampilkanPesan(String pesan) {
        System.out.println(pesan);
    }
    
    public void tampilkanInfo(AnggotaKlub a) {
        System.out.println(a.getInfo());
        System.out.println("--------------------------------");
    }
    
    public void tampilkanDaftarPemain(ArrayList<Pemain> daftarPemain) {
        if (daftarPemain.isEmpty()) {
            System.out.println("Belum ada data pemain");
            return;
        }
        System.out.println("=== DAFTAR PEMAIN ===");
        for (Pemain p : daftarPemain) {
            tampilkanInfo(p);
        }
    }
    
    public void tampilkanDaftarPelatih(ArrayList<Pelatih> daftarPelatih) {
        if (daftarPelatih.isEmpty()) {
            System.out.println("Belum ada data pelatih");
            return;
        }
        System.out.println("=== DAFTAR PELATIH ===");
        for (Pelatih p : daftarPelatih) {
            tampilkanInfo(p);
        }
    }
    
    public void tampilkanSatuPertandingan(Pertandingan p) {
        System.out.println("Lawan     : " + p.getLawan());
        System.out.println("Tanggal   : " + p.getTanggal());
        System.out.println("Kompetisi : " + p.getKompetisi());
        System.out.println("Skor      : " + p.getSkorKlub() + " - " + p.getSkorLawan());
        System.out.println("Lokasi    : " + p.getLokasi());
        System.out.println("Hasil     : " + p.getHasil());
        System.out.println("--------------------------------------");
    }
    
    public void tampilkanDaftarPertandingan(ArrayList<Pertandingan> daftarPertandingan) {
        if (daftarPertandingan.isEmpty()) {
            System.out.println("Belum ada data pertandingan");
            return;
        }
        System.out.println("=== RIWAYAR PERTANDINGAN ===");
        for (Pertandingan p : daftarPertandingan) {
            tampilkanSatuPertandingan(p);
        }
    }
}
