package org.example.app_a.config;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.store.jdbc.JDBCPersistenceAdapter;
import org.apache.activemq.store.jdbc.adapter.MySqlJDBCAdapter;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ActiveMQConfig {

    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Bean
    public BrokerService brokerService() throws Exception {
        BrokerService broker = new BrokerService();
        broker.setBrokerName("my-broker");       // Give a unique name to your broker
        broker.addConnector(brokerUrl);          // Set the broker URL
        broker.setPersistent(true);              // Enable persistence

        // Configure JDBC persistence adapter
        JDBCPersistenceAdapter persistenceAdapter = new JDBCPersistenceAdapter();
        persistenceAdapter.setDataSource(mysqlDataSource()); // Set MySQL DataSource
        persistenceAdapter.setAdapter(new MySqlJDBCAdapter()); // Use MySQL-specific adapter

        broker.setPersistenceAdapter(persistenceAdapter);
        return broker;
    }

    @Bean
    public DataSource mysqlDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUsername);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }
}
