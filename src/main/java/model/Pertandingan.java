package model;

public class Pertandingan {
    private String lawan;
    private String tanggal;
    private String kompetisi;
    private int skorKlub;
    private int skorLawan;
    private String lokasi;

    public Pertandingan(String lawan, String tanggal, String kompetisi, int skorKlub, int skorLawan, String lokasi) {
        this.lawan = lawan;
        this.tanggal = tanggal;
        this.kompetisi = kompetisi;
        setSkorKlub(skorKlub);
        setSkorLawan(skorLawan);
        setLokasi(lokasi);
    }

    public String getLawan() {
        return lawan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getKompetisi() {
        return kompetisi;
    }

    public int getSkorKlub() {
        return skorKlub;
    }

    public int getSkorLawan() {
        return skorLawan;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLawan(String lawan) {
        this.lawan = lawan;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setKompetisi(String kompetisi) {
        this.kompetisi = kompetisi;
    }

    public void setSkorKlub(int skorKlub) {
        if (skorKlub >= 0) {
            this.skorKlub = skorKlub;
        } 
        else {
            this.skorKlub = 0;
            System.out.println("Skor tidak boleh negatif, diset ke 0.");
        }
    }

    public void setSkorLawan(int skorLawan) {
        if (skorLawan >= 0) {
            this.skorLawan = skorLawan;
        } 
        else {
            this.skorLawan = 0;
            System.out.println("Skor tidak boleh negatif, diset ke 0.");
        }
    }
    
    public void setLokasi(String lokasi) {
        if (lokasi.equalsIgnoreCase("Kandang") || lokasi.equalsIgnoreCase("Tandang")) {
            this.lokasi = lokasi;
        }
        else {
            this.lokasi = "Kandang";
            System.out.println("Lokasi tidak dikenali, diset ke Kandang.");
        }
    }
    
    public String getHasil() {
        if (skorKlub > skorLawan) {
            return "Menang";
        }
        else if (skorKlub < skorLawan) {
            return "Kalah";
        }
        else{
            return "Seri";
        }
    }
}