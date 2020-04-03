/*
Lop mo ta 1 vi bac si, bao gom: 
Các fields dữ liệu:
    i. String id, name, level
    ii. int exp_years
b. Các contructors để khởi tạo giá trị ban đầu cho các field dữ liệu.
c. Method :
    * void input() : nhập chi tiết bác sĩ và kiểm tra dữ liệu hợp lệ như sau :
        - id : Dxx[xx], với x là ký số - từ 2 đến 4 ký số.
        - name : ít nhất 2 ký tự chữ hoặc khoảng trắng.
        - level : trình độ chuyên khoa: level 1, level 2 hoặc để trống.
        - exp_years: số năm kinh nghiệm , từ 0 - 60
 String toString() : override method này để biểu diễn nội dung của 1 đối tượng bác sĩ dưới dạng
chuỗi.
 */
package data;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Doctor {

    public String id, name, level;
    public int exp_years;

    public Doctor() {
    }

    public Doctor(String id, String name, String level, int exp_years) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.exp_years = exp_years;
    }

    /*
    nhập chi tiết bác sĩ và kiểm tra dữ liệu hợp lệ như sau :
        - id : Dxx[xx], với x là ký số - từ 2 đến 4 ký số.
        - name : ít nhất 2 ký tự chữ hoặc khoảng trắng.
        - level : trình độ chuyên khoa: level 1, level 2, level 3 hoặc để trống.
        - exp_years: số năm kinh nghiệm , từ 0 - 60    
     */
    public void input() {

        Scanner sc = new Scanner(System.in);

        //id : Dxx[xx], với x là ký số - từ 2 đến 4 ký số.
        Pattern p = Pattern.compile("D\\d{2,4}");
        Matcher m = null;
        while (true) {
            System.out.print("Nhap ma so bac si Dxx[xx]: ");
            id = sc.nextLine().trim();
            m = p.matcher(id);

            if (m.matches()) {
                //nhap dung yeu cau => thoat vong lap while
                break;
            }

            System.out.println(" >> ID ko hop le, vui long nhap lai !");
        }// ket thuc while

        //name : ít nhất 2 ký tự chữ hoặc khoảng trắng.
        p = Pattern.compile("[a-z ]{2,}", Pattern.CASE_INSENSITIVE);
        m = null;
        while (true) {
            try {
                System.out.print("Nhap Name:");
                name = sc.nextLine().trim();
                m = p.matcher(name);
                if (m.matches()) {
                    break;
                } else {
                    throw new Exception("Name khong hop le: name phai co it nhat 2 ky tu chu or khoang trong.");
                }
            } catch (Exception e) {
                System.out.println("Loi:" + e.getMessage());
            }
        }

        //level : trình độ chuyên khoa: level 1, level 2 hoặc để trống.
        p = Pattern.compile("Level1|Level2|Null", Pattern.CASE_INSENSITIVE);
        m = null;
        while (true) {
            System.out.println("Nhap trinh do chuyen khoa ");
            level = sc.nextLine().trim();
            if (level.isEmpty()) {
                break;
            }

            try {
                m = p.matcher(level);
                if (m.matches()) {
                    break;
                } else {
                    throw new Exception("Nhập sai. Vui lòng nhập ̣(Level1|Level2|Null)");
                }
            } catch (Exception e) {
                System.out.println("Loi : " + e.getMessage());
            }
        }

        //exp_years: số năm kinh nghiệm , từ 0 - 60
        while (true) {
            try {
                System.out.print(">Nhap so nam kinh nghiem [0-60] : ");
                exp_years = Integer.parseInt(sc.nextLine().trim());
                if (exp_years >= 0 && exp_years <= 60) {
                    break;
                } else {
                    System.out.println("exp_years số năm kinh nghiệm , từ 0 - 60");
                }
            } catch (Exception e) {
                System.out.println("Loi : " + e.getMessage());
            }
        }

    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %d", id, name, level, exp_years); 
    }
    
    
}
