package ru.skypro.home_work_25.service;

import org.springframework.stereotype.Service;
import ru.skypro.home_work_25.Employee;
import ru.skypro.home_work_25.exception.EmployeeAlreadyAddedException;
import ru.skypro.home_work_25.exception.EmployeeNotFoundException;
import ru.skypro.home_work_25.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List <Employee> employees;
    private static final int STORAGE_SIZE = 5;

    public EmployeeServiceImpl() {
        this.employees = new ArrayList<>();
    }

    @Override
    public Employee add (String firstName, String lastName) {
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

    @Override
    public Employee remove (String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)){
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException("Такого сотрудника нет в коллекции");
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException ("Такого сотрудника нет в коллекции");
    }

    @Override
    public Collection <Employee> findAll(){
        return employees;
    }
}
