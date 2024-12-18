import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.UUID;

public class DatabaseStorage implements Storage{

    final private String connectionUrl = "jdbc:mysql://localhost:3306/list?serverTimezone=UTC";
    private final Logger logger = LoggerFactory.getLogger(Logger.class);
    private String username = "username";
    private String password = "password";

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String save(List list) {
        Serializer serializer = new Serializer();
        String dataList = serializer.SerializeList(list);

        UUID uuid = UUID.randomUUID();
        String saveQuery = "INSERT INTO list (uuid, data) VALUES ('"+uuid+"','"+dataList+"')";
        try {
            Connection conn = DriverManager.getConnection(connectionUrl, username, password);
            Statement st = conn.createStatement();
            int res = st.executeUpdate(saveQuery);
            if(res==1){
                return uuid.toString();
            } else {
                logger.error("Error saving to database");
                return "";
            }
        } catch (SQLException e) {
            logger.error("Error saving to database: "+e);
            return "";
        }
    }

    @Override
    public List load(String id, boolean isLinked) {
        String loadResult = "";

        String saveQuery = "SELECT data FROM list WHERE uuid = '"+id+"'";
        try (Connection conn = DriverManager.getConnection(connectionUrl, username, password);
             PreparedStatement ps = conn.prepareStatement(saveQuery);
             ResultSet rs = ps.executeQuery()) {

            if(rs.next()){
                loadResult = rs.getString("data");
            }
        } catch (SQLException e) {
            logger.error("Error saving to database: "+e);
        }

        Serializer serializer = new Serializer();
        if(isLinked){
            return serializer.DeserializeAsCustomLinkedList(loadResult);
        } else {
            return serializer.DeserializeAsCustomList(loadResult);
        }
    }
}
