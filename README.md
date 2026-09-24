# Sistem Manajemen Klub Sepak Bola 

## Deskripsi Singkat Program

Program ini adalah aplikasi berbasis console (command line) yang dibuat menggunakan bahasa pemrograman Java dengan penerapan konsep Pemrograman Berorientasi Objek (PBO). Program ini berfungsi sebagai sistem manajemen sederhana untuk klub sepak bola, yang dapat digunakan oleh seorang manajer klub untuk mengelola data pemain, data pelatih, serta riwayat pertandingan klub.

Program ini dibangun dengan menerapkan beberapa konsep dasar PBO secara menyeluruh, di antaranya:
- Class dan Object
- Constructor
- Encapsulation (access modifier `private` dan `public`, getter & setter)
- Inheritance (pewarisan)
- Polymorphism (method overriding)
- ArrayList untuk menyimpan kumpulan data
- Struktur MVC (Model-View-Controller) untuk pengorganisasian package
- Validasi input pada setiap data yang dimasukkan pengguna

## Struktur Package

| Package | Isi | Peran |
|---|---|---|
| `model` | `AnggotaKlub`, `Pemain`, `Pelatih`, `Pertandingan` | Menyimpan data dan aturan validasi |
| `view` | `TampilanView` | Menampilkan data dan menu ke layar |
| `controller` | `ManajemenKlub` | Mengelola logika CRUD dan menghubungkan Model dengan View |
| `com.mycompany.miniproject` | `Main` | Entry point program, menangani input pengguna |

## Penjelasan Alur Program

1. **Program dimulai** dengan menampilkan pesan sambutan kepada pengguna yang berperan sebagai manajer klub. Program juga sudah diisi dengan dummy data di awal, sehingga fitur dapat langsung dicoba tanpa harus input manual dari awal.

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

4. **Program memproses pilihan** menggunakan struktur percabangan `switch-case`, sesuai dengan menu yang dipilih:
   - Jika memilih **Tambah Pemain/Pelatih/Pertandingan**, program akan meminta pengguna memasukkan data satu per satu, lalu data tersebut disimpan ke dalam `ArrayList` melalui `Controller`.
   - Jika memilih **Lihat Data**, `Controller` akan meminta `View` menampilkan seluruh data yang tersimpan menggunakan perulangan (`for-each`).
   - Jika memilih **Hapus/Update Pemain**, `Controller` akan mencari data berdasarkan nama yang dimasukkan, lalu menghapus atau memperbarui data tersebut. Program akan menampilkan pesan yang sesuai tergantung apakah data ditemukan atau tidak.
   - Setiap data yang dimasukkan akan melalui proses **validasi** (misalnya posisi pemain harus sesuai daftar posisi yang valid, skor tidak boleh bernilai negatif, dan status kesehatan harus sesuai pilihan yang tersedia).

5. **Setelah satu proses menu selesai dijalankan**, program akan kembali menampilkan menu utama (karena berada di dalam perulangan `do-while`), sehingga pengguna dapat memilih menu lain tanpa perlu menjalankan ulang program.

6. **Program akan berhenti** hanya ketika pengguna memilih menu **Keluar (angka 9)**, yang akan menampilkan pesan perpisahan dan menghentikan perulangan `do-while`.

## Penerapan Encapsulation

Encapsulation diterapkan pada seluruh class di package `model` (`AnggotaKlub`, `Pemain`, `Pelatih`, `Pertandingan`), dengan cara:

- Seluruh atribut dideklarasikan dengan access modifier **`private`**, sehingga tidak bisa diakses secara langsung dari luar class.
- Akses terhadap atribut tersebut hanya bisa dilakukan melalui method **getter** (untuk membaca nilai) dan **setter** (untuk mengubah nilai).
- Setiap method setter dilengkapi dengan **validasi**, sehingga data yang masuk ke dalam atribut selalu terjamin valid. Contohnya:
  - `setPosisi()` pada class `Pemain` hanya menerima posisi yang sesuai daftar (GK, CB, LB, RB, CDM, CM, CAM, LW, RW, ST); jika tidak sesuai, nilai akan otomatis diset ke default.
  - `setSkorKlub()` dan `setSkorLawan()` pada class `Pertandingan` tidak mengizinkan nilai negatif.
  - `setStatusKesehatan()` pada class `Pemain` hanya menerima status "Tersedia" atau "Cedera".

Dengan encapsulation ini, integritas data selalu terjaga karena tidak ada cara untuk mengisi atribut dengan nilai sembarang dari luar class.

## Penerapan Inheritance

Inheritance diterapkan antara class `AnggotaKlub` sebagai **superclass (parent class)**, dengan `Pemain` dan `Pelatih` sebagai **subclass (child class)**.

AnggotaKlub (superclass)
├── atribut: nama
│
├── Pemain extends AnggotaKlub
│ └── tambahan atribut: posisi, nomorPunggung, usia, statusKesehatan
│
└── Pelatih extends AnggotaKlub
└── tambahan atribut: spesialisasi, pengalaman


Alasan penerapan inheritance ini adalah karena `Pemain` dan `Pelatih` sama-sama merupakan **anggota klub** yang memiliki kesamaan atribut, yaitu `nama`. Daripada menulis atribut dan method `nama` secara berulang di kedua class, atribut tersebut cukup didefinisikan satu kali di `AnggotaKlub`, lalu diwariskan ke `Pemain` dan `Pelatih` menggunakan kata kunci `extends`. Pada constructor masing-masing subclass, digunakan `super(nama)` untuk memanggil constructor dari `AnggotaKlub`.

## Penerapan Struktur MVC

Program ini menerapkan struktur **Model-View-Controller (MVC)** dengan pembagian tanggung jawab sebagai berikut:

- **Model** (`model.AnggotaKlub`, `model.Pemain`, `model.Pelatih`, `model.Pertandingan`)
  Berfungsi untuk mengelola data, yang meliputi atribut, constructor, getter, setter, serta validasi data. Model berfokus pada pengelolaan dan representasi data dalam program.

- **View** (`view.TampilanView`)
  Bertanggung jawab untuk mengatur tampilan yang ditampilkan kepada pengguna, seperti menu, pesan, serta detail data pemain, pelatih, dan pertandingan. Bagian ini berfokus pada kebutuhan antarmuka dan tampilan program.

- **Controller** (`controller.ManajemenKlub`)
  Berfungsi sebagai penghubung antara Model dan View. Controller menyimpan dan mengelola data dalam bentuk ArrayList, menjalankan proses CRUD (Create, Read, Update, Delete), serta mengatur proses ketika data perlu ditampilkan melalui TampilanView.

- **Main** (`com.mycompany.miniproject.Main`)
  Berperan sebagai entry point program. Class ini menangani proses awal program dan membaca input dari pengguna menggunakan Scanner, kemudian meneruskan perintah yang diberikan kepada Controller.

Dengan struktur ini, perubahan pada satu lapisan (misalnya perubahan format tampilan di `View`) tidak akan memengaruhi lapisan lain (`Model` dan `Controller`), sehingga program menjadi lebih mudah dipelihara dan dikembangkan.

## Penerapan Polymorphism

Polymorphism diterapkan melalui **method overriding** pada method `getInfo()`.

- Method `getInfo()` pertama kali didefinisikan di superclass `AnggotaKlub`, mengembalikan informasi dasar berupa nama.
- Method ini kemudian di-**override** (ditandai dengan anotasi `@Override`) baik di class `Pemain` maupun `Pelatih`, masing-masing menambahkan informasi khusus miliknya sendiri (posisi, status kesehatan untuk `Pemain`; spesialisasi, pengalaman untuk `Pelatih`).

Pemanfaatan polymorphism ini terlihat jelas pada class TampilanView, yang cukup memanfaatkan satu method untuk menampilkan informasi anggota klub:

```java
public void tampilkanInfo(AnggotaKlub a) {
    System.out.println(a.getInfo());
    System.out.println("------------------------------");
}
```

Method ini dipanggil baik untuk objek Pemain maupun objek Pelatih. Meskipun kedua objek tersebut dilewatkan ke method yang sama persis (tampilkanInfo()), hasil keluarannya berbeda, karena Java secara otomatis menjalankan versi getInfo() sesuai dengan tipe objek yang sebenarnya pada saat program berjalan. Inilah inti dari pemanfaatan polymorphism: satu method penerima, banyak bentuk perilaku, tergantung objek yang dilewatkan kepadanya.

## Cara Menjalankan Program

1. Pastikan struktur folder/package sudah sesuai:

model/AnggotaKlub.java
model/Pemain.java
model/Pelatih.java
model/Pertandingan.java
view/TampilanView.java
controller/ManajemenKlub.java
com/mycompany/miniproject/Main.java

2. Compile seluruh file:

javac model/.java view/.java controller/*.java com/mycompany/miniproject/Main.java

3. Jalankan program melalui class utama:

java com.mycompany.miniproject.Main

## Screenshots Program

Berikut adalah dokumentasi visual antarmuka dan keluaran program saat dijalankan di terminal/console:

### 1. Tampilan Sambutan & Menu Utama
> Menampilkan menu pilihan sistem manajemen klub saat pertama kali program dijalankan.

![Tampilan Menu Utama](https://github.com/kennygiovanni/Minpro-2-PBO-ManajemenKlubSepakBola/blob/master/screenshots/screenshots01-menu-utama.png) 

---

### 2. Fitur Manajemen Pemain
#### A. Tambah Data Pemain 
> Proses menginput data pemain baru beserta pengujian input validasi angka/posisi.

![Tambah Pemain](screenshots/screenshots/02-tambah-pemain.png)

#### B. Lihat Daftar Pemain
> Output daftar seluruh pemain yang tersimpan di sistem, memanfaatkan method `tampilkanInfo()`.

![Lihat Daftar Pemain](screenshots/screenshots/03-lihat-pemain.png)

#### C. Update Status Pemain
> Proses penghapusan data pemain dari sistem berdasarkan nama yang diinputkan pengguna.

![Hapus Pemain](screenshots/screenshots/04-hapus-pemain.png)

#### D. Hapus Pemain
> Pembaruan status kesehatan pemain (Tersedia/Cedera) berdasarkan nama pemain yang dicari.

![Update Status Pemain](screenshots/screenshots/05-update-status-pemain.png)

---

### 3. Fitur Manajemen Pertandingan
#### A. Tambah Pertandingan
> Mengisi riwayat pertandingan baru meliputi tim lawan, tanggal, skor, dan lokasi pertandingan.

![Tambah Pertandingan](screenshots/screenshots/06-tambah-pertandingan.png)

#### B. Lihat Riwayat Pertandingan
> Menampilkan riwayat seluruh pertandingan yang telah ditambahkan.

![Lihat Riwayat Pertandingan](screenshots/screenshots/07-lihat-pertandingan.png)

---

### 4. Fitur Manajemen Pelatih
#### A. Tambah Pelatih
> Menginput data pelatih baru beserta spesialisasi dan pengalaman melatih.

![Tambah Pelatih](screenshots/screenshots/08-tambah-pelatih.png)

#### B. Lihat Daftar Pelatih
> Menampilkan daftar pelatih yang ada di dalam klub.

![Lihat Daftar Pelatih](screenshots/screenshots/09-lihat-pelatih.png)

---

### 5. Keluar dari Program
> Pesan konfirmasi penutupan program ketika pengguna memilih menu angka 9.

![Keluar Program](screenshots/screenshots/10-keluar.png)
