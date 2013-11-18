import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DatabaseGUI extends JFrame {
	public JPanel connectPanel;
	public JPanel querySelectionPanel;
	
	Connection con;
	
	public DatabaseGUI() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		querySelectionPanel = new JPanel();
		buildQuerySelectionsPane();
		this.getContentPane().add(querySelectionPanel);
		this.setSize(256, 256);
		this.setVisible(true);
	}

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		new DatabaseGUI();
	}

	private void connect() throws SQLException {
		String url = "jdbc:mysql://cs336-6.cs.rutgers.edu:3306/csuser";
		con = DriverManager.getConnection(url, "csuser", "csd1993c");
	}

	private void buildQuerySelectionsPane() {
		String[] queryNames = { "Query 1", "Query 2" };
		JComboBox<String> queryList = new JComboBox<String>(queryNames);
		querySelectionPanel.add(queryList);
	}
}
