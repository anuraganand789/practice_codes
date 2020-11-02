public class Person{
    private final String firstName;
    private final String lastName;

    private Person(final String firstName, final String lastName){
        this.firstName = firstName;
	this.lastName = lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

}
