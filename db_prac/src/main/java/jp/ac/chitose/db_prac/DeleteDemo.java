package jp.ac.chitose.db_prac;

import java.util.Scanner;
import java.sql.SQLException;

public class DeleteDemo {
    public static void main(String[] args) {
        System.out.println("中間テストの点数を削除する学生コードは");
        Scanner scan = new Scanner(System.in);
        String gakusekiCode = scan.nextLine();
        try{
            PreExamDAO dao =  new PreExamDAO();
            int n = dao.deletePreExam(gakusekiCode);
            System.out.println(n);
        }catch(SQLException e){
           e.printStackTrace();
        }
    }
}
