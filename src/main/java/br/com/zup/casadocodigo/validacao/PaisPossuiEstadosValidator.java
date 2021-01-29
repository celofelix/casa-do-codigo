package br.com.zup.casadocodigo.validacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.casadocodigo.modelo.Pais;
import br.com.zup.casadocodigo.modelo.form.CompraForm;

@Component
public class PaisPossuiEstadosValidator implements Validator {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean supports(Class<?> clazz) {
		return CompraForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {		
		CompraForm request = (CompraForm) target;
		
		if(errors.hasErrors() || request.getIdEstado() != null) {
			return;
		}
		
		Pais pais = em.find(Pais.class, request.getIdPais());
		
		Query query = em.createQuery("SELECT e FROM Estado e WHERE e.pais = :idPais");
		query.setParameter("idPais", pais);
		List<?> lista = query.getResultList();
		
		if(lista.size() > 0) {
			errors.rejectValue("idEstado", null, "O Estado é necessário para o País informado, por favor informar o Estado");
		}		
	}
}
