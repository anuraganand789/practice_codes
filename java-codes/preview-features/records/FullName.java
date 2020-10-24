record FullName( String firstName,  String lastName){
    public FullName{
        if(firstName.length() > 4) throw new IllegalArgumentException();
    }

    private static final int age = 10;

    public void sayHello(){
        System.out.format("Hello from %s %s%n", firstName, lastName);
    }

}
