package com.hmi.smartuni.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
//import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class HomePage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 753846743192708150L;
	private JFrame frame;

	public HomePage() {
		getContentPane().setForeground(new Color(100, 149, 237));
		getContentPane().setBackground(new Color(245, 245, 245));
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = this;
		getContentPane().setLayout(null);

		JLabel lblFraUas = new JLabel("SMART UNIVERSITY HOMEPAGE");
		lblFraUas.setFont(new Font("Lucida Grande", Font.PLAIN, 23));
		lblFraUas.setForeground(new Color(0, 0, 255));
		lblFraUas.setHorizontalAlignment(SwingConstants.CENTER);
		lblFraUas.setBounds(54, 51, 314, 36);
		getContentPane().add(lblFraUas);

		JRadioButton rdbtnManageClassroom = new JRadioButton("Allocate and Manage Classrooms");
  	   rdbtnManageClassroom.setBackground(new Color(255, 222, 173));
		rdbtnManageClassroom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnManageClassroom.setForeground(new Color(0, 0, 0));
		rdbtnManageClassroom.setBounds(51, 114, 271, 23);

		getContentPane().add(rdbtnManageClassroom);

		JRadioButton rdbtnViewAndSet = new JRadioButton("View and set classroom properties");
		rdbtnViewAndSet.setBackground(new Color(255, 222, 173));
		rdbtnViewAndSet.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnViewAndSet.setBounds(51, 170, 271, 23);
		getContentPane().add(rdbtnViewAndSet);

		JButton btnOk = new JButton("OK");
		btnOk.setBackground(new Color(0, 255, 0));
		btnOk.setBounds(353, 223, 64, 29);
		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if (rdbtnManageClassroom.isSelected()) {
					frame.setVisible(false);
					ClassroomManagement classroomManagement = new ClassroomManagement();
					classroomManagement.setVisible(true);
				}

			}
		});
		getContentPane().add(btnOk);

		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				LoginPage loginFrame = new LoginPage();
				loginFrame.setVisible(true);
			}
		});

		// Group the radio buttons.
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnManageClassroom);
		group.add(rdbtnViewAndSet);

		btnLogout.setBackground(new Color(255, 222, 173));
		btnLogout.setBounds(353, 0, 83, 23);
		btnLogout.setOpaque(true);
		btnLogout.setBorderPainted(false);
		getContentPane().add(btnLogout);
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblFraUas, rdbtnManageClassroom, rdbtnViewAndSet, btnOk, btnLogout}));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
