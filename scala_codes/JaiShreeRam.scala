import java.util.List;
class Person(var firstName : String, var lastName : String){

    println("Constructor Begins");

    var age = 0
    private val HOME = System.getProperty("user.home");

    override def toString() : String = s"$firstName - $lastName";

    def printHome() : Unit = println(s"User Home is $HOME");
    def printFullName() : Unit = println(this);

    printHome();
    printFullName();

    println("You haver reached the end of constructor");
}
