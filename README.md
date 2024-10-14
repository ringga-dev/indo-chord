# 🎸 Chord Gitar Offline

Aplikasi *Chord Gitar Offline* yang dibangun menggunakan **Android Jetpack Compose**. Aplikasi ini memberikan referensi chord gitar untuk berbagai lagu, memungkinkan pengguna mencari dan menyimpan chord favorit mereka secara offline.

## ✨ Fitur Utama
- 🔍 **Pencarian Chord**: Cari chord dari berbagai lagu dengan mudah.
- 🎵 **Tampilan Chord**: Menampilkan chord dalam bentuk diagram gitar yang interaktif.
- 🎚️ **Transpose Chord**: Naikkan atau turunkan nada sesuai kebutuhan.
- ❤️ **Favorit**: Simpan chord favorit untuk akses cepat.
- 📲 **Offline Mode**: Aplikasi sepenuhnya dapat diakses tanpa koneksi internet.

## 🛠️ Arsitektur
Aplikasi ini menggunakan arsitektur **MVVM (Model-View-ViewModel)**:

- **Model**: Menyimpan data lagu dan chord, termasuk pengaturan untuk menyimpan data secara lokal menggunakan Room Database.
- **ViewModel**: Mengelola logika data, termasuk pengambilan data dari Room dan penyediaan data untuk UI.
- **View**: Dibuat dengan **Jetpack Compose**, bertanggung jawab untuk menampilkan antarmuka pengguna yang interaktif dan reaktif.

## 📚 Teknologi yang Digunakan
- **Kotlin**: Bahasa pemrograman utama.
- **Jetpack Compose**: Membuat UI yang modern dan responsif.
- **Room Database**: Penyimpanan data secara lokal.
- **LiveData / StateFlow**: Untuk memantau perubahan data di ViewModel.
- **Dependency Injection**: Menggunakan Dagger Hilt untuk mengelola dependensi.

## 📂 Struktur Proyek
- APP
- REMOTE

## 🚀 Cara Menggunakan
1. **Clone repository ini**:
   ```bash
   git clone[ https://github.com/username/ChordGitarOffline.git](https://github.com/ringga-dev/indo-chord.git)
   cd indo-chord
   open in android studio

