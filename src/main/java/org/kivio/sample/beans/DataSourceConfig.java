package org.kivio.sample.beans;

import org.h2.jdbcx.JdbcDataSource;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

@ApplicationScoped
public class DataSourceConfig {
    // TODO: make it configurable
    //final static String URL = "jdbc:h2:mem:sample";
    final static String URL = "jdbc:h2:~/.sample/sampleDb";

    @Produces
    @ApplicationScoped
    public DataSource dataSource() {
        final JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUrl(URL);
        return dataSource;
    }
}
