package pl.coderslab.Entity;

import pl.coderslab.Dao.EmployeesDao;
import pl.coderslab.Dao.VehiclesDao;

import java.sql.Date;


public class Orders {

    private Integer order_id = 0;
    private Date acceptDate;
    private Date plannedDate;
    private Date startDate;
    private Employees employee;
    private String problemDesc;
    private String repairDesc;
    private Integer status = 0;
    private Vehicles vehicle;
    private Double clientCost = 0.0;
    private Double partCost = 0.0;
    private Double hoursCost = 0.0;

    public Orders(Integer order_id, Date acceptDate, Date plannedDate, Date startDate,
                  Integer employee, String problemDesc, String repairDesc, Integer status, Integer vehicle,
                  Double clientCost, Double partCost, Double hoursCost) {
        setOrder_id(order_id);
        setAcceptDate(acceptDate);
        setPlannedDate(plannedDate);
        setStartDate(startDate);
        setEmployee(employee);
        setProblemDesc(problemDesc);
        setRepairDesc(repairDesc);
        setStatus(status);
        setVehicle(vehicle);
        setClientCost(clientCost);
        setPartCost(partCost);
        setHoursCost(hoursCost);
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Date getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(Date acceptDate) {
        this.acceptDate = acceptDate;
    }

    public Date getPlannedDate() {
        return plannedDate;
    }

    public void setPlannedDate(Date plannedDate) {
        this.plannedDate = plannedDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Integer employee) {
        EmployeesDao employeesDao = new EmployeesDao();
        this.employee = employeesDao.getEmployee(employee);
    }

    public String getProblemDesc() {
        return problemDesc;
    }

    public void setProblemDesc(String problemDesc) {
        this.problemDesc = problemDesc;
    }

    public String getRepairDesc() {
        return repairDesc;
    }

    public void setRepairDesc(String repairDesc) {
        this.repairDesc = repairDesc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Vehicles getVehicle() {
        return vehicle;
    }

    public void setVehicle(Integer vehicle) {
        VehiclesDao vehiclesDao = new VehiclesDao();
        this.vehicle = vehiclesDao.getVehicle(vehicle);
    }

    public Double getClientCost() {
        return clientCost;
    }

    public void setClientCost(Double clientCost) {
        this.clientCost = clientCost;
    }

    public Double getPartCost() {
        return partCost;
    }

    public void setPartCost(Double partCost) {
        this.partCost = partCost;
    }

    public Double getHoursCost() {
        return hoursCost;
    }

    public void setHoursCost(Double hoursCost) {
        this.hoursCost = hoursCost;
    }
}