package pl.coderslab.Dao;

import pl.coderslab.Entity.Clients;
import pl.coderslab.Service.DBService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClientsDao {

    private final String database = "workshop";
    private final String table = "Clients";

    public List<Clients> findAll() {
        String query = "SELECT * FROM " + table;

        try {
            List<Map<String, String>> result = DBService.qSelect(database, query, null);

            if (result != null) {
                List<Clients> clients = new ArrayList<>();
                for (Map<String, String> oneClient : result)
                    clients.add(createClient(oneClient));

                return clients;
            }

        } catch (SQLException e) {
            System.out.println("ClientsDao: findAll - ERROR: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ClientsDao: findAll - ERROR2: " + e.getMessage());
        }
        return null;
    }

    public Clients getClient(int client_id) {
        String query = "SELECT * FROM " + table + " WHERE client_id=?";
        List<String> parsing = new ArrayList<>();
        parsing.add(String.valueOf(client_id));

        try {
            List<Map<String, String>> result = DBService.qSelect(database, query, parsing);
            Map<String, String> oneClient = result.get(0);

            Clients client = createClient(oneClient);

            return client;
        } catch (SQLException e) {
            System.out.println("ClientsDao: getClient - ERROR: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ClientsDao: getClient - ERROR2: " + e.getMessage());
        }
        return null;
    }

    public Clients createClient(Map<String, String> oneClient) throws Exception {
        try {
            Clients client;
            client = new Clients(
                    Integer.parseInt(oneClient.get("client_id")),
                    oneClient.get("name"),
                    oneClient.get("surname"),
                    Date.valueOf(oneClient.get("dateOfBirth")));
            return client;
        } catch (Exception e) {
            System.out.println("ClientsDao: createClient - ERROR: " + e.getMessage());
        }
        return null;
    }

    public int deleteClient(List<Integer> deleteClients) {
        String query = "DELETE FROM " + table + " WHERE client_id=?";

        try {
            return DBService.qDelete(database, query, deleteClients);
        } catch (Exception e) {
            System.out.println("ClientsDao: deleteClient - ERROR: " + e.getMessage());
        }
        return 0;
    }


    public boolean addClient(Clients client) {
        String query = "INSERT INTO " + table + " VALUES(null, ?, ? ,?)";
        try {
            List<String> params = new ArrayList<>();
            params = paramsForAddUpdate(client);
            if (DBService.qInsert(database, query, params) > 0)
                return true;
        } catch (Exception e) {
            System.out.println("ClientsDao: addClient - ERROR: " + e.getMessage());
        }
        return false;
    }

    public boolean updateClient(Clients client) {
        String query = "UPDATE " + table + " SET name=?, surname=?, dateOfBirth=? WHERE client_id=?";
        try {
            List<String> params = new ArrayList<>();
            params = paramsForAddUpdate(client);
            params.add(String.valueOf(client.getClient_id()));

            if (DBService.qUpdate(database, query, params))
                return true;
        } catch (Exception e) {
            System.out.println("ClientDao: updateClient - ERROR: " + e.getMessage());
        }
        return false;
    }

    private List<String> paramsForAddUpdate(Clients client) {
        List<String> params = new ArrayList<String>();

        params.add(client.getName());
        params.add(client.getSurname());
        params.add(client.getDateOfBirth().toString());

        return params;
    }
}
