public class Student { 
    private String nama; 
    public int skor; 

    public Student(String nama) { 
        this.nama = nama; 
    }

    private void setNama(String nama) {
        this.nama = nama;
    }

    public void ubahNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {  
        return nama;
    }
    
    public int getSkor() { 
        return this.skor; 
    } 
}
