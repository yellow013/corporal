package io.ffreedom.corporal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.FlowLayout;

public class NewGui0 {

	private JFrame mainWingdowd;
	private JTable dataTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewGui0 window = new NewGui0();
					window.mainWingdowd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NewGui0() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainWingdowd = new JFrame();
		mainWingdowd.setBounds(100, 100, 450, 300);
		mainWingdowd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWingdowd.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel topPanel = new JPanel();
		FlowLayout fl_topPanel = (FlowLayout) topPanel.getLayout();
		fl_topPanel.setAlignment(FlowLayout.LEFT);
		mainWingdowd.getContentPane().add(topPanel, BorderLayout.NORTH);
		
		JButton strategyButton = new JButton("策略");
		topPanel.add(strategyButton);
		
		JButton orderButton = new JButton("订单");
		topPanel.add(orderButton);
		
		JButton posButton = new JButton("持仓");
		topPanel.add(posButton);
		
		JPanel centerPanel = new JPanel();
		mainWingdowd.getContentPane().add(centerPanel, BorderLayout.CENTER);
		
		dataTable = new JTable();
		centerPanel.add(dataTable);
	}

}
