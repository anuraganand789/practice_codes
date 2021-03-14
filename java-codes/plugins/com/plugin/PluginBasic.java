package com.plugin;

import com.sun.source.util.Plugin;
import com.sun.source.util.JavacTask;
import com.sun.source.util.TaskListener;
import com.sun.source.util.TaskEvent;

import static com.sun.source.util.TaskEvent.Kind;

public class PluginBasic implements Plugin {
    
    public static void main(final String... args){
        System.out.println(new PluginBasic().getName());
    }

    @Override
    public String getName() { 
        return "TestPlugin" ; 
    } 

    @Override
    public void init(final JavacTask javaCTask, String ... args){
        final JavacTaskListener javacTaskListener = this.new JavacTaskListener();
        javaCTask.addTaskListener(javacTaskListener);
    }

    private class JavacTaskListener implements TaskListener{

        @Override
        public void finished(final TaskEvent taskEvent){
           System.out.println("Finished " + taskEvent.getKind());
        }

        @Override
        public void started(final TaskEvent taskEvent){
           System.out.println("Started " + taskEvent.getKind());
        }

    }
}

