package ru.gavrilov.core.abstracts;

import javax.annotation.Nonnull;
import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class Human {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "date_birth")
    private Date dateOfBrith;

    @Column(name = "sex")
    private Boolean sex;

    @Column (name="age")
    private Integer age;

    public Human() {
    }

    //Надо уточнить
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Nonnull
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Nonnull
    public Date getDateOfBrith() {
        return dateOfBrith;
    }

    public void setDateOfBrith(Date dateOfBrith) {
        this.dateOfBrith = dateOfBrith;
    }

    @Nonnull
    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    @Nonnull
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
