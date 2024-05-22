import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Employee class to represent individual employee records
class Employee {
    private int id;
    private String name;
    private String department;
    private String position;
    // Other relevant fields
    
    // Constructor
    public Employee(int id, String name, String department, String position) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.position = position;
    }
    
    // Getters and setters
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    // Override toString() method to display employee information
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Department: " + department + ", Position: " + position;
    }
}

// EmployeeManagementSystem class to manage employee records
public class EmployeeManagementSystem {
    private List<Employee> employees;

    // Constructor
    public EmployeeManagementSystem() {
        this.employees = new ArrayList<>();
    }

    // Method to add a new employee
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added successfully.");
    }

    // Method to view all employees
    public void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        System.out.println("Employee Records:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    // Method to update employee information
    public void updateEmployee(int id, String newName, String newDepartment, String newPosition) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employee.setName(newName);
                employee.setDepartment(newDepartment);
                employee.setPosition(newPosition);
                System.out.println("Employee information updated successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    // Method to delete an employee
    public void deleteEmployee(int id) {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getId() == id) {
                iterator.remove();
                System.out.println("Employee deleted successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public static void main(String[] args) {
        // Sample usage
        EmployeeManagementSystem system = new EmployeeManagementSystem();
        system.addEmployee(new Employee(1, "Swarna", "HR", "Manager"));
        system.addEmployee(new Employee(2, "pinky", "Finance", "Analyst"));

        system.viewEmployees();

        // Update an employee
        system.updateEmployee(1, "Swarna", "HR", "Manager");

        // Delete an employee
        system.deleteEmployee(2);

        system.viewEmployees();
    }
}