module m2{
    requires jdk.compiler;
    provides com.sun.source.util.Plugin with p2.Plugin2;
}
