/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.legomanager;

import cz.muni.fi.pa165.legomanager.dao.CategoryDao;
import cz.muni.fi.pa165.legomanager.dao.ModelDao;
import cz.muni.fi.pa165.legomanager.entities.Model;
import javax.sql.DataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 *
 * @author Ondrej Velisek <ondrejvelisek@gmail.com>
 */
@Configuration
@ComponentScan(basePackageClasses={Model.class, ModelDao.class})
public class PersistenceApplicationContext {
		
	/**
	 * Starts up a container that emulates behavior prescribed in JPA spec for container-managed EntityManager
	 * @return
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean  entityManagerFactory(){
		LocalContainerEntityManagerFactoryBean jpaFactoryBean = new LocalContainerEntityManagerFactoryBean ();
		jpaFactoryBean.setDataSource(db());
		//jpaFactoryBean.setLoadTimeWeaver(instrumentationLoadTimeWeaver());
		jpaFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		return jpaFactoryBean;
	}
	
	@Bean
	public DataSource db(){
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.DERBY).build();
		return db;
	}
}