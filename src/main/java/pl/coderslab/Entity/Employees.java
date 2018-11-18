package pl.coderslab.Entity;

public class Employees {

    private Integer employee_id;
    private String name;
    private String surname;
    private String street;
    private String city;
    private String telephone;
    private String note;
    private Double hourCost = 0.0;

    public Employees(Integer employee_id, String name, String surname, String street, String city, String telephone, String note, Double hourCost) {
        setEmployee_id(employee_id);
        setName(name);
        setSurname(surname);
        setStreet(street);
        setCity(city);
        setTelephone(telephone);
        setNote(note);
        setHourCost(hourCost);
    }

    public Employees() {

    }

    public Integer getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Integer employee_id) {
        this.employee_id = employee_id;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Double getHourCost() {
        return hourCost;
    }

    public void setHourCost(Double hourCost) {
        this.hourCost = hourCost;
    }
}
