package net.trajano.example.jpa;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
public class StartupBean {
	@Inject
	AddEjb addEjb;

	@PostConstruct
	public void doSomething() {
		System.out.println("<<<STARTUP");
		System.out.println(addEjb);
		System.out.println(addEjb.addSomething());
		System.out.println(">>>STARTUP");
	}
}
