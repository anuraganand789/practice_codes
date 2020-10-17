@ interface Bug{
    enum Color {RED, BLACK};
    String date();
    String developerName();
    String engineerName() default "[Unknown]";
}
