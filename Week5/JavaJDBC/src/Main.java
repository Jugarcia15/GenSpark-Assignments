import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url="jdbc:mysql://localhost:3306/mygensparkdemo";
        String username="root";
        String password="password";
        String query = "SELECT * FROM trailcourseschema.tbl_course";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        try
        {
            Connection con = DriverManager.getConnection(url,username,password);
            Statement statement = con.createStatement();
            ResultSet resultSet =  statement.executeQuery(query);
            while (resultSet.next())
            {
                String courseData = "";
                for(int i=1; i<4;i++)
                {
                    courseData += resultSet.getString(i) + "|";
                }
                System.out.println(courseData);
            }
            con.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
}