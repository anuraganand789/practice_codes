

public class NewCar{
    
    @EmbeddedId
    private NewCarId carId;
}

@Embeddable
class NewCarId implements Serializable{
    private static final long serialVersionUID = 2L;

    private int id;
    private String name;


}
