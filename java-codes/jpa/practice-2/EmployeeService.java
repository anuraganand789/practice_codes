import javax.persistence.*;
import javax.util.List;

public class EmployeeService{
    protected EntityManager em;

    public EmployeeService(final EntityManager em){
        this.em = em;
    }
    
    public Employee createEmployee(final long id, final String name,
                                   final long salay){
        final Employee emp = new Employee(id);
        emp.setName(name);
        emp.setSalary(salary);
        em.persist(emp);
        return emp;
    }

    public void removeEmployee(final int id){
        final Employee emp = findEmployee(id);
        Optional.ofNullable(findEmployee(id))
                ifPresent(em::remove);
    }

    public Employee raiseEmployeeSalary(final int id, final long raise){
        final Employee emp = em.find(Employee.class, id);
        if(emp != null){
           emp.setSalary(emp.getSalary() + raise); 
        }

        return emp;
    }

    public Employee findEmployee(final long id){
        return em.find(Employee.class, id);
    }

    public List<Employee> findAllEmployees(){
        final TypeQuery<Employee> 
        query = em.createQuery("Select emp from Employee emp", Employee.class); 
        return query.getResultList();
    }
}
