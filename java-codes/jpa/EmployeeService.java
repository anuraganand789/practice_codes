import javax.persistence.*;

import java.util.List;
import java.util.Optional;

public class EmployeeService{
    private EntityManager entityManager;

    public EmployeeService(final EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public Employee createEmployee(final int id, final String name, final long salary){
        final Employee employee = new Employee(id, name, salary);
	em.persist(employee);
	final Employee employeeFromDB = em.find(id, Employee.class);
	return employeeFromDB;
    }

    public boolean delete(final int id){
        final Optional<Employee> employee = this.find(id);
	employee.ifPresent(emp -> em.remove(emp));
	return employee.isPresent();
    }

    public Optional<Employee> find(final int id){
        return Optional.ofNullable(entityManager.find(id, Employee.class));
    }

    public Optional<Employee> updateSalary(final int id, final long salary){
        final Optional<Employee> employee = this.find(id);
	employee.ifPresent(emp -> emp.setSalary(salary));
	return employee;
    }
}
