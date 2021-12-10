package com.victor.cuentadigital.config;

import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

@Component
public class DatasourceConfig {

    @Bean(name = "dataSource")
    public DriverManagerDataSource datasource() {
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setDriverClassName("org.h2.Driver");
        datasource.setUrl("jdbc:h2:~/Downloads/pruebaGyF/cuenta-digital-backend/cuenta_digital_db");
        datasource.setUsername("sa");
        datasource.setPassword("P@ssw0rd01");

        Resource resource = new ClassPathResource("data.sql");
        DatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        DatabasePopulatorUtils.execute(databasePopulator, datasource);

        return datasource;
    }
}
