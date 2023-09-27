package demo.repository;
import demo.db.ConnectionToDatabase;
import demo.entity.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeRepository {

    private static final Logger LOGGER = Logger.getLogger(EmployeeRepository.class.getName());

    public String saveEmployee(Employee employee) {

        try (Connection connection = ConnectionToDatabase.connectToDB()) {
            String sql = "INSERT INTO employees (name,position, phone) VALUES(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getPosition());
            statement.setString(3, employee.getPhone());
            statement.executeUpdate();
            return "Success";
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
            return "Error";
        }
    }

    public List<Employee> getEmployees() {

        try (Connection connection = ConnectionToDatabase.connectToDB()) {
            List<Employee> list = new ArrayList<>();
            String sql = "SELECT * FROM employees";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(new Employee(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("position"),
                        resultSet.getString("phone")
                ));
            }
            return list;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
            return Collections.emptyList();
        }
    }

    public Employee getEmployeeById(int id) {

        Employee employee = null;

        try (Connection connection = ConnectionToDatabase.connectToDB()) {
            String sql = "SELECT * FROM employee WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();

            while (set.next()) {
                employee = new Employee(id, set.getString("name"),
                        set.getString("position"),
                        set.getString("phone"));
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return employee;
    }

    public void updateEmployee(Employee employee) {
        String sql = "UPDATE employee SET position = ?, phone =? WHERE id = ?";

        try (Connection connection = ConnectionToDatabase.connectToDB()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, employee.getPosition());
            statement.setString(2, employee.getPhone());
            statement.setInt(3, employee.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }
    }

    public void deleteEmp(Employee employee) {
        String sql = "DELETE FROM employee where id = ?";
        try (Connection conn = ConnectionToDatabase.connectToDB();
                PreparedStatement pstmt =conn.prepareStatement(sql)){
            pstmt.setInt(1, employee.getId());
            pstmt.executeUpdate();
        } catch(SQLException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }
    }
}

