package io.ffreedom.corporal;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Launch {
	private static JTable table;
	public static void main(String[] args) {
		System.out.println(new File(".").getAbsolutePath());
		JFrame frame = new TabbedPaneFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		table = new JTable();
		frame.getContentPane().add(table, BorderLayout.WEST);
		frame.setVisible(true);
	}
}

class TabbedPaneFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -888670680904631824L;

	public TabbedPaneFrame() {
		setTitle("RedStone策略管理系统");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		tabbedPane = new JTabbedPane();

		ImageIcon icon = new ImageIcon("./chapter6/TabbedPaneTest/yellow-ball.gif");
		tabbedPane.addTab("策略", icon, null);
		tabbedPane.addTab("订单", icon, null);
		tabbedPane.addTab("持仓", icon, null);

		add(tabbedPane, "Center");
		tabbedPane.addChangeListener((ChangeEvent event) -> {
			if (tabbedPane.getSelectedComponent() == null) {
				int n = tabbedPane.getSelectedIndex();
				loadTab(n);
			}
		});
		loadTab(0);
		JPanel buttonPanel = new JPanel();
		ButtonGroup buttonGroup = new ButtonGroup();
		JRadioButton wrapButton = new JRadioButton("Wrap tabs");
		wrapButton.addActionListener((ActionEvent event) -> {
			tabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
		});
		buttonPanel.add(wrapButton);
		buttonGroup.add(wrapButton);
		wrapButton.setSelected(true);
		JRadioButton scrollButton = new JRadioButton("Scroll tabs");
		scrollButton.addActionListener((ActionEvent event) -> {
			tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		});
		buttonPanel.add(scrollButton);
		buttonGroup.add(scrollButton);
		add(buttonPanel, BorderLayout.SOUTH);
	}

	private void loadTab(int n) {
		String title = tabbedPane.getTitleAt(n);
		ImageIcon planetIcon = new ImageIcon("./chapter6/TabbedPaneTest/" + title + ".gif");
		tabbedPane.setComponentAt(n, new JLabel(planetIcon));
		tabbedPane.setIconAt(n, new ImageIcon("./chapter6/TabbedPaneTest/red-ball.gif"));
	}

	private JTabbedPane tabbedPane;
	private static final int DEFAULT_WIDTH = 640;
	private static final int DEFAULT_HEIGHT = 480;
}
