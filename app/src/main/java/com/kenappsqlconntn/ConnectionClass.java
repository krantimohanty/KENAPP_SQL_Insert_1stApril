package com.kenappsqlconntn;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by H-PC on 16-Oct-15.
 */
public class ConnectionClass {

// Working Local IP
//    String ip = "192.168.1.4";
//    String classs = "net.sourceforge.jtds.jdbc.Driver";
//    String db = "induction";
//    String un = "induction";
//    String password = "swash@2015";
//    String in = "SWASHSQLINT";

    // Working Local IP
    String ip = "192.168.1.4";
    String classs = "net.sourceforge.jtds.jdbc.Driver";
    String db = "SwashConvergence";
    String un = "induction";
    String password = "swash@2015";
    String in = "SWASHSQLINT";

//    String db = "SwashConvergence";

//    db : replace Induction to SwashConvergence
//    UserId : induction
//    Password : swash@2015

    // username - kranti
    // password - mohanty

    @SuppressLint("NewApi")
    public Connection CONN() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnURL = null;
        try {

            Class.forName(classs);
//            ConnURL = "jdbc:jtds:sqlserver://" + ip + ";"
//                    + "databaseName=" + db + ";user=" + un + ";password="
//                    + password + ";";
            ConnURL = "jdbc:jtds:sqlserver://" + ip + "/" + db + ";instance=" + in +";user=" + un+ ";password=" + password + ";";
            conn = DriverManager.getConnection(ConnURL);
        } catch (SQLException se) {
            Log.e("ERRO", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERRO", e.getMessage());
        } catch (Exception e) {
            Log.e("ERRO", e.getMessage());
        }
        return conn;
    }
}
