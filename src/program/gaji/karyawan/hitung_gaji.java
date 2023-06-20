/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package program.gaji.karyawan;

/**
 *
 * @author Luincerz
 */
public class hitung_gaji {
    Database db = new Database();
    int jatah_cuti,lembur,izin,cuti,sakit,alfa;
    int tunj_pendidikan,tunj_lembur,pot_cuti,pot_izin,pot_sakit,pot_alfa,total_potongan;

    public int getLembur() {
        return lembur;
    }

    public void setLembur(int lembur) {
        this.lembur = lembur;
    }

    public int getIzin() {
        return izin;
    }

    public void setIzin(int izin) {
        this.izin = izin;
    }

    public int getCuti() {
        return cuti;
    }

    public void setCuti(int cuti) {
        this.cuti = cuti;
    }

    public int getSakit() {
        return sakit;
    }

    public void setSakit(int sakit) {
        this.sakit = sakit;
    }

    public int getAlfa() {
        return alfa;
    }

    public void setAlfa(int alfa) {
        this.alfa = alfa;
    }
    
    
    
//  Hitung Gaji Pokok
    public int tunjangan_gaji(String tunj_gaji){
        if ("SMA".equals(tunj_gaji)){
           tunj_pendidikan = 4500000; 
        }
        else if ("D3".equals(tunj_gaji)){
           tunj_pendidikan = 5300000; 
        }
        else if ("S1".equals(tunj_gaji)){
           tunj_pendidikan = 6000000; 
        }
        return tunj_pendidikan;
        
    }
    
//  hitung Tunjangan Lembur
    public int tunjangan_lembur(){
        if (lembur <=5 ){
            tunj_lembur = 30000 * lembur;
        }
        else if (lembur > 5){
            tunj_lembur = 300000;
        }
        return tunj_lembur;
    }
    
//  hitung potongan Izin
    public int pot_izin(){
        if (izin >= 1){
            pot_izin = izin * 50000;
        }
        else {
            pot_izin = 0;
        }
        return pot_izin;
    }
    
//  Hitung potongan Cuti
     public int pot_cuti(Integer sisa_cuti){
        if (cuti > sisa_cuti){
            pot_cuti = (cuti - sisa_cuti)  * 30000;
        }
        else {
            pot_cuti = 0;
        }
        return pot_cuti;
    }
    
//  Hitung Potongan Sakit
    public int pot_sakit(){
        if (sakit > 3){
            pot_sakit = sakit * 50000;
        }
        
        else {
            pot_sakit = 0;
        }
        return pot_sakit;
    }
    
    
//  Hitung potongan Alfa
    public int pot_alfa(){
        if (alfa >= 1){
            pot_alfa = alfa * 150000;
        }
        
        else {
            pot_alfa = 0;
        }
        return pot_alfa;
    }
    
    
//  Hitung Total Potongan Gaji
    public int total_potongan(){
        return total_potongan = pot_izin + pot_cuti + pot_sakit + pot_alfa ;
    }
    

//  Hitung Total Gaji yang Diterima
    public int total_gaji_diterima(){
        return this.tunjangan_gaji(db.getUser_pendidikan()) + this.getLembur() - this.total_potongan();
    }
    
}
