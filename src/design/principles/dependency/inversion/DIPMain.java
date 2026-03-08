package design.principles.dependency.inversion;

public class DIPMain {
    public static void main(String[] args) {

        DatabaseController oracleDatabaseController = new DatabaseController(new OracleDatabase());
        oracleDatabaseController.connect();
        oracleDatabaseController.disconnect();

        DatabaseController mySQLDatabaseController = new DatabaseController(new MySQLDatabase());
        mySQLDatabaseController.connect();
        mySQLDatabaseController.disconnect();

    }
}
