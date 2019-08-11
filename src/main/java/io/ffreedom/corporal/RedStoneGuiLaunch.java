package io.ffreedom.corporal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.FlowLayout;

public class RedStoneGuiLaunch {

	private JFrame mainWindow;
	private JTable dataTable;
	private Object[][] dataMod;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> new RedStoneGuiLaunch().mainWindow.setVisible(true));
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
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
		mainWindow.setSize(500, 400);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = mainWindow.getContentPane();
		
		

		JPanel topPanel = new JPanel();
		FlowLayout topPanelFlowLayout = (FlowLayout) topPanel.getLayout();
		topPanelFlowLayout.setAlignment(FlowLayout.LEFT);

		JButton strategyButton = new JButton("策略");
		topPanel.add(strategyButton);

		JButton orderButton = new JButton("订单");
		topPanel.add(orderButton);

		JButton posButton = new JButton("持仓");
		topPanel.add(posButton);

		JButton eventButton = new JButton("事件");
		topPanel.add(eventButton);

		JPanel centerPanel = new JPanel();

		dataMod = new Object[][] {
			{"0000001", "1", "rb1910", "多", "2900", "1200"},
			{"0000002", "2", "ni1910", "多", "36000", "400"},
			{"0000003", "3", "rb1910", "多", "3000", "-800"}
		};

		String[] columnNames = new String[] { "订单号", "OrderRef", "合约", "方向", "价格", "盈亏" };

		dataTable = new JTable(dataMod, columnNames);
		dataTable.setSize(480, 380);
		centerPanel.add(dataTable.getTableHeader(), BorderLayout.NORTH);
		centerPanel.add(dataTable, BorderLayout.CENTER);
		
		
		contentPane.setLayout(new BorderLayout());
		contentPane.setSize(500, 400);
		contentPane.add(topPanel, BorderLayout.NORTH);
		contentPane.add(centerPanel, BorderLayout.CENTER);
	}

}
