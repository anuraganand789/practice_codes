@Entity
@IdClass(DogHouseId.class)
public class DogHouseA{
    
    @Id
    @OneToOne
    @JoinColumn(name = "dog_id")
    private Dog dog;

    @Id
    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
