package containerInitializer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.servlet.annotation.WebInitParam;

/**
 * Essa anotacao devera ser utilizada em servlets que devem ser adicionadas
 * programaticamente na inicializacao do container em um
 * ServletContainerInitializer.
 * 
 * @author Matheus
 * 
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ReadOnInit {

	WebInitParam[] initParams() default {};

	String[] urlPatterns() default {};

}
