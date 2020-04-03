
import java.io.FileOutputStream;
import java.util.zip.DeflaterOutputStream;

/*
    Nén tập tin danga.txt -> iris.zip
 */


public class CompressFile2 {

    
    public static void main(String[] args) {
        String vb ="danga.txt";
        String nen="iris.zip";
        
        try{
            java.nio.file.Path p=java.nio.file.Paths.get(vb);
            
            java.io.FileOutputStream fos =new FileOutputStream(nen);
            java.util.zip.DeflaterOutputStream dos=new DeflaterOutputStream(fos);
            
            dos.write(java.nio.file.Files.readAllBytes(p));
            
            dos.flush();
            dos.close();
            
            System.out.println("Nén file thành công !!");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
}
