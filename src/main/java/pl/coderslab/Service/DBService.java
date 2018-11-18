package pl.coderslab.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBService {
    public static Connection connect(String database) throws SQLException {
        String username = "root";
        String password = "coderslab";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/" + database + "?useUnicode=yes&characterEncoding=UTF-8" +
                        "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                username,
                password);
    }

    public static List<Map<String, String>> qSelect(String database, String query, List<String> params) throws SQLException {
        List<Map<String, String>> dbResult = new ArrayList<>();

        try (Connection conn = connect(database)) {
            PreparedStatement prepQuery = conn.prepareStatement(query);

            if (params != null) {
                for (int i = 0; i < params.size(); i++) {
                    prepQuery.setString(i + 1, params.get(i));
                }
            }

            ResultSet rs = prepQuery.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int colsFromQuery = rsmd.getColumnCount();

            while (rs.next()) {
                Map<String, String> rows = new HashMap<>();

                for (int i = 1; i <= colsFromQuery; i++) {
                    rows.put(rsmd.getColumnName(i), rs.getString(i));
                }
                dbResult.add(rows);
            }

            if (!dbResult.isEmpty())
                return dbResult;

        } catch (Exception e) {
            System.out.println("DBService: qSelect - ERROR: " + e.getMessage());
        }
        return null;
        //jeżeli wynik zapytania jest pusty, zwróci nulla
    }

    public static Integer qInsert(String database, String query, List<String> params) throws SQLException {
        try (Connection conn = connect(database)) {
            PreparedStatement prepQuery = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            if (params != null) {
                for (int i = 0; i < params.size(); i++) {
                    prepQuery.setString(i + 1, params.get(i));
                }
            }

            prepQuery.executeUpdate();

            try (ResultSet generatedKeys = prepQuery.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            } catch (SQLException e) {
                System.out.println("DBService: qInsert - ERROR while getting generated keys: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("DBService: qInsert - ERROR: " + e.getMessage());
        }
        System.out.println("DBService: qInsert - no generated keys");
        return -1;
        //zwraca wygenerowane id nowego wiersza
    }

    public static int qDelete(String database, String query, List<Integer> params) throws SQLException {
        int counter = 0;
        try (Connection conn = connect(database)) {
            PreparedStatement prepQuery = conn.prepareStatement(query);

            if (params != null) {
                for (int i = 0; i < params.size(); i++) {
                    prepQuery.setInt(1, params.get(i));
                    if (prepQuery.executeUpdate() > 0)
                        counter++;
                }
            }
        } catch (SQLException e) {
            System.out.println("DBService: qDelete - ERROR: " + e.getMessage());
        }
        return counter;
        //zwraca ilość usuniętych wierszy
    }

    public static boolean qUpdate(String database, String query, List<String> params) throws SQLException {

        try (Connection conn = connect(database)) {
            PreparedStatement prepQuery = conn.prepareStatement(query);

            if (params != null) {
                for (int i = 0; i < params.size(); i++) {
                    prepQuery.setString(i + 1, params.get(i));
                }

                if (prepQuery.executeUpdate() > 0)
                    return true;
            }
        } catch (SQLException e) {
            System.out.println("DBService: qUpdate - ERROR: " + e.getMessage());
        }
        return false;
    }
}
