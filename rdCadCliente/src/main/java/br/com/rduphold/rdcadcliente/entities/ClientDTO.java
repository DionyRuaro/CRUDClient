package br.com.rduphold.rdcadcliente.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class ClientDTO implements Serializable {

    private Long id;
    private String name;
    private String cpf;
    private Double income;
    private Instant birthDate;
    private Integer children;

    public ClientDTO(){
    }


    public ClientDTO(Long id, String name, String cpf, Double income, Instant birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public ClientDTO(Client cli) {
        this.id = cli.getId();
        this.name = cli.getName();
        this.cpf = cli.getCpf();
        this.income = cli.getIncome();
        this.birthDate = cli.getBirthDate();
        this.children = cli.getChildren();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDTO client = (ClientDTO) o;
        return Objects.equals(id, client.id) && Objects.equals(name, client.name) && Objects.equals(cpf, client.cpf) && Objects.equals(income, client.income) && Objects.equals(birthDate, client.birthDate) && Objects.equals(children, client.children);
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public Instant getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Instant birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }
}
