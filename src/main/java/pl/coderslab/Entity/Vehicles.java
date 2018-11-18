package pl.coderslab.Entity;

import pl.coderslab.Dao.ClientsDao;

import java.sql.Date;

public class Vehicles {

    private Integer vehicle_id;
    private String mark;
    private String model;
    private Integer yearOfProduction;
    private String registNumber;
    private Date nextReview;
    private Clients client;

    public Vehicles(Integer vehicle_id, String mark, String model, Integer yearOfProduction, String registNumber, Date nextReview, Integer client_id) {
        setVehicle_id(vehicle_id);
        setMark(mark);
        setModel(model);
        setYearOfProduction(yearOfProduction);
        setRegistNumber(registNumber);
        setNextReview(nextReview);
        setClient(client_id);
    }

    public Vehicles() {

    }

    public Integer getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(Integer vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYearOfProduction() {
        return String.valueOf(yearOfProduction);
    }

    public void setYearOfProduction(Integer yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getRegistNumber() {
        return registNumber;
    }

    public void setRegistNumber(String registNumber) {
        this.registNumber = registNumber;
    }

    public Date getNextReview() {
        return nextReview;
    }

    public void setNextReview(Date nextReview) {
        this.nextReview = nextReview;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Integer client_id) {
        ClientsDao clientsDao = new ClientsDao();
        this.client = clientsDao.getClient(client_id);
    }
}