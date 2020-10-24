public sealed interface SealedShape permits Rectangle { 
    void printShapeName(); 
    String shapeName();
}
