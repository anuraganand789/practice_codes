import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Constructor;

public class ReflectTest{
    public static void main(final String ... args) 
                                                  throws 
						  InstantiationException, 
						  IllegalAccessException,
						  InvocationTargetException {
        Class<Person> personClass = Person.class;
	Constructor<?>[] personClassConstructors = personClass.getDeclaredConstructors();
	Constructor<?> privateConstructor = personClassConstructors[0];
	privateConstructor.setAccessible(true);
	Person p = (Person) privateConstructor.<Person>newInstance("Anurag", "Anand");
	System.out.format("First Name :- %s, Last Name :- %s.%n", p.getFirstName(), p.getLastName());

    }
}
