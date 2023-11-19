package jp.ac.chitose.db_prac;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PreExamDAO {
    private static final String URL = "jdbc:h2:~/h2db/db_prac;Mode=PostgreSQL;AUTO_SERVER=TRUE;";
    private static final String USER_NAME = "b2220060";
    private static final String USER_PASS = "2VMware@//ty";
    public List<PreExam> selectPreExams(int lessThan) throws SQLException{
        List<PreExam> returning = new ArrayList<>();
        String SQL = "SELECT * FROM 学生情報 WHERE 得点 < ?";

        try(Connection conn = DriverManager.getConnection(URL,USER_NAME,USER_PASS);
            PreparedStatement stmt = conn.prepareStatement(SQL,lessThan)){
            stmt.setInt(1,lessThan);
            ResultSet result = stmt.executeQuery();
            while(result.next()){
                String col1 = result.getString("学生コード");
                String col2 = "null";
                String col3 = "null";
                int col4 = result.getInt("得点");
                PreExam preExam = new PreExam(col1,col2,col3,col4);
                returning.add(preExam);
            }
        }
        return returning;
    }
}
