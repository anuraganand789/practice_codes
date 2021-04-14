public class Person{
    private String firstName;

    public boolean same(Person person){
        //Java allows instance level access for cross-instance private level access
        return this.firstName == person.firstName;
    }
}
