package model;

public class AnggotaKlub {
    private String nama;
    
    public AnggotaKlub(String nama) {
        this.nama = nama;
    }
    
    public String getNama() {
        return nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getInfo() {
        return "Nama             : " + nama;
    }          
}

