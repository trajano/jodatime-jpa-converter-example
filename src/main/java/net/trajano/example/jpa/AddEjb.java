package net.trajano.example.jpa;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

@Stateless
public class AddEjb {
	@PersistenceContext
	EntityManager em;

	public BeanWithJodaTime addSomething() {
		final BeanWithJodaTime entity = new BeanWithJodaTime();
		entity.javaUtilDate = new Date();
		entity.localDateTime = LocalDateTime.now();
		entity.localDate = LocalDate.now();
		em.persist(entity);
		em.flush();
		return entity;
	}

	public List<BeanWithJodaTime> listAll() {
		return em.createNamedQuery("listall", BeanWithJodaTime.class)
				.getResultList();
	}
}
