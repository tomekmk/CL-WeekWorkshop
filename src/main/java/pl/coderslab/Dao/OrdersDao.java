package pl.coderslab.Dao;

import pl.coderslab.Entity.Orders;
import pl.coderslab.Service.DBService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrdersDao {

    private final String database = "workshop";
    private final String table = "Orders";

    public List<Orders> findAll() {
        String query = "SELECT * FROM " + table + " ORDER BY startDate ASC";

        try {
            List<Map<String, String>> result = DBService.qSelect(database, query, null);

            if (result != null) {
                List<Orders> orders = new ArrayList<>();
                for (Map<String, String> oneOrder : result)
                    orders.add(createOrder(oneOrder));

                return orders;
            }

        } catch (SQLException e) {
            System.out.println("OrdersDao: findAll - ERROR: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("OrdersDao: findAll - ERROR2: " + e.getMessage());
        }
        return null;
    }

    public Orders getOrder(int order_id) {
        String query = "SELECT * FROM " + table + " WHERE order_id=?";
        List<String> parsing = new ArrayList<>();
        parsing.add(String.valueOf(order_id));

        try {
            List<Map<String, String>> result = DBService.qSelect(database, query, parsing);
            Map<String, String> oneOrder = result.get(0);
            Orders order = createOrder(oneOrder);
            return order;
        } catch (SQLException e) {
            System.out.println("OrdersDao: getOrder - ERROR: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("OrdersDao: getOrder - ERROR2: " + e.getMessage());
        }
        return null;
    }

    public Orders createOrder(Map<String, String> oneOrder) throws Exception {
        try {
            Orders order;
            order = new Orders(
                    Integer.parseInt(oneOrder.get("order_id")),
                    Date.valueOf(oneOrder.get("acceptDate")),
                    Date.valueOf(oneOrder.get("plannedDate")),
                    Date.valueOf(oneOrder.get("startDate")),
                    Integer.parseInt(oneOrder.get("employee_id")),
                    oneOrder.get("problemDesc"),
                    oneOrder.get("repairDesc"),
                    Integer.parseInt(oneOrder.get("status")),
                    Integer.parseInt(oneOrder.get("vehicle_id")),
                    Double.parseDouble(oneOrder.get("clientCost")),
                    Double.parseDouble(oneOrder.get("partCost")),
                    Double.parseDouble(oneOrder.get("hoursCost")));
            return order;
        } catch (Exception e) {
            System.out.println("OrdersDao: createOrder - values can be empty: " + e.getMessage());
        }
        return null;
    }

    public int deleteOrder(List<Integer> deleteOrders) {
        String query = "DELETE FROM " + table + " WHERE order_id=?";
        try {
            return DBService.qDelete(database, query, deleteOrders);
        } catch (SQLException e) {
            System.out.println("OrdersDao: deleteOrder - ERROR: " + e.getMessage());
        }
        return 0;
    }


    public boolean addOrder(Orders order) {
        String query = "INSERT INTO " + table + " VALUES(null, ?, ? ,? ,? ,?, ? ,? ,? ,?, ?, ?)";
        try {
            List<String> params = new ArrayList<>();
            params = paramsForAddUpdate(order);

            if (DBService.qInsert(database, query, params) > 0)
                return true;
        } catch (SQLException e) {
            System.out.println("OrdersDao: addOrder - ERROR: " + e.getMessage());
        }

        return false;
    }

    public boolean updateOrder(Orders order) {
        String query = "UPDATE " + table + " SET acceptDate=?, plannedDate=?, startDate=?, employee_id=?, " +
                "problemDesc=?, repairDesc=?, status=?, vehicle_id=?, clientCost=?, partCost=?, hoursCost=? WHERE order_id=?";
        try {
            List<String> params;
            params = paramsForAddUpdate(order);
            params.add(String.valueOf(order.getOrder_id()));

            return DBService.qUpdate(database, query, params);
        } catch (SQLException e) {
            System.out.println("OrdersDao: updateOrder - ERROR: " + e.getMessage());
        }
        return false;
    }

    private List<String> paramsForAddUpdate(Orders order) {
        List<String> params = new ArrayList<>();
        try {
            params.add(order.getAcceptDate().toString());
            params.add(order.getPlannedDate().toString());
            params.add(order.getStartDate().toString());
            params.add(String.valueOf(order.getEmployee().getEmployee_id()));
            params.add(order.getProblemDesc());
            params.add(order.getRepairDesc());
            params.add(String.valueOf(order.getStatus()));
            params.add(String.valueOf(order.getVehicle().getVehicle_id()));
            params.add(String.valueOf(order.getClientCost()));
            params.add(String.valueOf(order.getPartCost()));
            params.add(String.valueOf(order.getHoursCost()));
            return params;
        } catch (Exception e) {
            System.out.println("OrdersDao: paramsForAddUpdate - ERROR: " + e.getMessage());
        }
        return null;
    }

}
