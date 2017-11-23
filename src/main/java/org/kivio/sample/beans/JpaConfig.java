package org.kivio.sample.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.meecrowave.jpa.api.PersistenceUnitInfoBuilder;
import org.kivio.sample.entity.Instrument;
import org.kivio.sample.entity.InstrumentId;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

@ApplicationScoped
public class JpaConfig {
    private Logger log = LogManager.getLogger(JpaConfig.class);

    @Produces
    public PersistenceUnitInfoBuilder unit(final DataSource ds) {
        log.info("creating PersistenceUnitInfoBuilder...");
        return new PersistenceUnitInfoBuilder()
                .setUnitName("sample")
                .setDataSource(ds)
                .setExcludeUnlistedClasses(true)
                .addManagedClazz(Instrument.class)
                .addManagedClazz(InstrumentId.class)
                .addProperty("openjpa.RuntimeUnenhancedClasses", "unsupported")
                .addProperty("openjpa.jdbc.SynchronizeMappings", "buildSchema")
                .addProperty("openjpa.Log", "DefaultLevel=INFO, Runtime=TRACE, Tool=TRACE, SQL=TRACE");
    }
}
