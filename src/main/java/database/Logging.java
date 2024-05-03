package database;

import model.Log;
import utils.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Logging {
    public static int insert(Log log){
        try {
            Connection con = JDBC.getConnection();
            String sql = "insert into logs (action, table_name , level, before_data, after_data, user_name, log_time)  values (?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setNString(1, log.getAction());
            pst.setNString(2, log.getTable());
            pst.setNString(3, log.getLevel());
            pst.setNString(4, log.getBeforeData());
            pst.setNString(5, log.getAfterData());
            pst.setNString(6, log.getUser());
            pst.setNString(7, log.getTime());

            int i = pst.executeUpdate();
            if (i > 0) {
                return i;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static void update(Log log){

    }
    public static void delete(Log log){

    }
}
