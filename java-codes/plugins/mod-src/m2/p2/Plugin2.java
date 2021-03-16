package p2;

import com.sun.source.util.*;

public class Plugin2 implements Plugin{
    public String getName() { return "plugin2"; }
    public void init(final JavacTask task, final String ...args){
        System.err.println("plugin2 hit");
    }
}
