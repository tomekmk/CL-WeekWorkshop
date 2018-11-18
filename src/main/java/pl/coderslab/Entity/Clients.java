package pl.coderslab.Entity;

import java.sql.Date;

public class Clients {

    private Integer client_id;
    private String name, surname;
    private Date dateOfBirth;

    public Clients(Integer client_id, String name, String surname, Date dateOfBirth) {
        setClient_id(client_id);
        setName(name);
        setSurname(surname);
        setDateOfBirth(dateOfBirth);
    }

    public Clients() {

    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
