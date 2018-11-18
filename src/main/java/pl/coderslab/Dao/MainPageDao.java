package pl.coderslab.Dao;

import pl.coderslab.Service.DBService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainPageDao {
    private final String database = "workshop";

    public int count(String table) {
        String qCountFromTables = "SELECT count(*) as count FROM " + table;

        try {
            List<Map<String, String>> result = DBService.qSelect(database, qCountFromTables, null);

            if (result != null)
                return Integer.parseInt(result.get(0).get("count"));
        } catch (SQLException e) {
            System.out.println("MainPageDao: count - ERROR: " + e.getMessage());
        }
        return -1;
    }
}
