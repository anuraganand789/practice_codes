package p1;

import com.sun.source.util.*;

public class Plugin1 implements Plugin{
    public String getName() { return "plugin1"; }
    public void init(final JavacTask task, final String ...args){
        System.err.println("plugin1 hit");
    }
}
