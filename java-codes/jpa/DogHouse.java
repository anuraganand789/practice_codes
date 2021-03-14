
@Entity
public class DogHouse{
    
    @Id
    @OneToOne
    @JoinColumn(name = "DOG_ID")
    private Dog dog;
    
}



