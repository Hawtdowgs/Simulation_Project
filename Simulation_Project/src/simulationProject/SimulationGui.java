package simulationProject;

import javax.swing.*;
import java.awt.*;

public class SimulationGui {
	private JPanel panel;
	private JFrame frame;
	private JButton start;
	private JButton tick;
	private JLabel[][]labelGrid;
	
	public SimulationGui(boolean[][]forestGrid) {
		frame = new JFrame("Nature Simulator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setLocationRelativeTo(null);
		
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		start = new JButton();
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 10;
		panel.add(start, c);
		
		tick = new JButton();
		c.gridx = 10;
		c.gridy = 0;
		c.gridwidth = 10;
		panel.add(tick, c);
		
		labelGrid = new JLabel[20][20];
		
		for(int i = 0;i < 20;i++) {
			for(int j = 0;j < 20;j++) {
				if(forestGrid[i][j] = false) {
					labelGrid[i][j].setIcon(new ImageIcon("images/grey square.png"));
				}else{
					labelGrid[i][j].setIcon(new ImageIcon("images/green square.png"));
				}
				c.gridx = i;
				c.gridy = j + 1;
				c.gridwidth = 1;
				panel.add(labelGrid[i][j], c);
			}
		}
		
		
		
		frame.setContentPane(panel);
		frame.setVisible(true);	
	}
		
}
