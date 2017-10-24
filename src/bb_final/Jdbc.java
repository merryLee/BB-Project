package bb_final;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {

	Connection connection;
	Statement statement;
	ResultSet resultSet;

	String driverName = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.12.40:1521:xe";
		
	String user = "BBA";
	String password = "BBA";

	public Jdbc() {

		try {
			// �� �ε�
			Class.forName(driverName);

			// �� ����
			connection = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			System.out.println("[�ε� ����]\n" + e.getStackTrace());
		} catch (SQLException e) {
			System.out.println("[���� ����]\n" + e.getStackTrace());
		}

	}

	public void closeDatabase() {
		try {
			if (connection != null) {
				connection.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			System.out.println("[�ݱ� ����]\n" + e.getStackTrace());
		}
	}
}
