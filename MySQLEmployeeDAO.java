import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLEmployeeDAO extends EmployeeDAO {

    @Override
    List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();

        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employee_db",
                    "root",
                    "password"
            );

            String query = "SELECT * FROM employee";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                list.add(new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("salary")
                ));
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
