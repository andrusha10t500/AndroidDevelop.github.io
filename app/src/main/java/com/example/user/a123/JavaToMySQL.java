package com.example.user.a123;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JavaToMySQL extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
    }

    public void onClick3(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Сообщение");
        builder.setMessage(FromMySQL.main());
        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }
}

class FromMySQL {

    private static final String url = "jdbc:mysql://192.168.0.11:3306/smsapp";
    private static final String user = "root";
    private static final String password = "qt67uy";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static String main(){
        String query = "SELECT * FROM sms";
        String result = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url,user,password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while(rs.next()){
                int count = rs.getInt(1);

            }
            result = "Всё в порядке";
        } catch (SQLException e) {
            result=e.getMessage();
        } catch (ClassNotFoundException ex) {
            result=result + " ClassNotFoundException " + ex.getMessage();
        } catch (IllegalAccessException ep) {
            result = result + ' ' + ep.getMessage();
        } catch (InstantiationException en) {
            result = result + ' ' + en.getMessage();
        }
        return result;
    }

}
