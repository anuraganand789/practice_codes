

@Entity
@Table(name = "employee")
public class Employee{
    
    @Id
    @TableGenerator(name="TABLE_GENERATOR", 
                    table="ID_TABLE", 
		    pkColumnName="ID_TABLE_NAME",
		    pkColumnValue="employee_id",
		    value="sequence_id"
		    )
    private long id;
}
