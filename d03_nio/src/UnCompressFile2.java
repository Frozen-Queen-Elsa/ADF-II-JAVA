
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterOutputStream;

/**
 *
 * @author THUYLM
 */
public class UnCompressFile2 {

    public static void main(String[] args) {
        String compressName = "danga.dft";
        String txtName = "baihat2.txt";
        
        try {
            java.nio.file.Path p = java.nio.file.Paths.get(compressName);
            
            java.io.FileOutputStream fos = new FileOutputStream(txtName);
            java.util.zip.InflaterOutputStream os = new InflaterOutputStream(fos);
            os.write(java.nio.file.Files.readAllBytes(p));
            
            os.flush();
            os.close();
            
            
        } catch (Exception ex) {
            System.out.println("Loi: " + ex.getMessage());
        }
        
        System.out.println("FINSHED UNCOMPRESS FILE !");
        
    }

}
