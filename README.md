# Tugas Praktikum 4 - Desain dan Pemrograman Berorientasi Objek 2026

## Janji
Saya Zufar Ahmad Maulidy dengan NIM 2400285 mengerjakan Tugas Praktikum 4 dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk keberkahan-Nya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.


TP3 - PeopleData Management

Aplikasi GUI berbasis Java Swing untuk mengelola data orang (CRUD) dengan menerapkan prinsip Object-Oriented Programming (OOP).

Desain Program

Aplikasi ini memisahkan representasi data (Model) dan antarmuka visual beserta kontrol logikanya (View & Controller):

A. Class Person (Data Model)
Class ini bertindak sebagai cetak biru (blueprint) data individu dengan prinsip enkapsulasi OOP:

  - id (String): Identifier unik setiap orang.

  - nama: Nama lengkap individu.

  - tahunLahir (String): Tahun kelahiran individu.

  - kategori: Kategori pekerjaan/status (PNS, Swasta, Mahasiswa, Direktur, Lainnya).

  - gender: Atribut tambahan komponen bonus (Pria, Wanita).

  - Constructor & Enkapsulasi: Menggunakan parameterized constructor untuk inisialisasi awal serta method getter dan setter lengkap pada setiap atribut.

B. Class PeopleMenu (GUI & Business Logic)
Class utama yang mengextends JFrame dan terikat langsung dengan file visual designer PeopleMenu.form:

Komponen Form:

- JTextField: idField, namaField, tahunLahirField (input form).

- JComboBox: kategoriComboBox, genderComboBox (pilihan dropdown).

- JTable & JScrollPane: peopleTable di dalam scroll pane untuk menampilkan tabel beserta header kolom.

- JButton: addUpdateButton, deleteButton, cancelButton (tombol interaksi).

Koleksi & State:

- listPerson (ArrayList): Penampung koleksi objek Person di memori aplikasi.

- selectedIndex (int): Penanda baris tabel yang sedang dipilih (bernilai -1 jika sedang dalam mode tambah data baru).

Penjelasan Alur Kerja Aplikasi (Workflow CRUD)

Inisialisasi Awal:
Saat program dijalankan lewat main(), method populateList() memuat data awal ke listPerson, lalu method setTable() membentuk DefaultTableModel untuk merender tabel.

Operasi Tambah Data (Create):
User mengisi field form lalu menekan Add/Update. Sistem memvalidasi kelengkapan data, membuat objek Person baru, menyimpannya ke listPerson, memperbarui tampilan tabel, mengosongkan form, dan menampilkan notifikasi pop-up berhasil.

Operasi Baca & Ubah Data (Read & Update):
Saat baris tabel diklik, event_MouseAdapter mengambil data baris tersebut dan memasukkannya ke input field form. Teks tombol berubah menjadi Update dan tombol Delete otomatis dimunculkan. User mengedit data lalu menekan tombol Update untuk memperbarui objek di listPerson.

Operasi Hapus Data (Delete):
Ketika baris data dipilih lalu tombol Delete ditekan, muncul pop-up konfirmasi. Jika user memilih YES, data dihapus dari listPerson, tabel diperbarui

Reset Form (Cancel):
Menekan tombol Cancel akan mengosongkan field input, mengembalikan teks tombol ke Add/Update, mereset selectedIndex ke -1.

Dokumentasi

1. Dapat dilihat pada gambar berikut terdapat data yang sebelumnya sudah terisi dan kolom yang dapat diisi
   <img width="1470" height="956" alt="Screenshot 2026-10-05 at 22 40 08" src="https://github.com/user-attachments/assets/9036f9eb-e3b1-40ad-97a9-c204a7d9358f" />

2. Lalu kita coba masukkan data baik itu dari ID, Nama, Tahun Lahir, Kategori, dan juga Gender
   <img width="1470" height="956" alt="Screenshot 2026-10-05 at 22 40 37" src="https://github.com/user-attachments/assets/fcf3351a-549a-475b-a60d-a9dddc1f96c0" />

3. Lalu akan muncul pop up berikut
   <img width="1470" height="956" alt="Screenshot 2026-10-05 at 22 40 56" src="https://github.com/user-attachments/assets/45d9450d-6778-4caf-9d7b-c2cbbbd747ec" />

4. Lalu kita akan mencoba menghapus salah satu data, yang bernama Stephen
   <img width="1470" height="956" alt="Screenshot 2026-10-05 at 22 41 03" src="https://github.com/user-attachments/assets/99678ece-22cb-4848-aee3-d2e17ce79087" />
   <img width="1470" height="956" alt="Screenshot 2026-10-05 at 22 41 12" src="https://github.com/user-attachments/assets/0ccfde75-d570-4990-b3a8-bbe43db283ec" />

5. jika data tersebut berhasil dihapus maka akan muncul pop up berikut
   <img width="1470" height="956" alt="Screenshot 2026-10-05 at 22 41 20" src="https://github.com/user-attachments/assets/f4e3b6b8-5b52-4710-812a-b15c8a5e791b" />
   <img width="1470" height="956" alt="Screenshot 2026-10-05 at 22 41 28" src="https://github.com/user-attachments/assets/273b2c96-5dae-40e0-a973-5d9565d425ed" />

6. Lalu jika kita mencoba mengisi data baru dan menekan tombol cancel, maka data otomatis terhapus dan semua kolom kembali ke default
   <img width="1470" height="956" alt="Screenshot 2026-10-05 at 22 42 17" src="https://github.com/user-attachments/assets/ece6d840-1d0f-4c78-9670-080fe4868292" />
   <img width="1470" height="956" alt="Screenshot 2026-10-05 at 22 42 25" src="https://github.com/user-attachments/assets/836f2c3e-4696-4b5f-8c1c-21b3211168fc" />

 






