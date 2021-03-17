import javax.persistence.*;
import java.util.List;

public class EmployeeTest{
    public static void main(final String... args){
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("employeeService");

	final EntityManager entityManager = emf.createEntityManager();
	final EmployeeService employeeService = new EmployeeService(entityManger);

	entityManger.getTransaction().begin();
	final Employee employee = employeeService.create(111);
	entityManager.getTransaction().commit();
	entityManger.close();
	emf.close();
    }
}

@Entity
public class Employee{
    @Basic(fetch=FetchType.LAZY)
    @Column(name="column")
}
