import java.util.List;
import java.util.Scanner;

public class EmployeeService {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter database type (mysql/oracle): ");
        String dbType = sc.nextLine();

        EmployeeDAO dao;

        // Runtime polymorphism
        if (dbType.equalsIgnoreCase("mysql")) {
            dao = new MySQLEmployeeDAO();
        } else {
            dao = new OracleEmployeeDAO();
        }

        List<Employee> employees = dao.getEmployees();

        System.out.println("\n--- Employee Data ---");
        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}
