/**
 * 
 */
package com.skit.compare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class ReadMySQL {

	public long readMySQL() {
		try {
			long startTime = System.currentTimeMillis();
			Class.forName("com.mysql.jdbc.Driver");

			Connection connection = null;
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqltestdb", "root", "root");
			Statement stmt = connection.createStatement();

			ResultSet rs = stmt.executeQuery("select * from student");
			// while (rs.next())
			// System.out.println(rs.getString(1) + " " + rs.getString(2));

			connection.close();
			long endTime = System.currentTimeMillis();
			return endTime - startTime;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}

	public static void main(String args[]) {

		ReadMySQL r = new ReadMySQL();

		System.out.println("Time taken for  querying" + r.readMySQL());
	}
}
