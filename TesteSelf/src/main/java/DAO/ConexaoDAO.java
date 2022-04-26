package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoDAO {

	public Connection conectaBD() throws SQLException {
		
        String connectionUrl = "jdbc:sqlserver://testeselfsolutions.database.windows.net:1433;databaseName=Teste Self Solutions;user=luizfelipe;password=testeluiz123@";


        Connection con = DriverManager.getConnection(connectionUrl);

        return con;
        }
	}


