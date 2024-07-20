package ru.skypro.home_work_25.service;

import ru.skypro.home_work_25.Employee;
import ru.skypro.home_work_25.exception.EmployeeAlreadyAddedException;
import ru.skypro.home_work_25.exception.EmployeeNotFoundException;
import ru.skypro.home_work_25.exception.EmployeeStorageIsFullException;

import java.util.Collection;

public interface EmployeeService {

    Employee add (String firstName, String lastName);

    Employee remove (String firstName, String lastName);

    Employee find (String firstName, String lastName);

    Collection<Employee> findAll();
}
