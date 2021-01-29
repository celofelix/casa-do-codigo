package br.com.zup.casadocodigo.validacao;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = IdValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistID {
	
	String message() default "Informação preenchida não existe, por favor informar outro";
	
	Class<?> [] groups() default { };
	
	Class <? extends Payload> [] payload() default {};
	
	String fieldName();
	
	Class<?> domainClass();
}