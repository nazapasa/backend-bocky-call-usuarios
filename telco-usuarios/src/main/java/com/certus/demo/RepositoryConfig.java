package com.certus.demo;

import com.certus.demo.model.entity.Role;
import com.certus.demo.model.entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.support.Repositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;


@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer{
	@Autowired
	private Repositories repositories;

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		this.repositories.iterator().forEachRemaining(r -> {
			config.exposeIdsFor(r);
		});
	}
}
