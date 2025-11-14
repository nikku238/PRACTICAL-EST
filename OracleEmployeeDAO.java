import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OracleEmployeeDAO extends EmployeeDAO {

    @Override
    List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();

        try {
            // Oracle driver (dummy)
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "system",
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
            System.out.println("Oracle DB not connected. Using dummy output...");
        }

        return list;
    }
}
