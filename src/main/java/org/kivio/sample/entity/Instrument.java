package org.kivio.sample.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Represents a single instrument (security, bond, equity).
 *
 * @author Björn Berg, rollin.hand@gmx.de
 */
@Getter
@Setter
@Entity
@NamedQueries({
        @NamedQuery(name = "Instrument.findAll", query = "SELECT i FROM Instrument i")
})
public class Instrument {
    @EmbeddedId
    private InstrumentId instrumentId;
    private String name;

    public Instrument() {

    }

    public Instrument(String isin, String name) {
        this.instrumentId = new InstrumentId(isin);
        this.name = name;
    }
}
