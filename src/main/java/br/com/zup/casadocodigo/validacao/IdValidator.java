package br.com.zup.casadocodigo.validacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;

public class IdValidator implements ConstraintValidator<ExistID, Object> {

	private String attribute;
    private Class<?> classe;
    private String message;
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(ExistID params) {
        attribute = params.fieldName();
        classe = params.domainClass();
        message = params.message();
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext constraintValidatorContext) {
        if(obj == null){
            return true;
        }

        Query query = entityManager.createQuery("select 1 from " + classe.getName() + " where "
                + attribute + "=:value");
        query.setParameter("value", obj);
        List<?> list = query.getResultList();
        Assert.state(list.size() <= 1, "Encontramos mais de um(a) " + classe
                + " com o dado informado, por favor informar outro " + attribute + " = " + obj);

        return !list.isEmpty();
    }

}
