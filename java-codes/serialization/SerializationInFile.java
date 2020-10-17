import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.File;
import java.io.Serializable;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;

public class SerializationInFile {
    public static void main(final String[] args) throws IOException, ClassNotFoundException{

	final class Person implements Serializable{
	    private String name;
	    private int age;
	    private transient LocalDateTime timeOfObjectCreation;

	    Person(final String name, final int age){
	        this.name = name;
		this.age  = age;
		this.timeOfObjectCreation = LocalDateTime.now();
	    }

	    void setName(final String name){
	        this.name = name;
	    }

	    String getName() { return this.name; }

	    void setAge(final int age) { this.age = age; }
            
	    int getAge() { return age; }

	    LocalDateTime getTimeOfObjectCreation() { return timeOfObjectCreation; }
	    void setTimeOfObjectCreation(final LocalDateTime timeOfObjectCreation) { this.timeOfObjectCreation = timeOfObjectCreation; }

	    private void readObject(final ObjectInputStream ois) throws IOException, ClassNotFoundException{
	        ois.defaultReadObject();
		timeOfObjectCreation = LocalDateTime.now();
	    }


	}

        final File testFile = new File("Person.ser");

	try(ObjectOutputStream os =  new ObjectOutputStream(new FileOutputStream(testFile))){

            Person p1 = new Person("Anurag", 31);    
            Person p2 = new Person("Anand", 32);    

	    os.writeObject(p1);
	    os.writeObject(p2);

            os.flush();
	}catch(FileNotFoundException ex){
	    ex.printStackTrace();
	}

	try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(testFile))){
	    Person p1 = (Person) ois.readObject();
	    Person p2 = (Person) ois.readObject();

	    System.out.printf("p1 %s - %d %s %n", p1.name, p1.age, p1.timeOfObjectCreation );
	    System.out.printf("p2 %s - %d %s %n", p2.name, p2.age, p2.timeOfObjectCreation );
	} catch(FileNotFoundException ex){
	    ex.printStackTrace();
	}
    }
}
