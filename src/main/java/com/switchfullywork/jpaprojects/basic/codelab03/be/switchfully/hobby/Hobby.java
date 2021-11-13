package com.switchfullywork.jpaprojects.basic.codelab03.be.switchfully.hobby;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

import java.util.Objects;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

@Entity
@Table(name = "hobby")
public class Hobby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hobby_id")
    private int hobbyId;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;

    public Hobby(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Hobby() {
    }

    public int getId() {
        return hobbyId;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

//    @Override
//    public String toString() {
//        return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
//    }


    @Override
    public String toString() {
        return "Hobby{" +
                "hobbyId=" + hobbyId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hobby hobby = (Hobby) o;
        return Objects.equals(name, hobby.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
