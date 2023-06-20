/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package program.gaji.karyawan;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;  
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author Luincerz
 */


public class tanggal {
    public static DateTimeFormatter date;
    
    public void tanggal(){
        tanggal_sekarang();
    }
    
//  Mengambil Data Tanggal Sekarang
    public String tanggal_sekarang(){
        date = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime now = LocalDateTime.now();
        return date.format(now);
    }
    
//  Menghitung selilih hari dari tanggal sekarang
    public long hitung_tanggal_gajian(String tgl_gajian_trakhir) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        Date gajian_trakhir = sdf.parse(tgl_gajian_trakhir);
        Date tgl_sekarang = sdf.parse(this.tanggal_sekarang());
        
        long jarak_tgl = Math.abs(gajian_trakhir.getTime() - tgl_sekarang.getTime());
        long diff = TimeUnit.DAYS.convert(jarak_tgl, TimeUnit.MILLISECONDS);

        return diff;
    }
}
