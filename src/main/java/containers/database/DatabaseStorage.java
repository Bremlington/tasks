package containers.database;

import collections.List;
import containers.Storage;
import containers.StorageLoadResult;
import containers.StorageSaveResult;
import utilites.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.UUID;

public class DatabaseStorage implements Storage {

    private final Logger logger = LoggerFactory.getLogger(Logger.class);
    private final StorageConfig config;
    private final Serializer serializer = new Serializer();

    public DatabaseStorage(StorageConfig config) {
        this.config = config;
    }

    @Override
    public StorageSaveResult save(List list) {
        String dataList = serializer.serialize(list);

        UUID uuid = UUID.randomUUID();
        String saveQuery = "INSERT INTO list (uuid, data) VALUES ('"+uuid+"','"+dataList+"')";
        try {
            Connection conn = DriverManager.getConnection(config.getConnectionUrl(), config.getLoginPassword());
            PreparedStatement ps = conn.prepareStatement(saveQuery);
            ps.execute();
            conn.close();
            return new StorageSaveResult(true, uuid.toString(), "");
        } catch (SQLException e) {
            String errorMessage = "Error saving to file: "+e;
            logger.error(errorMessage);
            return new StorageSaveResult(false, "", errorMessage);
        }
    }

    @Override
    public StorageLoadResult load(String id, boolean isLinked) {
        String saveQuery = "SELECT data FROM list WHERE uuid = '"+id+"'";
        try {
            Connection conn = DriverManager.getConnection(config.getConnectionUrl(), config.getLoginPassword());
            PreparedStatement ps = conn.prepareStatement(saveQuery);
            ResultSet rs = ps.executeQuery();

            rs.last();
            if(rs.getRow()>1){
                throw new SQLException("Several rows by id "+id);
            }

            String loadResult = rs.getString("data");
            conn.close();

            return new StorageLoadResult(true, serializer.deserialize(loadResult, isLinked), "");
        } catch (SQLException e) {
            String errorMessage = "Error loading from database: "+e;
            logger.error(errorMessage);
            return new StorageLoadResult(false, null, errorMessage);
        }
    }
}
