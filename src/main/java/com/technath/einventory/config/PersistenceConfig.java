package com.technath.einventory.config;

import java.sql.SQLException;
import java.util.Properties;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@Configuration
@EnableTransactionManagement
public class PersistenceConfig {

	private static Logger log = LoggerFactory.getLogger(PersistenceConfig.class);




	@Bean(name = "JPAEINVENTORY")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException, SQLException {
		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		entityManager.setPackagesToScan(new String[] { "com.technath.einventory.dao","com.technath.einventory.entity"  });	      
		entityManager.setDataSource(eInventoryDataSource());
		entityManager.setPersistenceUnitName("EINVENTORY_DB_JPA");
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		entityManager.setJpaVendorAdapter(vendorAdapter);
		entityManager.setPersistenceProviderClass(HibernatePersistence.class);
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.DB2Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		//	      properties.setProperty("jboss.entity.manager.jndi.name", "java:/jdbc/razzeldazzel");
		//	      properties.setProperty("jboss.entity.manager.factory.jndi.name", "java:/razzeldazzel_DB_JPAFactory");
		//	      properties.setProperty("hibernate.transaction.jta.platform", "org.hibernate.service.jta.platform.internal.JBossAppServerJtaPlatform" );                        
		entityManager.setJpaProperties(properties);
		System.out.println("created LocalContainerEntityManagerFactoryBean");
		return entityManager;
	}	  
	@Bean(name = "inventoryDataSource")
	public DataSource eInventoryDataSource() throws SQLException {
		DataSource dataSource= null;
		JndiTemplate jndi = new JndiTemplate();
		try {
			dataSource = (DataSource) jndi.lookup("java:comp/env/jdbc/razzeldazzel");
		} catch (NamingException e) {
			System.out.println("NamingException for java:/comp/env/jdbc/razzeldazzel");
			e.printStackTrace();
		}
		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager() throws NamingException, SQLException{
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(
				entityManagerFactory().getObject() );
		return transactionManager;
	}
	
//	@Bean 
//	public EntityManager getEntityManager(){
//		EntityManager manager = entityManagerFactory()
//		return 
//	}



}

