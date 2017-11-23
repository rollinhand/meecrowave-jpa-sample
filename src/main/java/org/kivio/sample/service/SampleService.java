package org.kivio.sample.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.kivio.sample.beans.InstrumentDao;
import org.kivio.sample.entity.Instrument;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@ApplicationScoped
@Path("api")
public class SampleService {
    private Logger log = LogManager.getLogger(SampleService.class);

    @Inject
    private InstrumentDao instrumentDao;

    @GET
    @Path("status")
    public String getStatus() {
        return "Running";
    }

    @POST
    @Path("instrument")
    public Instrument addInstrument(@QueryParam("isin") String isin) {
        Instrument i = new Instrument(isin, null);
        instrumentDao.save(i);
        return i;
    }
}
