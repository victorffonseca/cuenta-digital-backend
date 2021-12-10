package com.victor.cuentadigital.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cuenta_ahorros")
public class CuentaAhorros {

    @Id
    private Long id;

    private Integer clave;
    private BigDecimal balance;
    private Boolean estado;

    @OneToOne(targetEntity = Persona.class, cascade = CascadeType.PERSIST)
    private Persona persona;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getClave() {
        return clave;
    }

    public void setClave(Integer clave) {
        this.clave = clave;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
