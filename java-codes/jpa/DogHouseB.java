//Complex id
@Entity
public class DogHouseB{
    
    @Id
    private int dogId;

    @MapsId
    @OneToOne
    @JoinColumn(name = "dog_id")
    private Dog dog;
}
