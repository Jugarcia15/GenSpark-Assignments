import java.sql.*;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        String url = "jdbc:mysql://localhost:3306/trailcoursescheme?serverTimezone=UTC";
        String username="root";
        String password="password";
        String query = "Select * from trailcoursescheme.tbl_course";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement statement= con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                String courseData = "";
                for(int i = 1; i< 4; i++){
                    courseData += resultSet.getString(i) + "|";
                }
                System.out.println(courseData);
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}