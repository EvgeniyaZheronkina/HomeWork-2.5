package ru.skypro.home_work_25.service;

import org.springframework.stereotype.Service;
import ru.skypro.home_work_25.Employee;
import ru.skypro.home_work_25.exception.EmployeeAlreadyAddedException;
import ru.skypro.home_work_25.exception.EmployeeNotFoundException;
import ru.skypro.home_work_25.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Иван", "Иванов"),
            new Employee("Семен", "Горбунков "),
            new Employee("Петр", "Петров"),
            new Employee("Николай", "Николаев"),
            new Employee(" Федор ", "Федоров")));
    private static final int STORAGE_SIZE = 5;

    public Employee add (String firstName, String lastName) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() >= STORAGE_SIZE){
            throw new EmployeeStorageIsFullException("Коллекция переполнена");
        }
        if (employees.contains(employee)){
            throw new EmployeeAlreadyAddedException("Сотрудник уже есть в коллекции");
        }
        employees.add(employee);
        return employee;
    }

    public Employee remove (String firstName, String lastName) throws EmployeeNotFoundException{
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)){
            employees.remove(employee);
            return employee;
        }

        if (! employees.contains(employee)) {
            throw new EmployeeNotFoundException("Такого сотрудника нет в коллекции");
        }
        employees.remove(employee);
        return null;
    }

    public Employee find(String firstName, String lastName) throws EmployeeNotFoundException {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }

        Employee employeeToFind = new Employee(firstName, lastName);
        if (! employees.contains(employeeToFind)) {
            throw new EmployeeNotFoundException ("Такого сотрудника нет в коллекции");
        }

        for (Employee employee1 :employees) {
            if (employee.equals(employeeToFind)){
                return employee;
            }
        }
        return null;
    }

    public List <Employee> getAll(){
        return employees;
    }


}
