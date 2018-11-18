package pl.coderslab.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ParamsService {

    public static Map<String, String> getParams(HttpServletRequest request) {

        Map<String, String[]> parameters = new HashMap<>();
        Map<String, String> params = new HashMap<>();

        parameters = request.getParameterMap();
        for (String value : parameters.keySet())
            params.put(value, parameters.get(value)[0]);

        return params;
    }
}
