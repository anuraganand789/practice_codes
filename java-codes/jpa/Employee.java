public enum EmployeeType{
    FULL_TIME_EMPLOYEE,
    PART_TIME_EMPLOYEE,
    CONTRACT_TIME_EMPLOYEE
}

@Entity
@Table(name = "employee")
public class Employee{
    
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    @TableGenerator(name="TABLE_GENERATOR", 
                    table="ID_TABLE", 
		            pkColumnName="ID_TABLE_NAME",
		            pkColumnValue="employee_id",
		            value="sequence_id"
		           )
    private long id;

    @Enumerated(EnumType.STRING)
    private Employee type;
    
    @Temporal(TemporalType.DATE)
    private Calendar dob;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    transient private String translatedName;
}

Employee <----> Project
Employee -----> Address

Employee  <-----> Project
         *       *
         (Many to Many)
Many Employee can be part of one department .
Many to one
Children of same mother 
Many to one
Mother -> Children [ One To Many ]

@Entity
public class Employee{
    @ManyToOne
    @JoinColumn(name="DEPT_ID")
    private Department department;

    @OneToOne
    @JoinColumn(name="PSPACE_ID")
    private ParkingSpace parkingSpace;
}


@Entity
public class ParkingSpace{
    
    @OneToOne(mappedBy="parkingSpae")
    private Employee employee;

}

Employee ----> ParkingSpace
      0..1  0..1
  [ One to One Mapping ]

@Entity
public class Department{
    @Id
    private long id;
    
    //If we do not use a mappedBy column, then
    //JPA provider will assume that this is a unidirectional 
    //relationship and will need a join table for that.
    @OneToMany(mappedBy="department", targetEntity=Employee.class)
    private Set<Employee> listOfEmployees;

}


@Entity
public class Project{
    
    @ManyToMany(mappedBy="setOfProjects")
    private Set<Employee> setOfEmployees;
}

@Entity
public class Employee {
    
    @ManyToMany
    private Set<Project> setOfProjects;
}

@Embeddable
@Access(AccessType.FIELD)
public class Address{
    private String street;
    private String city;
    private String state;

    @Column(name="Zip_code")
    private String zip;
}

@Entity
public class Employee{
    @Id
    private long id;

    private String name;
    private long salary;

    @Embedded
    @AttributesOverrides(
    {
        @AttributeOverride(name="state", column=@Column(name="PROVINCE")),
        @AttributeOverride(name="zip", column=@Column(name="POSTAL_CODE")),
    }
    )
    private Address address;
}

@Entity
public class Company{
    
    @Id 
    private String name;

    @Embedded
    private Address address;
}
