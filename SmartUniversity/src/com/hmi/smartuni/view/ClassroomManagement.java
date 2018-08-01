package com.hmi.smartuni.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;

public class ClassroomManagement extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -652020187593335498L;
	private JFrame frame;
	private JTextField textField;

	public ClassroomManagement() {
		getContentPane().setBackground(new Color(245, 245, 245));
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = this;
		getContentPane().setLayout(null);

		JLabel lblFraUas = new JLabel("SMART UNIVERSITY");
		lblFraUas.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		lblFraUas.setForeground(new Color(0, 0, 255));
		lblFraUas.setHorizontalAlignment(SwingConstants.CENTER);
		lblFraUas.setBounds(195, 18, 249, 36);
		getContentPane().add(lblFraUas);

		JLabel lblPageTitle = new JLabel("Classroom Management");
		lblPageTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblPageTitle.setForeground(new Color(100, 149, 237));
		lblPageTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPageTitle.setBounds(175, 52, 284, 36);
		getContentPane().add(lblPageTitle);

		JLabel lblRoomRequirements = new JLabel("Please enter the requirements of the room needed:");
		lblRoomRequirements.setFont(new Font("Calibri", Font.BOLD, 13));
		lblRoomRequirements.setBounds(21, 98, 296, 22);
		getContentPane().add(lblRoomRequirements);

		JLabel lblNewLabel = new JLabel("Room Capacity :\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(21, 131, 105, 14);
		getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(136, 128, 36, 19);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblDay = new JLabel("Day :");
		lblDay.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDay.setBounds(21, 175, 50, 14);
		getContentPane().add(lblDay);

		JCheckBox chckbxMonday = new JCheckBox("Monday");
		chckbxMonday.setBounds(86, 174, 86, 16);
		getContentPane().add(chckbxMonday);

		JCheckBox chckbxTuesday = new JCheckBox("Tuesday");
		chckbxTuesday.setBounds(175, 174, 86, 16);
		getContentPane().add(chckbxTuesday);

		JCheckBox chckbxWednesday = new JCheckBox("Wednesday");
		chckbxWednesday.setBounds(283, 174, 103, 16);
		getContentPane().add(chckbxWednesday);

		JCheckBox chckbxThursday = new JCheckBox("Thursday");
		chckbxThursday.setBounds(388, 174, 102, 16);
		getContentPane().add(chckbxThursday);

		JCheckBox chckbxFriday = new JCheckBox("Friday");
		chckbxFriday.setBounds(504, 174, 105, 16);
		getContentPane().add(chckbxFriday);

		JLabel lblNewLabel_1 = new JLabel("Timeslot :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(21, 227, 67, 14);
		getContentPane().add(lblNewLabel_1);
		Date date = new Date();
		SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
		JSpinner labelTime = new JSpinner(sm);
		JSpinner.DateEditor de = new JSpinner.DateEditor(labelTime, "HH:mm");
		labelTime.setEditor(de);
		labelTime.setBounds(136, 220, 130, 26);
		labelTime.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
		getContentPane().add(labelTime);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(50, 205, 50));
		btnSearch.setForeground(new Color(255, 255, 255));
		btnSearch.setBounds(465, 305, 79, 29);
		btnSearch.setOpaque(true);
		btnSearch.setBorderPainted(false);
		getContentPane().add(btnSearch);
		

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				HomePage hP = new HomePage();
				hP.setVisible(true);
			}
		});
		btnBack.setOpaque(true);
		btnBack.setForeground(Color.WHITE);
		btnBack.setBorderPainted(false);
		btnBack.setBackground(new Color(50, 205, 50));
		btnBack.setBounds(554, 305, 72, 29);
		getContentPane().add(btnBack);
		
		JLabel lblInvalidData = new JLabel("Invalid data");
		lblInvalidData.setForeground(new Color(220, 20, 60));
		lblInvalidData.setBounds(37, 291, 135, 16);
		lblInvalidData.setVisible(false);
		getContentPane().add(lblInvalidData);
		
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String capacity = textField.getText();
				ArrayList<String> days = new ArrayList<String>();
				if (chckbxMonday.isSelected()) 
					days.add("Monday");
				if (chckbxTuesday.isSelected())
					days.add("Tuesday");
				if (chckbxWednesday.isSelected())
					days.add("Wednesday");
				if (chckbxThursday.isSelected())
					days.add("Thursday");
				if (chckbxFriday.isSelected())
					days.add("Friday");
				
				
				ClassDetailsBean details = new ClassDetailsBean();
				details.setDays(days);
				if (capacity.matches("[0-9]+") && capacity.length() > 0 && !days.isEmpty()) {
					frame.setVisible(false);
					
					String m= labelTime.getValue().toString();
		             String t= m.substring(11, 16);
					details.setTime(t);
					
					
					ClassroomList classroomlist = new ClassroomList(details);
					classroomlist.setVisible(true);
					
				}else {
					lblInvalidData.setVisible(true);
				}

			}
		});

		frame.setBounds(100, 100, 650, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
