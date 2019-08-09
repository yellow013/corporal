package io.ffreedom.corporal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.FlowLayout;

public class RedStoneGuiLaunch {

	private JFrame mainWindow;
	private JTable dataTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> new RedStoneGuiLaunch().mainWindow.setVisible(true));
	}

	/**
	 * Create the application.
	 */
	public RedStoneGuiLaunch() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainWindow = new JFrame();
		mainWindow.setBounds(100, 100, 450, 300);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel topPanel = new JPanel();
		FlowLayout topPanelFlowLayout = (FlowLayout) topPanel.getLayout();
		topPanelFlowLayout.setAlignment(FlowLayout.LEFT);
		mainWindow.getContentPane().add(topPanel, BorderLayout.NORTH);

		JButton strategyButton = new JButton("策略");
		topPanel.add(strategyButton);

		JButton orderButton = new JButton("订单");
		topPanel.add(orderButton);

		JButton posButton = new JButton("持仓");
		topPanel.add(posButton);

		JPanel centerPanel = new JPanel();
		mainWindow.getContentPane().add(centerPanel, BorderLayout.CENTER);

		dataTable = new JTable();
		centerPanel.add(dataTable);
	}

}
