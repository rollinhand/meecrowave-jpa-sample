package org.kivio.sample.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class InstrumentId {
    private String isin;

    public InstrumentId() {}

    public InstrumentId(String isin) {
        this.isin = isin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        InstrumentId that = (InstrumentId) o;

        return new EqualsBuilder()
                .append(isin, that.isin)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(isin)
                .toHashCode();
    }
}
