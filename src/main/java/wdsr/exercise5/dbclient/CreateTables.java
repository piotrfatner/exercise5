package wdsr.exercise5.dbclient;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Created by Piotr on 2017-05-29.
 */
public class CreateTables {
    private Connection conn;
    private PreparedStatement preparedStatement;
    private org.slf4j.Logger log = LoggerFactory.getLogger(CreateTables.class);
    public CreateTables(Connection conn){
        this.conn = conn;
    }
    public void createTables(){
        try {
            preparedStatement = conn.prepareStatement(EDatabaseQueries.CREATE_TABLE_STUDENT.getQuery());
            preparedStatement.execute();
            preparedStatement = conn.prepareStatement(EDatabaseQueries.CREATE_TABLE_FACULTY.getQuery());
            preparedStatement.execute();
            preparedStatement = conn.prepareStatement(EDatabaseQueries.CREATE_TABLE_CLASS.getQuery());
            preparedStatement.execute();
            System.out.println("Table was created!");
            System.out.println("Table was created!");
            log.info("Table was created!");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
