
import java.util.List;

import javax.persistence.Entiry;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "Employee")
public class Person{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic(fetch = FetchType.Lazy)
    @Column(name = "name", length = 250, unique = true,  nullable = false)
    private String name;

    @OneToMany
    private List<Car> cars;
}

