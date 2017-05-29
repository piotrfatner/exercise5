package wdsr.exercise5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import wdsr.exercise5.dbclient.CreateTables;
import wdsr.exercise5.hsqldb.MyHsqlServer;

import java.sql.*;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private static Connection connection = null;

	public static void main(String[] args) throws InterruptedException {
		MyHsqlServer dbServer = new MyHsqlServer(9001, "test-db", "mem:test-db");
		dbServer.start();
		log.info("Database started");
		try {
			connection = DriverManager.getConnection("jdbc:hsqldb:hsql://127.0.0.1:9001/test-db", "SA", "");
			CreateTables createTables = new CreateTables(connection);
			createTables.createTables();
			DatabaseMetaData databaseMetaData = connection.getMetaData();
			ResultSet tableNames = databaseMetaData.getTables(null, null, null, new String[]{"TABLE"});
			while(tableNames.next()){
				System.out.println("tableName: "+ tableNames.getString(3));
			}
		}catch (SQLException e){
			log.info("something went wrong!");
		}
	}
}
