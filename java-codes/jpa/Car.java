
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car{
    @Id
    private int id;
    private String name;

    public Car() {}

    public Car(final int id) { this(id, null); }

    public Car(final int id, final String name) {
        this.id = id;
	this.name = name;
    }

    public String getName() { return this.name; }
    public void setName(final String name) { this.name = name; }
}
