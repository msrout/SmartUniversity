package com.hmi.smartuni.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;


public class ClassroomList extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1200019503525287712L;


	private JFrame frame;
	private DefaultTableModel classroomListModel;
	private JTable classroomTable;

	
	/**
	 * Create the application.
	 */
	public ClassroomList(ClassDetailsBean details) {
		getContentPane().setBackground(new Color(245, 245, 245));
		initialize(details);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param details 
	 */
	private void initialize(ClassDetailsBean details) {
		frame = this;
		getContentPane().setLayout(null);
		
		JLabel lblPageTitle = new JLabel("Classroom Management");
		lblPageTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblPageTitle.setForeground(new Color(100, 149, 237));
		lblPageTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPageTitle.setBounds(166, 45, 284, 36);
		getContentPane().add(lblPageTitle);
		
		
		JButton btnView = new JButton("View");
		btnView.setBackground(new Color(50, 205, 50));
		btnView.setForeground(new Color(255, 255, 255));
		btnView.setBounds(206, 323, 86, 29);
		btnView.setOpaque(true);
		btnView.setBorderPainted(false);
		btnView.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				viewDetails(details);
				
			}
		});
		getContentPane().add(btnView);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ClassroomManagement cM = new ClassroomManagement();
				cM.setVisible(true);
			}
		});
		btnBack.setOpaque(true);
		btnBack.setForeground(Color.WHITE);
		btnBack.setBorderPainted(false);
		btnBack.setBackground(new Color(50, 205, 50));
		btnBack.setBounds(343, 323, 86, 29);
		getContentPane().add(btnBack);
		
		
		String[] columnNames = { "Nr",

				"Room No", "Capacity", };
		classroomListModel = new DefaultTableModel(columnNames, 0){
		      /**
			 * 
			 */
			private static final long serialVersionUID = 1269882475020580314L;

			public boolean isCellEditable(int rowIndex, int mColIndex) {
		          return false;
		        }
		      };
		/**/

		classroomTable = new JTable(classroomListModel);
		JScrollPane scrollPane = new JScrollPane(classroomTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		populateclassroomTable();
		classroomTable.setFillsViewportHeight(true);
		classroomTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
		
		this.setLocationRelativeTo(null);

		scrollPane.setPreferredSize(new Dimension(200, 100));
		scrollPane.setBounds(124, 92, 397, 208);
		this.getContentPane().add(scrollPane);
		
		JLabel label = new JLabel("SMART UNIVERSITY");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Dialog", Font.PLAIN, 23));
		label.setBounds(195, 11, 249, 36);
		getContentPane().add(label);

		
		frame.setBounds(100, 100, 650, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void populateclassroomTable() {
		classroomListModel.addRow(new Object[] { "1", "101",
				"22" });
		classroomListModel.addRow(new Object[] { "2", "111",
		"32" });
		classroomListModel.addRow(new Object[] { "3", "201",
		"41" });
		classroomListModel.addRow(new Object[] { "4", "404",
		"32" });
		classroomListModel.addRow(new Object[] { "5", "301",
		"50" });
		classroomListModel.addRow(new Object[] { "6", "221",
		"42" });
		classroomListModel.addRow(new Object[] { "7", "334",
		"40" });
		classroomListModel.addRow(new Object[] { "8", "248",
		"60" });
		classroomListModel.addRow(new Object[] { "9", "121",
		"30" });
		classroomListModel.addRow(new Object[] { "10", "256",
		"20" });
		classroomListModel.addRow(new Object[] { "11", "356",
		"20" });
		classroomListModel.addRow(new Object[] { "12", "306",
		"60" });
		classroomListModel.addRow(new Object[] { "13", "001",
		"80" });
		classroomListModel.addRow(new Object[] { "14", "326",
		"40" });
		classroomListModel.addRow(new Object[] { "15", "407",
		"50" });
		
	}
	
	private void viewDetails(ClassDetailsBean details) {
		int selectedRow = classroomTable.getSelectedRow();
		if (selectedRow < 0)
			return;
		String roomNo = (classroomTable.getValueAt(selectedRow, 1)).toString();
		char buildingNr = roomNo.charAt(0) ;
		details.setBuildingNr(Character.toString(buildingNr));
		details.setRoomNo(roomNo);
		details.setCapacity(classroomTable.getValueAt(selectedRow, 2).toString());
		
		this.setVisible(false);
		ClassroomDetails roomDetails = new ClassroomDetails(details);
		roomDetails.setVisible(true);
		
		
	}
}
