package pl.coderslab.Dao;

import pl.coderslab.Entity.Vehicles;
import pl.coderslab.Service.DBService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VehiclesDao {

    private final String database = "workshop";
    private final String table = "Vehicles";

    public List<Vehicles> findAll() {
        String query = "SELECT * FROM " + table;

        try {
            List<Map<String, String>> result = DBService.qSelect(database, query, null);

            if (result != null) {
                List<Vehicles> vehicles = new ArrayList<Vehicles>();
                for (Map<String, String> oneVehicle : result) {
                    vehicles.add(createVehicle(oneVehicle));
                }
                return vehicles;
            }

        } catch (SQLException e) {
            System.out.println("VehiclesDao: findAll - ERROR: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("VehiclesDao: findAll - ERROR2: " + e.getMessage());
        }
        return null;
    }

    public Vehicles getVehicle(int vehicle_id) {
        String query = "SELECT * FROM " + table + " WHERE vehicle_id=?";
        List<String> parsing = new ArrayList<>();
        parsing.add(String.valueOf(vehicle_id));

        try {
            List<Map<String, String>> result = DBService.qSelect(database, query, parsing);
            Map<String, String> oneVehicle = result.get(0);
            Vehicles vehicle = createVehicle(oneVehicle);
            return vehicle;
        } catch (SQLException e) {
            System.out.println("VehiclesDao: getVehicle - ERROR: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("VehiclesDao: getVehicle - ERROR2: " + e.getMessage());
        }
        return null;
    }

    public Vehicles createVehicle(Map<String, String> oneVehicle) throws Exception {
        try {
            Vehicles vehicle;
            vehicle = new Vehicles(
                    Integer.parseInt(oneVehicle.get("vehicle_id")),
                    oneVehicle.get("mark"),
                    oneVehicle.get("model"),
                    Integer.parseInt(oneVehicle.get("yearOfProduction")),
                    oneVehicle.get("registNumber"),
                    Date.valueOf(oneVehicle.get("nextReview")),
                    Integer.parseInt(oneVehicle.get("client_id")));
            return vehicle;
        } catch (Exception e) {
            System.out.println("VehicleDao: addVehicle - values can be empty: " + e.getMessage());
        }
        return null;
    }

    public int deleteVehicle(List<Integer> deleteVehicles) {
        String query = "DELETE FROM " + table + " WHERE vehicle_id=?";
        try {
            return DBService.qDelete(database, query, deleteVehicles);
        } catch (SQLException e) {
            System.out.println("VehiclesDao: deleteVehicle - ERROR: " + e.getMessage());
        }
        return 0;
    }

    public boolean addVehicle(Vehicles vehicle) {
        String query = "INSERT INTO " + table + " VALUES(null, ?, ? ,? ,? ,? ,?)";
        try {
            List<String> params;
            params = paramsForAddUpdate(vehicle);

            if (DBService.qInsert(database, query, params) > 0)
                return true;
        } catch (SQLException e) {
            System.out.println("VehiclesDao: addVehicle - ERROR: " + e.getMessage());
        }
        return false;
    }

    public boolean updateVehicle(Vehicles vehicle) {
        String query = "UPDATE " + table + " SET mark=?, model=?, yearOfProduction=?, " +
                "registNumber=?, nextReview=?, client_id=? WHERE vehicle_id=?";
        try {
            List<String> params;
            params = paramsForAddUpdate(vehicle);
            params.add(String.valueOf(vehicle.getVehicle_id()));

            return DBService.qUpdate(database, query, params);
        } catch (SQLException e) {
            System.out.println("VehiclesDao: updateVehicle - ERROR: " + e.getMessage());
        }
        return false;
    }

    private List<String> paramsForAddUpdate(Vehicles vehicle) {
        List<String> params = new ArrayList<>();
        try {
            params.add(vehicle.getMark());
            params.add(vehicle.getModel());
            params.add(String.valueOf(vehicle.getYearOfProduction()));
            params.add(vehicle.getRegistNumber());
            params.add(vehicle.getNextReview().toString());
            params.add(String.valueOf(vehicle.getClient().getClient_id()));
            return params;
        } catch (Exception e) {
            System.out.println("VehiclesDao: paramsForAddUpdate - ERROR: " + e.getMessage());
        }
        return null;
    }
}
