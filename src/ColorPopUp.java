import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ColorPopUp extends JFrame {

	Vector<JButton> colors; // white, gray, black, red, blue, green, yellow, pink, orange
	JPanel colorPanel;

	public ColorPopUp() {
		super("Colors");
		colors = new Vector<>();

		init();
		this.setVisible(true);
		this.setResizable(true);
		this.setSize(50, 250);
	}

	private void init() {
		// initialization
		colorPanel = new JPanel();

		// set layout
		colorPanel.setLayout(new GridLayout(5, 2));

		// add colors
		for (int i = 0; i < 9; i++) {
			colors.add(new JButton());
		}

		// add elements to panel
		for (int i = 0; i < colors.size(); i++) {
			colorPanel.add(colors.get(i));
		}

		action();

		// set color
		colors.get(0).setBackground(Color.BLACK);
		colors.get(1).setBackground(Color.LIGHT_GRAY);
		colors.get(2).setBackground(Color.WHITE);
		colors.get(3).setBackground(Color.RED);
		colors.get(4).setBackground(Color.ORANGE);
		colors.get(5).setBackground(Color.YELLOW);
		colors.get(6).setBackground(Color.BLUE);
		colors.get(7).setBackground(Color.GREEN);
		colors.get(8).setBackground(Color.PINK);

		// add elements to contentPane
		this.getContentPane().add(colorPanel, BorderLayout.CENTER);

	}

	public void action() {
		// add listener
		for (JButton button : colors) {
			button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// new window for test
					// JFrame f = new JFrame(button.getBackground().toString());
					// f.setSize(90, 90);
					// JPanel p = new JPanel();
					// p.setBackground(button.getBackground());
					// f.getContentPane().add(p);
					// f.setVisible(true);
					//
				}
			});
		
		}
		
	}
}
