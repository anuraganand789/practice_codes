package packageA;

import com.sun.source.util.*;

public class PluginA implements Plugin{
    public String getName() { return "pluginA"; }
    public void init(final JavacTask task, final String ...args){
        System.err.format("%s was hit.%n", this.getName());
    }
}
