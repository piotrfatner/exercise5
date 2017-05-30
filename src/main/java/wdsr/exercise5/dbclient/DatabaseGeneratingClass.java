package wdsr.exercise5.dbclient;

import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Created by Piotr on 2017-05-29.
 */
public class DatabaseGeneratingClass {
    private Connection conn;
    private PreparedStatement preparedStatement;
    private org.slf4j.Logger log = LoggerFactory.getLogger(DatabaseGeneratingClass.class);
    public DatabaseGeneratingClass(Connection conn){
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
            preparedStatement = conn.prepareStatement(EDatabaseQueries.CREATE_TABLE_ENROLLMENT.getQuery());
            preparedStatement.execute();
            log.info("Table was created!");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertValues(){
        try{
            //Inserting students
            preparedStatement = conn.prepareStatement(EDatabaseQueries.STUDENT_INSERT_1.getQuery());
            preparedStatement.execute();
            preparedStatement = conn.prepareStatement(EDatabaseQueries.STUDENT_INSERT_2.getQuery());
            preparedStatement.execute();
            preparedStatement = conn.prepareStatement(EDatabaseQueries.STUDENT_INSERT_3.getQuery());
            preparedStatement.execute();
            preparedStatement = conn.prepareStatement(EDatabaseQueries.STUDENT_INSERT_4.getQuery());
            preparedStatement.execute();

            //Inserting faculties
            preparedStatement = conn.prepareStatement(EDatabaseQueries.FACULTY_INSERT_1.getQuery());
            preparedStatement.execute();
            preparedStatement = conn.prepareStatement(EDatabaseQueries.FACULTY_INSERT_2.getQuery());
            preparedStatement.execute();
            preparedStatement = conn.prepareStatement(EDatabaseQueries.FACULTY_INSERT_3.getQuery());
            preparedStatement.execute();
            preparedStatement = conn.prepareStatement(EDatabaseQueries.FACULTY_INSERT_4.getQuery());
            preparedStatement.execute();

            //Inserting classes
            preparedStatement = conn.prepareStatement(EDatabaseQueries.CLASS_INSERT_1.getQuery());
            preparedStatement.execute();
            preparedStatement = conn.prepareStatement(EDatabaseQueries.CLASS_INSERT_2.getQuery());
            preparedStatement.execute();
            preparedStatement = conn.prepareStatement(EDatabaseQueries.CLASS_INSERT_3.getQuery());
            preparedStatement.execute();
            preparedStatement = conn.prepareStatement(EDatabaseQueries.CLASS_INSERT_4.getQuery());
            preparedStatement.execute();
            preparedStatement = conn.prepareStatement(EDatabaseQueries.CLASS_INSERT_5.getQuery());
            preparedStatement.execute();

            //Inserting enrollments
            preparedStatement = conn.prepareStatement(EDatabaseQueries.ENROLLMENT_INSERT_1.getQuery());
            preparedStatement.execute();
            preparedStatement = conn.prepareStatement(EDatabaseQueries.ENROLLMENT_INSERT_2.getQuery());
            preparedStatement.execute();
            preparedStatement = conn.prepareStatement(EDatabaseQueries.ENROLLMENT_INSERT_3.getQuery());
            preparedStatement.execute();
            preparedStatement = conn.prepareStatement(EDatabaseQueries.ENROLLMENT_INSERT_4.getQuery());
            preparedStatement.execute();
            preparedStatement = conn.prepareStatement(EDatabaseQueries.ENROLLMENT_INSERT_5.getQuery());
            preparedStatement.execute();
            preparedStatement = conn.prepareStatement(EDatabaseQueries.ENROLLMENT_INSERT_6.getQuery());
            preparedStatement.execute();
            preparedStatement = conn.prepareStatement(EDatabaseQueries.ENROLLMENT_INSERT_7.getQuery());
            preparedStatement.execute();
            preparedStatement = conn.prepareStatement(EDatabaseQueries.ENROLLMENT_INSERT_8.getQuery());
            preparedStatement.execute();
            preparedStatement = conn.prepareStatement(EDatabaseQueries.ENROLLMENT_INSERT_9.getQuery());
            preparedStatement.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
