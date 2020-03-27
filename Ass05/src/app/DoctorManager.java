/*
    2. Tạo Java main class DoctorManager bao gồm :
        a. Các fields dữ liệu:
            i. TreeMap<String,Doctor> doctorList để lưu danh sách bác sĩ.
            ii. String fname chứa tên file lưu dữ liệu các bác sĩ.
        b. Default contructor (hàm dựng mặc định) :
            i. khởi tạo field doctorList .
            ii. Gọi method readFile() để đọc dữ liệu từ file và khởi tạo cho doctorList.
        c. void add() : thêm 1 bác sĩ mới vô danh sách.
        d. void display() : In toàn bộ danh sách bác sĩ ra màn hình.
        e. void display(String id) : Tìm bác sĩ có mã số id, và in thông tin chi tiết của bs đó ra màn                                     hình.
         Nếu ko tìm thấy, in thông báo lỗi.
        f. void readFile() : Đọc file có tên chứa trong field ‘fname’ (nếu có) và fill vào danh sách                                bác sĩ.
            HD : sử dụng lớp File, ObjectInputStream.
        g. void saveFile() : Ghi danh sách bác sĩ vô file có tên chứa trong field ‘fname’
            HD : sử dụng lớp File, ObjectOutputStream.
        h. hàm main(): chứa menu gọi các chức năng trên
 */
package app;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DoctorManager {

    
    public Map<String,Doctor> doctorList;
    public String fname;
    
    public DoctorManager(){
        doctorList =new TreeMap<>();
        fname="bacsy.data";
        ReadFile();
    }
    
    
            
    public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
       DoctorManager o=new DoctorManager();
       String op="";
       
       while(true){
           System.out.println("\n== MENU ==");
           System.out.println("1. Thêm bác sỹ");
           System.out.println("2. In danh sách bác sỹ");
           System.out.println("3. Tìm bác sỹ theo mã số");
           System.out.println("4. Ghi file");
           System.out.println("5. Thoát");
           System.out.println("Vui lòng lựa chọn chức năng [1-5]");
           op=sc.nextLine().trim();
           
        switch(op){
            case "1":
                o.add();
                break;
            case "2":
                o.diplay();
                break;
            case "3":
                System.out.println("Nhập mã số bác sỹ muốn tìm");
                o.display(sc.nextLine().trim());
                break;
            case "4":
                o.writeFile();
                break;
            case "5":
                return;
            default:
                System.out.println("Vui lòng chọn lại [1-5]");
                break;
        }
       }
    }
    
    //Hàm thêm 1 bác sỹ vô danh sách
    public void add(){
        Scanner sc=new Scanner(System.in);
        Doctor d=new Doctor();
        System.out.println("Nhập thông tin bác sỹ :");
        while(true){
            System.out.println(">>Nhập ID :");
            d.id=sc.nextLine().trim();
            
            //Kiểm tra mã số mới nhập đã tồn tại trong danh sách doctorList chưa?
            if(doctorList.containsKey(d.id) ==false){
                break;   //Kết thúc vòng lặp
            }
            System.out.println("    Mã số này đã có rồi !! Vui lòng nhập lại !!");
        }
        
        System.out.println(">>Nhập tên :");
        d.name=sc.nextLine().trim();
        
        System.out.println(">>Nhập chuyên khoa");
        d.specialization=sc.nextLine().trim();
        
        while(true){
            try {
                System.out.println(">>Nhập số giờ làm việc trong ngày");
                d.availHours=Integer.parseInt(sc.nextLine().trim());
                break;
            } catch (Exception e) {
                System.out.println("Lỗi sai : "+e.getMessage()); 
           }
        }
        
        //Đưa biến đối tượng bác sỹ mới nhập thông tin thành công vô Map = hàm put(K,V)
        doctorList.put(d.id, d);
        
        System.out.println("Thêm bác sỹ mới thành công !!");
    }
    
    public void diplay(){
        //Kiểm tra danh sách có dữ liệu hay không !!
        if(doctorList.isEmpty()){
            System.out.println(">>Hệ thống chưa có dữ liệu !!");
            return;
        }
        
        System.out.println(">>Danh sách bác sỹ <<");
        //Map[Key,Value] , với Key[Mã bác sỹ] còn Value[Đối tượng bác sỹ]
        
        //Lấy dữ liệu của cột value trong danh sách (ds đối tượng bác sỹ) : doctorList.values()
        //Đối danh sách này thành 1 luồng : .stream()
        //Cách 1 :lấy từng phần tử trong luồng này , xuất lên màn hình forEach(item->System.out.println(item))
        System.out.println("\nCách 1");
        doctorList.values().stream().forEach(item->System.out.println(item));
        System.out.println("\nCách 2"); 
        //Cách 2 : Dòng lệnh này có tác dụng tương đương cách 1 nhưng viết rút gọn (method reference)
        doctorList.values().stream().forEach(System.out::println);
    }
    
    //Hàm tìm và in thông tin bác sỹ theo mã số
    public void display(String maso){
        //Kiểm tra xem trong danh sách có dữ liệu
        if(doctorList.isEmpty()){
            System.out.println(">>Hệ thống chưa có dữ liệu !!");
            return;
        }
        if(doctorList.containsKey(maso)){
            //Tìm thấy mã số trong cột key -> Lấy đối tượng bác sỹ ở cột value ra
            Doctor d=doctorList.get(maso);
            
            //In thông tin bác sỹ ra màn hình
            System.out.println("Thông tin của bác sỹ \n"+d);
        }
        else{
            System.out.println(">>Không tìm thấy bác sỹ có mã số "+maso);
        }
    }
    
    //Đọc file bacsy.data để lấy dữ liệu trong file này dưa vô danh sách doctorList để làm việc
    private void ReadFile(){
        try {
            File f=new File(fname);
            if(f.exists()==false){
                return;
            }
            //open file để đọc dữ liệu
            ObjectInputStream is=new ObjectInputStream(new FileInputStream(fname));
            
            //Đọc dữ liệu trong tập tin bacsy.data -> danh sách doctorList
            doctorList =(Map<String, Doctor>) is.readObject();
            
            //Đống file
            is.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    //Ghi danh sách bác sỹ vô danh sách bacSsy.data dưới dạng OBJECT (nhị phân)
    public void writeFile(){
        try {
            ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream(fname));
            
            //Ghi dữ liệu : ghi đối tượng doctorList
            os.writeObject(doctorList);
            
            //Đóng file
            os.close();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
