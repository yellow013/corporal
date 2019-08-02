package io.ffreedom.corporal;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Launch {
	public static void main(String[] args) {
		System.out.println(new File(".").getAbsolutePath());
		JFrame frame = new TabbedPaneFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class TabbedPaneFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -888670680904631824L;

	public TabbedPaneFrame() {
		setTitle("TabbedPaneTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		tabbedPane = new JTabbedPane();

		ImageIcon icon = new ImageIcon("./chapter6/TabbedPaneTest/yellow-ball.gif");
		tabbedPane.addTab("Mercury", icon, null);
		tabbedPane.addTab("Venus", icon, null);
		tabbedPane.addTab("Earth", icon, null);
		tabbedPane.addTab("Mars", icon, null);
		tabbedPane.addTab("Jupiter", icon, null);
		tabbedPane.addTab("Saturn", icon, null);
		tabbedPane.addTab("Uranus", icon, null);
		tabbedPane.addTab("Neptune", icon, null);
		tabbedPane.addTab("Pluto", icon, null);
		add(tabbedPane, "Center");
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				if (tabbedPane.getSelectedComponent() == null) {
					int n = tabbedPane.getSelectedIndex();
					loadTab(n);
				}
			}
		});
		loadTab(0);
		JPanel buttonPanel = new JPanel();
		ButtonGroup buttonGroup = new ButtonGroup();
		JRadioButton wrapButton = new JRadioButton("Wrap tabs");
		wrapButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				tabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
			}
		});
		buttonPanel.add(wrapButton);
		buttonGroup.add(wrapButton);
		wrapButton.setSelected(true);
		JRadioButton scrollButton = new JRadioButton("Scroll tabs");
		scrollButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			}
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
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 300;
}
