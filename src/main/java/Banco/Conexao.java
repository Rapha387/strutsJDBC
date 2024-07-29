package Banco;

//import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public DataSource dataSource;

    public Conexao(){
//        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
//        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/strutsjdbc?useTimezone=true&serverTimezone=UTC");
//        comboPooledDataSource.setUser("root");
//        comboPooledDataSource.setPassword("root");

//        this.dataSource = comboPooledDataSource;
    }

    public static Connection getConnection() throws SQLException {
        //return dataSource.getConnection();

        return DriverManager.getConnection(
                "jdbc:mysql://localhost/strutsjdbc?useTimezone=true&serverTimezone=UTC",
                "root",
                "root");
    }
}