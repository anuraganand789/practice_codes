import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.Messager;

import javax.lang.model.element.Element;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;

import javax.tools.Diagnostic.Kind;

import java.util.Set;

public class BasicProcessor extends AbstractProcessor{

    
    private Messager              messager;
    private ProcessingEnvironment processingEnv;

    @Override
    public void init(final ProcessingEnvironment processingEnv){
        super.init(processingEnv);

        this.processingEnv = processingEnv;

        final var messagerLocal =  processingEnv.getMessager();
        this.messager       = messagerLocal;

        final SourceVersion sourceVersion = processingEnv.getSourceVersion();
        System.out.println("**" + sourceVersion.latest() + "**");
        System.out.println("Preview is enabled **" + processingEnv.isPreviewEnabled() + "**");
        System.out.println("Init happened");
        System.out.println(processingEnv.getOptions());
        //messagerLocal.printMessage(Kind.ERROR, "***Just A testing for error");
    }

    @Override 
    public boolean process(final Set<? extends TypeElement> annotations,
                        final RoundEnvironment roundEnv){
        System.out.println("****************START********************");
        for(final var typeElement : annotations){
            System.out.println("Type Annotations " + typeElement.getQualifiedName());
            System.out.println("Type Kind " + typeElement.asType().getKind());
        }


        System.out.println("process called");
        System.out.println("Error Raised **" + roundEnv.errorRaised() + "**");
        final Set<? extends Element> elementsAnnotatedWithOverride =
        roundEnv.getElementsAnnotatedWith(Override.class);

        System.out.println("Number of elements annotated with 'Override' " + elementsAnnotatedWithOverride.size());

        final boolean processingOver = roundEnv.processingOver();
        System.out.println("*Processing Over " + processingOver);
        System.out.println("****************END********************");
        return true;
    }

    @Override
    public SourceVersion getSupportedSourceVersion(){
        return SourceVersion.latest();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes(){
        return Set.of("*");
    }

}
