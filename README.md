# Sistem Manajemen Klub Sepak Bola 

## Deskripsi Singkat Program

Program ini adalah aplikasi berbasis console (command line) yang dibuat menggunakan bahasa pemrograman Java dengan penerapan konsep Pemrograman Berorientasi Objek (PBO). Program ini berfungsi sebagai sistem manajemen sederhana untuk klub sepak bola  , yang dapat digunakan oleh seorang manajer klub untuk mengelola data pemain, data pelatih, serta riwayat pertandingan klub.

Program ini menerapkan beberapa konsep dasar PBO, di antaranya:
- Class dan Object
- Constructor
- Encapsulation (access modifier `private` dan `public`, getter & setter)
- ArrayList untuk menyimpan kumpulan data
- Package untuk pengorganisasian class
- Validasi input pada setiap data yang dimasukkan pengguna

## Struktur Class

| Class | Package | Keterangan |
|---|---|---|
| `Pemain` | `data_klub` | Menyimpan data pemain (nama, posisi, nomor punggung, usia, status kesehatan) |
| `Pelatih` | `data_klub` | Menyimpan data pelatih (nama, spesialisasi, pengalaman) |
| `Pertandingan` | `operasional` | Menyimpan data pertandingan (lawan, tanggal, kompetisi, skor, lokasi) |
| `ManajemenKlub` | `operasional` | Mengelola seluruh data pemain, pelatih, dan pertandingan menggunakan ArrayList |
| `Mini_Project` | `com.mycompany.mini_project` | Class utama (entry point) yang menjalankan program dan menampilkan menu |

## Penjelasan Alur Program

1. **Program dimulai** dengan menampilkan pesan sambutan kepada pengguna yang berperan sebagai manajer klub.

2. **Menu utama ditampilkan** secara berulang menggunakan perulangan `do-while`, sehingga program akan terus berjalan selama pengguna belum memilih menu keluar. Menu yang tersedia adalah:
   - Tambah Pemain
   - Lihat Semua Pemain
   - Hapus Pemain
   - Update Status Pemain
   - Tambah Pertandingan
   - Lihat Riwayat Pertandingan
   - Tambah Pelatih
   - Lihat Semua Pelatih
   - Keluar

3. **Pengguna memilih menu** dengan memasukkan angka melalui keyboard (`Scanner`). Program akan memvalidasi input agar hanya menerima angka; jika input bukan angka, program akan meminta pengguna memasukkan ulang.

4. **Program memproses pilihan** menggunakan struktur percabangan `if-else`, sesuai dengan menu yang dipilih:
   - Jika memilih **Tambah Pemain/Pelatih/Pertandingan**, program akan meminta pengguna memasukkan data satu per satu, lalu data tersebut disimpan ke dalam `ArrayList` melalui class `ManajemenKlub`.
   - Jika memilih **Lihat Data**, program akan menampilkan seluruh data yang tersimpan menggunakan perulangan (`for-each`).
   - Jika memilih **Hapus/Update Pemain**, program akan mencari data berdasarkan nama yang dimasukkan, lalu menghapus atau memperbarui data tersebut.
   - Setiap data yang dimasukkan akan melalui proses **validasi** (misalnya posisi pemain harus sesuai daftar posisi yang valid, skor tidak boleh bernilai negatif, dan status kesehatan harus sesuai pilihan yang tersedia).

5. **Setelah satu proses menu selesai dijalankan**, program akan kembali menampilkan menu utama (karena berada di dalam perulangan `do-while`), sehingga pengguna dapat memilih menu lain tanpa perlu menjalankan ulang program.

6. **Program akan berhenti** hanya ketika pengguna memilih menu **Keluar (angka 9)**, yang akan menampilkan pesan perpisahan dan menghentikan perulangan `do-while`.

## Cara Menjalankan Program

1. Pastikan struktur folder/package sudah sesuai:
com/mycompany/mini_project/Mini_Project.java
data_klub/Pemain.java
data_klub/Pelatih.java
operasional/Pertandingan.java
operasional/ManajemenKlub.java

2. Compile seluruh file
javac data_klub/.java operasional/.java com/mycompany/mini_project/Mini_Project.java

3. Jalankan program melalui class utama:
java com.mycompany.mini_project.Mini_Project


## Screenshot Program

### 1. Menu Utama
Tampilan awal program saat pertama kali dijalankan.

![Menu Utama](screenshots01-menu-utama.png)

### 2. Tambah Pemain
Proses memasukkan data pemain baru hingga berhasil ditambahkan.

![Tambah Pemain](screenshots02-tambah-pemain.png)

### 3. Lihat Semua Pemain
Menampilkan seluruh data pemain yang sudah tersimpan.

![Lihat Semua Pemain](screenshots03-lihat-pemain.png)

### 4. Update Status Pemain
Proses memperbarui status kesehatan pemain (misalnya dari "Tersedia" menjadi "Cedera").

![Update Status Pemain](screenshots04-update-status.png)

### 5. Hapus Pemain
Proses menghapus data pemain berdasarkan nama.

![Hapus Pemain](screenshots05-hapus-pemain.png)

### 6. Tambah Pertandingan
Proses mencatat pertandingan baru (lawan, tanggal, kompetisi, skor, dan lokasi).

![Tambah Pertandingan](screenshots06-tambah-pertandingan.png)

### 7. Lihat Riwayat Pertandingan
Menampilkan seluruh riwayat pertandingan beserta hasil (Menang/Kalah/Seri) yang dihitung otomatis dari skor.

![Lihat Riwayat Pertandingan](screenshots07-lihat-pertandingan.png)

### 8. Tambah Pelatih
Proses memasukkan data pelatih baru hingga berhasil ditambahkan.

![Tambah Pelatih](screenshots08-tambah-pelatih.png)

### 9. Lihat Semua Pelatih
Menampilkan seluruh data pelatih yang sudah tersimpan.

![Lihat Semua Pelatih](screenshots09-lihat-pelatih.png)

### 10. Validasi Input
Contoh program menolak input yang tidak valid (misalnya huruf saat diminta angka, atau posisi pemain yang tidak dikenali).

![Validasi Input](screenshots10-validasi-input.png)

### 11. Keluar Program
Tampilan saat pengguna memilih menu Keluar dan program berhenti.

![Keluar Program](screenshots11-keluar.png)