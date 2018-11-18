package pl.coderslab.Service;

public class InitService {

    private final String createDb = "CREATE SCHEMA workshop";

    private final String createTableClients = "CREATE TABLE workshop.Clients\n" +
            "(\n" +
            "    client_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,\n" +
            "    name varchar(50),\n" +
            "    surname varchar(50),\n" +
            "    dateOfBirth date\n" +
            ")";

    private final String createTableVehicles = "CREATE TABLE workshop.Vehicles\n" +
            "(\n" +
            "    vehicle_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,\n" +
            "    mark varchar(255),\n" +
            "    model varchar(255),\n" +
            "    yearOfProduction int,\n" +
            "    registNumber varchar(20),\n" +
            "    nextReview date,\n" +
            "    client_id int,\n" +
            "    CONSTRAINT Vehicles_Clients_client_id_fk FOREIGN KEY (client_id) REFERENCES Clients (client_id)\n" +
            ")";

    private final String createTableEmployees = "CREATE TABLE workshop.Employees\n" +
            "(\n" +
            "  employee_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,\n" +
            "  name varchar(50),\n" +
            "  surname varchar(50),\n" +
            "  street varchar(50),\n" +
            "  city varchar(50),\n" +
            "  telephone varchar(50),\n" +
            "  note text,\n" +
            "  hourCost double\n" +
            ");";

    private final String createTableOrders = "CREATE TABLE workshop.Orders\n" +
            "(\n" +
            "  order_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,\n" +
            "  acceptDate date,\n" +
            "  plannedDate date,\n" +
            "  startDate date,\n" +
            "  employee_id int,\n" +
            "  problemDesc text,\n" +
            "  repairDesc text,\n" +
            "  status int,\n" +
            "  vehicle_id int,\n" +
            "  clientCost double,\n" +
            "  partCost double,\n" +
            "  hoursCost double,\n" +
            "  CONSTRAINT Orders_Vehicles_vehicle_id_fk FOREIGN KEY (vehicle_id) REFERENCES Vehicles (vehicle_id),\n" +
            "    CONSTRAINT Orders_Employees_employee_id_fk FOREIGN KEY (employee_id) REFERENCES Employees (employee_id)\n" +
            ")";
}
