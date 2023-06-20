/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package program.gaji.karyawan;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 70190025
 */
public class Database {
    public static Connection con;
    public static Statement stm;
    public static ResultSet rst;
    String nama,pendidikan,kelamin,sisa_cuti,tanggal;
    String user_nama,user_pendidikan,user_kelamin,user_cuti,user_tanggal;
    
    public Database(){
        koneksimysql();
        select_data();
//        setNama(nama);
        
    }

//    public koneksi(String nama, String pendidikan){
//        this.nama = nama;
//        this.pendidikan = pendidikan;
//    }
    

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(String pendidikan) {
        this.pendidikan = pendidikan;
    }

    public String getKelamin() {
        return kelamin;
    }

    public void setKelamin(String kelamin) {
        this.kelamin = kelamin;
    }

    public String getSisa_cuti() {
        return sisa_cuti;
    }

    public void setSisa_cuti(String sisa_cuti) {
        this.sisa_cuti = sisa_cuti;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getUser_nama() {
        return user_nama;
    }

    public void setUser_nama(String user_nama) {
        this.user_nama = user_nama;
    }

    public String getUser_pendidikan() {
        return user_pendidikan;
    }

    public void setUser_pendidikan(String user_pendidikan) {
        this.user_pendidikan = user_pendidikan;
    }

    public String getUser_kelamin() {
        return user_kelamin;
    }

    public void setUser_kelamin(String user_kelamin) {
        this.user_kelamin = user_kelamin;
    }

    public String getUser_cuti() {
        return user_cuti;
    }

    public void setUser_cuti(String user_cuti) {
        this.user_cuti = user_cuti;
    }

    public String getUser_tanggal() {
        return user_tanggal;
    }

    public void setUser_tanggal(String user_tanggal) {
        this.user_tanggal = user_tanggal;
    }
    
    
    
//  Koneksi Ke database
    public void koneksimysql(){
//    public void koneksimysql(String querry){    
        try{
            String url = "jdbc:mysql://localhost/db_gaji";
            String user = "root";
            String pass = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,user,pass);
            stm = con.createStatement();  
            
//            JOptionPane.showMessageDialog(null, "Berhasil"); 
            
        }catch(Exception e){
            System.err.println("Koneksi Gagal" + e.getMessage());
        }
    }
    
   
//  Mengambil data dari Database
    public void select_data(){
//        ResultSet rst;
        try {
            rst = stm.executeQuery("select * from karyawan");           
            while(rst.next()){
                nama = rst.getString("nama");
                pendidikan = rst.getString("pendidikan");
                kelamin = rst.getString("kelamin");
                sisa_cuti = rst.getString("sisa_cuti");
                tanggal = rst.getString("tanggal");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    
    
//  Input Data Karyawan  
    public void insert_data(String nama, String pendidikan, String kelamin, String sisa_cuti, String tanggal){
        try {           
            String query = "insert into karyawan values (?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, nama);
            pst.setString(2, pendidikan);
            pst.setString(3, kelamin);
            pst.setInt(4, Integer.valueOf(sisa_cuti));
            pst.setString(5, tanggal);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Ditambahkan");
        } catch (SQLException ex) {
            
        }
    }
    
    
//  Delete Data berdasarkan Nama yang di klik
    public void delete_data(String del_nama){
        try {
            String query = "delete from karyawan where nama = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, del_nama);
            pst.executeUpdate();
        } catch (SQLException ex) {
            
        }  
    }
    
    
//  Mengambil data user berdasarkan nama yang dipilih
   public void select_user(String nama_user) {
       try{
           String querry = "select * from karyawan where nama = ? ";
           PreparedStatement pst = con.prepareStatement(querry);
           pst.setString(1, nama_user);
           rst = pst.executeQuery();
           while(rst.next()){
                user_nama = rst.getString("nama");
                user_pendidikan = rst.getString("pendidikan");
                user_kelamin = rst.getString("kelamin");
                user_cuti = rst.getString("sisa_cuti");
                user_tanggal = rst.getString("tanggal");
            }
       } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
           
}
