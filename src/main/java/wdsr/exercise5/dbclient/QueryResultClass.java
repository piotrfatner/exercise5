package wdsr.exercise5.dbclient;

import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Piotr on 2017-05-30.
 */
public class QueryResultClass {
    private Connection conn;
    private PreparedStatement preparedStatement;
    private org.slf4j.Logger log = LoggerFactory.getLogger(DatabaseGeneratingClass.class);
    public QueryResultClass(Connection conn){
        this.conn = conn;
    }
    public String getQueryResults(){
        String finalResult="";
        int resultNumber = 1;
        List<PreparedStatement> listOfQueries = new ArrayList<>();
        try{
            preparedStatement = conn.prepareStatement(EDatabaseQueries.SELECT_1.getQuery());
            listOfQueries.add(preparedStatement);
            preparedStatement = conn.prepareStatement(EDatabaseQueries.SELECT_2.getQuery());
            listOfQueries.add(preparedStatement);
            preparedStatement = conn.prepareStatement(EDatabaseQueries.SELECT_3.getQuery());
            listOfQueries.add(preparedStatement);
            preparedStatement = conn.prepareStatement(EDatabaseQueries.SELECT_4.getQuery());
            listOfQueries.add(preparedStatement);
            preparedStatement = conn.prepareStatement(EDatabaseQueries.SELECT_5.getQuery());
            listOfQueries.add(preparedStatement);
            preparedStatement = conn.prepareStatement(EDatabaseQueries.SELECT_6.getQuery());
            listOfQueries.add(preparedStatement);
            preparedStatement = conn.prepareStatement(EDatabaseQueries.SELECT_7.getQuery());
            listOfQueries.add(preparedStatement);
            for (PreparedStatement statement:listOfQueries
                 ) {
                ResultSet rs = statement.executeQuery();
                finalResult+="Result of "+resultNumber+" query:\n";

                while (rs.next()){
                    for(int i=1;i<=rs.getMetaData().getColumnCount();i++){
                        finalResult+=rs.getMetaData().getColumnLabel(i)+"="+ rs.getNString(i)+", ";
                    }
                    finalResult+="\n";
                }
                finalResult+="\n\n";
                resultNumber++;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return finalResult;
    }
}
