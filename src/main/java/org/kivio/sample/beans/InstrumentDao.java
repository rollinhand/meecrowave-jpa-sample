package org.kivio.sample.beans;

import org.apache.meecrowave.jpa.api.Jpa;
import org.apache.meecrowave.jpa.api.Unit;
import org.kivio.sample.entity.Instrument;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
@Jpa(transactional = false)
public class InstrumentDao {
    @Inject
    @Unit(name = "sample")
    private EntityManager em;

    @Jpa
    public void save (Instrument instrument) {
        em.merge(instrument);
    }

    public Instrument find(final String isin) {
        return em.find(Instrument.class, isin);
    }

    public List<Instrument> findAll() {
        return em.createNamedQuery("Instrument.findAll", Instrument.class)
                .getResultList();
    }
}
