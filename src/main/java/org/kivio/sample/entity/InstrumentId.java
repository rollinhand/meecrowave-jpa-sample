package org.kivio.sample.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class InstrumentId {
    private String isin;

    public InstrumentId() {}
}
