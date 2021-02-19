package br.com.zup.desafio1.casadocodigo.compartilhado;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(value = {ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueValuesValidator.class)
public @interface UniqueValues {

    Class<?> domainClass();

    String[] fields();

    String[] aliases();

    String message() default "Error unique values";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
