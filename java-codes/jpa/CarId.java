

public class CarId implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private int serial;
    private String brand;

    public CarId(){}
}

@Entity
@IdClass(CarId.class)
public class Car{
    @Id
    private int serial;

    @Id
    private String brand;

    @Override
    public int hashCode() { return serial ^ brand.hashCode(); }

    @Override
    public boolean equals(final Object obj) { 
        return obj != null && 
	       (obj instanceof Car car) && 
	       car.serial == this.serial && 
	       car.brand.equals(this.brand);
    }
}
