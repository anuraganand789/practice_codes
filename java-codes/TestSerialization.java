import java.io.Serializable;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class TestSerialization implements Serializable {
    private String name;
    private transient int    size;
    public TestSerialization(final String name){
        this.name = name;
	this.size = name.length();
    }

    public String getName() { return name; }

    @Override
    public String toString(){
        return "Name " + name + " Length " + size;
    }

    private void readObject(ObjectInputStream is) 
            throws IOException, ClassNotFoundException{
        is.defaultReadObject();
	size = is.readInt();
    }

    private void writeObject(ObjectOutputStream os) 
            throws IOException, ClassNotFoundException{
        os.defaultWriteObject();
        os.writeInt(size);
    }

    public static void main(final String... args) throws IOException, ClassNotFoundException{
        final ByteArrayOutputStream byteArrOS = new ByteArrayOutputStream();
	final ObjectOutputStream    objOS     = new ObjectOutputStream(byteArrOS);

	final TestSerialization t1 = new TestSerialization("Anurag");
	final TestSerialization t2 = new TestSerialization("Anand");

	objOS.writeObject(t1);
	objOS.writeObject(t2);

	objOS.close();

	ByteArrayInputStream byteArrIS = new ByteArrayInputStream(byteArrOS.toByteArray());
	ObjectInputStream    objIS     = new ObjectInputStream(byteArrIS);

	TestSerialization tt1  =  (TestSerialization) objIS.readObject();
	TestSerialization tt2  =  (TestSerialization) objIS.readObject();

	objIS.close();

	System.out.println("tt1 " + tt1);
	System.out.println("tt2 " + tt2);

    }

}
