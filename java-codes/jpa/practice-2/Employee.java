
@Entity
public class Employee{
  @Id
  private long id;

  private String name;
  private long salary;

}
//creating an entity manager factory
EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");

//persisting employee

public Employee createEmployee(final long id, final long salary){
    Employee emp = new Employee(12, 1999, null);
    entityManager.persist(emp);
    return emp;
}

//Finding an Entity
Employee emp = entityManager.find(Employee.class, 12);

//^-- above code can return null, in cases the an employee with 
//the mentioned id did not exits in database.
//that means , either that employee was never there or it was deleted

//Removal
final Employeee emp = em.find(Employee.class, 158);
enitiyManager.remove(emp);
//^-- above code will throw IllegalArgumentException for 'null' input

public void removeEmployee(final long id){
  final Employee employee = entityManager.find(Employee.class, id);
  if(employee != null){
    entityManager.remove(empoyee);
  }
  //or
  final Optional<Employee> maybeEmployeeIsThere = 
      Optional.ofNullable(entityManager.find(Employee.class, id));
  
  maybeEmployeeIsThere.ifPresent(entityManager::remove);

  //or

  Optional
  .ofNullable(entityManager
  .find(Employee.class, id))
  .ifPresent(entityManager::remove);

}

public Employee raiseEmployee(final int id, final long salary){
    final Employee employee = entityManager.find(Employee.class, id);
    if(employee != null) employee.setSalary(employee.getSalary() + 1000);
    return employee;
}

//transactions

entityManager.getTransaction().begin();
createEmployee(158, "anurag", 499);
entityManager.getTransaction().commit();

query is created as Query or TypedQuery object using
entityManager as factory class

static query -> specified in xml or @NamedQuery annotation.
they have names and we can call them with names in the applicaiton

Dynamic query -> created by jpql queries and criteia object

TypedQuery<Employee> query = em.createQuery("Select employee from Employee employee", Employee.class);

List<Employee> listOfEmployee = query.resultList();


@Entity
@Access(AccessType.FIELD)
public class Employee{}



