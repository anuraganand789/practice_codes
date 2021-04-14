public class Derived extends Base{
    public void printDerived(Derived derived){
        System.out.println(derived.name);
    }

    public void printBase(Base base){
        //accessing protected member variables using instances
        System.out.println(base.name);
    }
}
