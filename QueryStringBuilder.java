import java.net.URLDecoder;
import java.net.URLEncoder;

import java.util.HashMap;
import java.util.Map;


public class QueryStringBuilder {
    private Map<String, String> parameters = new HashMap<String, String>();
    
    public QueryStringBuilder() {
    }
    
    public QueryStringBuilder(String queryString) {
        
        if(queryString == null || queryString.trim().length() == 0) {
            return;
        }
        
        String [] params = queryString.split("[&;]");
        for(String p : params) {
            String [] parts = p.split("=");
            if(parts.length == 2) {
                parameters.put(parts[0], URLDecoder.decode(parts[1]));
            }
        }        
    }
    
    public void put(String key, Object value) {
        parameters.put(key, value == null ? null : value.toString());
    }
    
    public void remove(String key) {
        parameters.remove(key);
    }

    public String get(String key) {
        return parameters.get(key);
    }
    
    public boolean contains(String key) {
        return parameters.containsKey(key);
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(String key : parameters.keySet()) {
            String value = parameters.get(key);
            if(value != null && value.trim().length() > 0) {
                if(sb.length() > 0) {
                    sb.append("&");
                }
                sb.append(key).append("=").append(value == null ? "" : URLEncoder.encode(value));
            }
        }
        return sb.toString();
    }
}
