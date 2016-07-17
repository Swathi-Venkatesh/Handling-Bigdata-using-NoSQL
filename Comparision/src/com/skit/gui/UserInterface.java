package com.skit.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.skit.compare.InsertMongo;
import com.skit.compare.InsertMySQL;
import com.skit.compare.ReadMongo;
import com.skit.compare.ReadMySQL;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserInterface extends JFrame {

	private JPanel contentPane;
	private JTextField records;
	private JTextField mongowrite;
	private JTextField mysqlwrite;
	private JTextField mongoread;
	private JTextField mysqlread;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface frame = new UserInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserInterface() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 746, 436);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblAshokKumarLearnng = new JLabel("Sri Krishna Institute of Technology (SKIT)");
		lblAshokKumarLearnng.setBounds(227, 29, 235, 14);
		panel.add(lblAshokKumarLearnng);

		JLabel lblMongoDbVs = new JLabel("Mongo DB vs MySQL (Speed Comparision)");
		lblMongoDbVs.setBounds(227, 54, 235, 14);
		panel.add(lblMongoDbVs);

		JButton btnCompare = new JButton("COMPARE");
		btnCompare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String n = records.getText();
				InsertMongo i = new InsertMongo();
				InsertMySQL i2 = new InsertMySQL();
				ReadMongo r = new ReadMongo();
				ReadMySQL r2 = new  ReadMySQL();
				long writemongo = i.insertMongo(Integer.parseInt(n));
				long writemysql = i2.insertMySQL(Integer.parseInt(n));
				long readmysql = r2.readMySQL();
				long readmongo = r.readMongo();

				mongoread.setText(readmysql + " ms");
				mongowrite.setText(writemongo + " ms");
				mysqlread.setText(readmongo + " ms");
				mysqlwrite.setText(writemysql + " ms");

			}
		});
		btnCompare.setBounds(285, 140, 89, 23);
		panel.add(btnCompare);

		records = new JTextField();
		records.setBounds(255, 108, 146, 20);
		panel.add(records);
		records.setColumns(10);

		JLabel lblEnterTheNumber = new JLabel("Enter the number of records");
		lblEnterTheNumber.setBounds(255, 83, 164, 14);
		panel.add(lblEnterTheNumber);

		JLabel lblWriteOperation = new JLabel("WRITE OPERATION");
		lblWriteOperation.setBounds(73, 240, 152, 14);
		panel.add(lblWriteOperation);

		JLabel lblReadOperation = new JLabel("READ OPERATION");
		lblReadOperation.setBounds(430, 240, 152, 14);
		panel.add(lblReadOperation);

		JLabel lblMongodb = new JLabel("MongoDB");
		lblMongodb.setBounds(73, 285, 68, 14);
		panel.add(lblMongodb);

		JLabel lblMysql = new JLabel("MySQL");
		lblMysql.setBounds(73, 310, 68, 14);
		panel.add(lblMysql);

		mongowrite = new JTextField();
		mongowrite.setEditable(false);
		mongowrite.setBounds(133, 282, 86, 20);
		panel.add(mongowrite);
		mongowrite.setColumns(10);

		mysqlwrite = new JTextField();
		mysqlwrite.setEditable(false);
		mysqlwrite.setBounds(133, 310, 86, 20);
		panel.add(mysqlwrite);
		mysqlwrite.setColumns(10);

		JLabel label = new JLabel("MySQL");
		label.setBounds(430, 313, 68, 14);
		panel.add(label);

		JLabel label_1 = new JLabel("MongoDB");
		label_1.setBounds(430, 288, 68, 14);
		panel.add(label_1);

		mongoread = new JTextField();

		mongoread.setEditable(false);
		mongoread.setColumns(10);
		mongoread.setBounds(490, 285, 86, 20);
		panel.add(mongoread);

		mysqlread = new JTextField();
		mysqlread.setEditable(false);
		mysqlread.setColumns(10);
		mysqlread.setBounds(490, 313, 86, 20);
		panel.add(mysqlread);
	}
}
