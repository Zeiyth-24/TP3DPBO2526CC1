public class Person {
    private String id;
    private String nama;
    private String tahunLahir;
    private String kategori;
    private String gender; // Atribut Baru Komponen

    // Constructor
    public Person(String id, String nama, String tahunLahir, String kategori, String gender) {
        this.id = id;
        this.nama = nama;
        this.tahunLahir = tahunLahir;
        this.kategori = kategori;
        this.gender = gender;
    }

    // Getter dan Setter
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getTahunLahir() { return tahunLahir; }
    public void setTahunLahir(String tahunLahir) { this.tahunLahir = tahunLahir; }
    public String getKategori() { return kategori; }
    public void setKategori(String kategori) { this.kategori = kategori; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
}