package br.com.zup.casadocodigo.validacao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.casadocodigo.modelo.Estado;
import br.com.zup.casadocodigo.modelo.Pais;
import br.com.zup.casadocodigo.modelo.form.CompraForm;

@Component
public class EstadoPertenceAoPaisValidator implements Validator {

	@PersistenceContext
	EntityManager em;

	@Override
	public boolean supports(Class<?> clazz) {
		return CompraForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		CompraForm request = (CompraForm) target;
		Pais pais = em.find(Pais.class, request.getIdPais());
		Estado estado = null;
		if (request.getIdEstado() != null) {
			estado = em.find(Estado.class, request.getIdEstado());
			if (!estado.pertenceAPais(pais)) {
				errors.rejectValue("idEstado", null,
						"Este estado não pertence ao país informado, favor informar outro");
			}
		}

	}

}
