package pl.coderslab.Dao;

import pl.coderslab.Entity.Employees;
import pl.coderslab.Service.DBService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeesDao {

    private final String database = "workshop";
    private final String table = "Employees";

    public List<Employees> findAll() {
        String query = "SELECT * FROM " + table;

        try {
            List<Map<String, String>> result = DBService.qSelect(database, query, null);

            if (result != null) {
                List<Employees> employees = new ArrayList<>();
                for (Map<String, String> oneEmployee : result) {
                    employees.add(createEmployee(oneEmployee));
                }
                return employees;
            }

        } catch (SQLException e) {
            System.out.println("EmployeesDao: findAll - ERROR: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("EmployeesDao: findAll - ERROR2: " + e.getMessage());
        }
        return null;
    }

    public Employees getEmployee(int employee_id) {
        String query = "SELECT * FROM " + table + " WHERE employee_id=?";
        List<String> parsing = new ArrayList<>();
        parsing.add(String.valueOf(employee_id));

        try {
            List<Map<String, String>> result = DBService.qSelect(database, query, parsing);
            Map<String, String> oneEmployee = result.get(0);

            Employees employee = createEmployee(oneEmployee);

            return employee;
        } catch (SQLException e) {
            System.out.println("EmployeesDao: getEmployee - ERROR: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("EmployeesDao: getEmployee - ERROR2: " + e.getMessage());
        }
        return null;
    }

    public Employees createEmployee(Map<String, String> oneEmployee) throws Exception {
        try {
            Employees employee = new Employees(
                    Integer.parseInt(oneEmployee.get("employee_id")),
                    oneEmployee.get("name"),
                    oneEmployee.get("surname"),
                    oneEmployee.get("street"),
                    oneEmployee.get("city"),
                    oneEmployee.get("telephone"),
                    oneEmployee.get("note"),
                    Double.parseDouble(oneEmployee.get("hourCost")));
            return employee;
        } catch (Exception e) {
            System.out.println("EmployeesDao: createEmployee - ERROR: " + e.getMessage());
        }
        return null;
    }

    public int deleteEmployee(List<Integer> deleteEmployees) {
        String query = "DELETE FROM " + table + " WHERE employee_id=?";

        try {
            return DBService.qDelete(database, query, deleteEmployees);
        } catch (SQLException e) {
            System.out.println("EmployeesDao: deleteEmployee - ERROR: " + e.getMessage());
        }
        return 0;
    }

    public boolean addEmployee(Employees employee) {
        String query = "INSERT INTO " + table + " VALUES(null, ?, ? ,? ,? ,? ,? ,?)";

        try {
            List<String> params = new ArrayList<String>();
            params = paramsForAddUpdate(employee);
            if (DBService.qInsert(database, query, params) > 0)
                return true;
        } catch (SQLException e) {
            System.out.println("EmployeesDao: addEmployee - ERROR: " + e.getMessage());
        }
        return false;
    }

    public boolean updateEmployee(Employees employee) {
        String query = "UPDATE " + table + " SET name=?, surname=?, street=?, " +
                "city=?, telephone=?, note=?, hourCost=? WHERE employee_id=?";

        try {
            List<String> params = new ArrayList<>();
            params = paramsForAddUpdate(employee);
            params.add(String.valueOf(employee.getEmployee_id()));

            if (DBService.qUpdate(database, query, params))
                return true;
        } catch (SQLException e) {
            System.out.println("EmployeesDao: updateEmployee - ERROR");
        }
        return false;
    }

    private List<String> paramsForAddUpdate(Employees employee) {
        List<String> params = new ArrayList<>();

        params.add(employee.getName());
        params.add(employee.getSurname());
        params.add(employee.getStreet());
        params.add(employee.getCity());
        params.add(employee.getTelephone());
        params.add(employee.getNote());
        params.add(String.valueOf(employee.getHourCost()));

        return params;
    }
}
