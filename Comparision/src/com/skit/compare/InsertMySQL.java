package com.skit.compare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

import com.pojo.Student;

public class InsertMySQL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		InsertMySQL i = new InsertMySQL();
		System.out.println(i.insertMySQL(500));

	}

	public long insertMySQL(int n) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqltestdb", "root", "root");
			con.createStatement().execute("delete from student");
			long st = System.currentTimeMillis();

			for (int i = 1; i <= n; i++) {
				PreparedStatement ps = con.prepareStatement("insert into STUDENT values ( ?,?) ");
				ps.setString(1, "1VK06IS0" + i);
				ps.setString(2, "Student" + i);
				ps.execute();
			}
			long en = System.currentTimeMillis();
			return en - st;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}

	}
}
