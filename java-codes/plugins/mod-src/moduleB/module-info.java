module moduleB{
    requires jdk.compiler;
    provides com.sun.source.util.Plugin with packageB.PluginB;
}
