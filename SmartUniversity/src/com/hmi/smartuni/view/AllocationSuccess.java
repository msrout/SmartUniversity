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

public class AllocationSuccess extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -523105008731017841L;
	private JFrame frame;

	public AllocationSuccess(ClassDetailsBean details) {
		getContentPane().setBackground(new Color(245, 245, 245));
		initialize(details);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ClassDetailsBean details) {
		frame = this;
		getContentPane().setLayout(null);

		JLabel lblPageTitle = new JLabel("Classroom Details");
		lblPageTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblPageTitle.setForeground(new Color(100, 149, 237));
		lblPageTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblPageTitle.setBounds(172, 45, 284, 36);
		getContentPane().add(lblPageTitle);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			HomePage hP = new HomePage();
			hP.setVisible(true);
			}
		});
		btnOk.setOpaque(true);
		btnOk.setForeground(Color.WHITE);
		btnOk.setBorderPainted(false);
		btnOk.setBackground(new Color(50, 205, 50));
		btnOk.setBounds(503, 327, 97, 25);
		getContentPane().add(btnOk);

		JLabel lblRoomNo = new JLabel("Room No :");
		lblRoomNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRoomNo.setBounds(175, 109, 110, 16);
		getContentPane().add(lblRoomNo);

		JLabel label = new JLabel("101");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(278, 109, 33, 16);
		getContentPane().add(label);

		JLabel lblBuildingNr = new JLabel("Building:");
		lblBuildingNr.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBuildingNr.setBounds(101, 161, 89, 16);
		getContentPane().add(lblBuildingNr);

		JLabel lblCapacity = new JLabel("Capacity:");
		lblCapacity.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCapacity.setBounds(101, 200, 89, 16);
		getContentPane().add(lblCapacity);

		JCheckBox chckbxSmartLock = new JCheckBox("Smart Lock");
		chckbxSmartLock.setBounds(90, 328, 109, 23);
		chckbxSmartLock.setSelected(details.isSmartLockEnabled());
		chckbxSmartLock.setEnabled(false);
		getContentPane().add(chckbxSmartLock);

		JLabel lblLocationvalue = new JLabel("");
		lblLocationvalue.setText(details.getBuildingNr());
		lblLocationvalue.setBounds(200, 161, 89, 16);
		getContentPane().add(lblLocationvalue);

		JLabel lblCapacityvalue = new JLabel("");
		lblCapacityvalue.setText(details.getCapacity());
		lblCapacityvalue.setBounds(200, 200, 89, 16);
		getContentPane().add(lblCapacityvalue);

		JLabel lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTime.setBounds(101, 242, 89, 16);
		lblTime.setText("Time");
		getContentPane().add(lblTime);

		JLabel lblDays = new JLabel("Days:");
		lblDays.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDays.setBounds(158, 280, 71, 16);
		getContentPane().add(lblDays);

		JLabel lblNewLabel = new JLabel("Allocated Successfully");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(338, 109, 163, 16);
		getContentPane().add(lblNewLabel);

		JLabel labelTimeValue = new JLabel((String) null);
		labelTimeValue.setBounds(200, 242, 89, 16);
		labelTimeValue.setText(details.getTime());
		getContentPane().add(labelTimeValue);

		JLabel labelDaysValue = new JLabel((String) null);
		labelDaysValue.setBounds(230, 280, 89, 16);
		String days = "";
		for (String d:details.getDays()) {
			days = days  + d + "   ";
		}
		
		labelDaysValue.setText(days);
		labelDaysValue.setBounds(239, 280, 334, 16);
		
		getContentPane().add(labelDaysValue);
		
		JLabel labelSubject = new JLabel("Subject:");
		labelSubject.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelSubject.setBounds(358, 161, 89, 16);
		getContentPane().add(labelSubject);
		
		JLabel labelSubjectValue = new JLabel((String) null);
		labelSubjectValue.setBounds(484, 161, 89, 16);
		getContentPane().add(labelSubjectValue);
		labelSubjectValue.setText(details.getSubject());
		
		JLabel lblProfessor = new JLabel("Professor:");
		lblProfessor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProfessor.setBounds(358, 200, 89, 16);
		getContentPane().add(lblProfessor);
		
		JLabel labelProfValue = new JLabel((String) null);
		labelProfValue.setBounds(484, 200, 89, 16);
		labelProfValue.setText(details.getProfessor());
		getContentPane().add(labelProfValue);
		
		JLabel label_1 = new JLabel("SMART UNIVERSITY");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("Dialog", Font.PLAIN, 23));
		label_1.setBounds(198, 11, 249, 36);
		getContentPane().add(label_1);

		frame.setBounds(100, 100, 650, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
