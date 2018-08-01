package com.hmi.smartuni.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

public class ClassroomDetails extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7990998687126124482L;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private ClassDetailsBean details;

	public ClassroomDetails(ClassDetailsBean details) {
		getContentPane().setBackground(new Color(245, 245, 245));
		this.details = details;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = this;
		getContentPane().setLayout(null);

		JLabel lblPageTitle = new JLabel("Classroom Details");
		lblPageTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblPageTitle.setForeground(new Color(100, 149, 237));
		lblPageTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPageTitle.setBounds(159, 41, 284, 36);
		getContentPane().add(lblPageTitle);

		JButton btnAllocate = new JButton("Allocate");
		btnAllocate.setBackground(new Color(50, 205, 50));
		btnAllocate.setForeground(new Color(255, 255, 255));
		btnAllocate.setBounds(407, 318, 84, 29);
		btnAllocate.setOpaque(true);
		btnAllocate.setBorderPainted(false);

		getContentPane().add(btnAllocate);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);
				ClassDetailsBean d = new ClassDetailsBean();
				d.setDays(details.getDays());
				d.setTime(details.getTime());
				ClassroomList cList = new ClassroomList(d);
				cList.setVisible(true);
			
			}
		});
		btnBack.setOpaque(true);
		btnBack.setForeground(Color.WHITE);
		btnBack.setBorderPainted(false);
		btnBack.setBackground(new Color(50, 205, 50));
		btnBack.setBounds(501, 318, 89, 29);
		getContentPane().add(btnBack);
		

		JLabel lblRoomNo = new JLabel("Room No :");
		lblRoomNo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRoomNo.setBounds(237, 88, 74, 16);
		getContentPane().add(lblRoomNo);

		JLabel label = new JLabel(details.getRoomNo());
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(318, 88, 74, 16);
		getContentPane().add(label);

		JLabel lblBuildingNr = new JLabel("Building:");
		lblBuildingNr.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBuildingNr.setBounds(78, 132, 89, 16);
		getContentPane().add(lblBuildingNr);

		JLabel lblCapacity = new JLabel("Capacity:");
		lblCapacity.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCapacity.setBounds(78, 173, 89, 16);
		getContentPane().add(lblCapacity);

		JCheckBox chckbxSmartLock = new JCheckBox("Smart Lock");
		chckbxSmartLock.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxSmartLock.setBounds(79, 294, 109, 23);
		getContentPane().add(chckbxSmartLock);

		JLabel lblLocationvalue = new JLabel("");
		lblLocationvalue.setText(details.getBuildingNr());
		lblLocationvalue.setBounds(195, 132, 89, 16);
		getContentPane().add(lblLocationvalue);

		JLabel lblCapacityvalue = new JLabel("");
		lblCapacityvalue.setText(details.getCapacity());
		lblCapacityvalue.setBounds(195, 173, 89, 16);
		getContentPane().add(lblCapacityvalue);

		JLabel lblSubject = new JLabel("Subject:");
		lblSubject.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSubject.setBounds(78, 212, 89, 16);
		getContentPane().add(lblSubject);

		JLabel lblProfessor = new JLabel("Professor");
		lblProfessor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProfessor.setBounds(78, 255, 89, 16);
		getContentPane().add(lblProfessor);

		textField = new JTextField();
		textField.setBounds(195, 210, 130, 16);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(195, 260, 130, 16);
		getContentPane().add(textField_1);
		
		JLabel label_1 = new JLabel("SMART UNIVERSITY");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 23));
		label_1.setBounds(184, 11, 249, 36);
		getContentPane().add(label_1);

		btnAllocate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				details.setSubject(textField.getText());
				details.setProfessor(textField_1.getText());
				details.setSmartLockEnabled(chckbxSmartLock.isSelected());
				AllocationSuccess successFrame = new AllocationSuccess(details);
				successFrame.setVisible(true);

			}
		});

		frame.setBounds(100, 100, 650, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
