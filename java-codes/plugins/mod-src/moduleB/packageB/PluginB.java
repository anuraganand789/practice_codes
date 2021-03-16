package packageB;

import com.sun.source.util.*;

public class PluginB implements Plugin{
    public String getName() { return "pluginB"; }
    public void init(final JavacTask task, final String ...args){
        System.err.format("%s was hit.%n", this.getName());
    }
}
