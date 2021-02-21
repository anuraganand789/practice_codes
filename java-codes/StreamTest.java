import java.util.stream.Stream;
import java.util.Comparator;
import java.util.List;

public class StreamTest{
    class Subject {
        String name;
	int marks;

	public Subject(final String name, final int marks) {
	    this.name = name;
	    this.marks = marks;
	}

	public int getMarks() { return this.marks; }

	public String toString(){ 
	    return "Name " + name + " marks " + marks;
	} 
    }
    class Person {
        String name;
	int totalmarks;
	List<Subject> subjects;

	public Person(final String name, final int totalmarks, final List<Subject> subjects) {
	    this.name = name;
	    this.totalmarks = totalmarks;
	    this.subjects = subjects;
	}

	public int getTotalMarks()  { return this.totalmarks; }

	public String toString(){ return "Name " + name + " total marks " + totalmarks; }
    }
    
    public static void main(final String[] args){
        final StreamTest st = new StreamTest();
	List<Subject> subjects = List.of(st.new Subject("a", 12), st.new Subject("b", 122), st.new Subject("c", 1));
        Stream<Person> streamOfPersons = Stream.of(
	                                           st.new Person("Anurag", 12, subjects), 
	                                           st.new Person("Anand", 13, subjects), 
	                                           st.new Person("Ajay", 111, subjects)
						  );
	final Person person =streamOfPersons.max(Comparator.comparingInt(Person::getTotalMarks)).get(); 
	System.out.println(person);

	person.subjects.stream().sorted(Comparator.comparing(Subject::getMarks).reversed()).limit(2).forEach(System.out::println);
    }
}
