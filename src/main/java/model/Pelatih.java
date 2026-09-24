package model;

public class Pelatih extends AnggotaKlub{
    private String spesialisasi;
    private int pengalaman;
    
    public Pelatih(String nama, String spesialisasi, int pengalaman) {
        super(nama);
        this.spesialisasi = spesialisasi;
        setPengalaman(pengalaman);
    }
    
    public String getSpesialisasi(){
        return spesialisasi;
    }
    
    public int getPengalaman(){
        return pengalaman;
    }
    
    public void setSpesialisasi(String spesialisasi){
        this.spesialisasi = spesialisasi;
    }
    
    public void setPengalaman(int pengalaman){
        if (pengalaman >= 0 && pengalaman <= 50) {
            this.pengalaman = pengalaman;
        }
        else {
            this.pengalaman = 0;
            System.out.println("Tahun Pengalaman tidak valid, diset ke 0.");
        }
    }

    @Override
    public String getInfo() {
        return super.getInfo()
        + "\nSpesialisasi     : " + spesialisasi
        + "\nPengalaman       : " + pengalaman;
    }     
}