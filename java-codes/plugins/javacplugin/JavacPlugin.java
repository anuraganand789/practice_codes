package javacplugin;

import com.sun.source.util.JavacTask;
import com.sun.source.util.Plugin;

/**
 * JavacPlugin
 */
public class JavacPlugin implements Plugin {

    @Override
    public String getName() {
        return "Getter";
    }

    @Override
    public void init(JavacTask task, String... arg1) {
        System.out.println("test");
    }    
}
