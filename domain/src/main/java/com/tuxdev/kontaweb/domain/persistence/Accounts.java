package com.tuxdev.kontaweb.domain.persistence;

import javax.persistence.*;

/**
 * Created by j.sanchez.chaves on 4/25/2018.
 *
 * KONTA-pom
 */
@Entity
@Table(name="KAccounts"

)
public class Accounts  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="IDAccount", unique=true, nullable=false)
    private Integer idAccount;


    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="FKparent")
    private Accounts parent;


    @Column(name="number", nullable=false)
    private String number;

    @Column(name="Description", nullable=false)
    private String description;

    public Integer getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Integer idAccount) {
        this.idAccount = idAccount;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Accounts getParent() {
        return parent;
    }

    public void setParent(Accounts parent) {
        this.parent = parent;
    }
}
