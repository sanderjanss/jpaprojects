package com.switchfullywork.jpaprojects.basic.codelab01.be.switchfully.country;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

public class Country {

    private String countryName;

    public Country(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public boolean equals(Object other){
        return EqualsBuilder.reflectionEquals(this, other);
    }

    @Override
    public int hashCode(){
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
    }
}
