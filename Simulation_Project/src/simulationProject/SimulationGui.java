package simulationProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulationGui implements ActionListener{
	private JPanel panel;
	private JFrame frame;
	private JButton start;
	private JButton restart;
	private JLabel[][]labelGrid;
	private ImageIcon grey, green, greenRabbit, greenWolf, greyRabbit, greyWolf;
	private boolean[][]forestGrid, wPosition, rabbitSpawn;
	/**
	 * Constructor - sets up a GUI with a 20x20 grid of square lavels and two buttons at the top
	 */
	public SimulationGui() {
		frame = new JFrame("Nature Simulator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1500, 800);
		frame.setLocationRelativeTo(null);
		
		panel = new JPanel(new GridBagLayout());
		panel.setBounds(400, 400, 400, 400);
		GridBagConstraints c = new GridBagConstraints();
		
		start = new JButton("Start");
		start.setActionCommand("start");
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 10;
		start.setPreferredSize(new Dimension(100, 50));
		start.setText("Start");
  
		panel.add(start, c);
		
		restart = new JButton();
		c.gridx = 10;
		c.gridy = 0;
		c.gridwidth = 10;
		restart.setPreferredSize(new Dimension(100, 50));
		restart.setText("Restart");		
		
		panel.add(restart, c);
		
		ImageIcon grey = new ImageIcon("images/grey square.jpg");
		ImageIcon green = new ImageIcon("images/green square.jpg");
		ImageIcon greenRabbit = new ImageIcon("images/green square rabbit.png");
		ImageIcon greenWolf = new ImageIcon("images/green square wolf.png");
		ImageIcon greyRabbit = new ImageIcon("images/grey square rabbit.png");
		ImageIcon greyWolf = new ImageIcon("images/grey square rabbit.png");
		JLabel[][] labelGrid = new JLabel[20][20];

		for(int i = 0;i < 20;i++) {
			for(int j = 0;j < 20;j++) {
				labelGrid[i][j] = new JLabel();
				labelGrid[i][j].setPreferredSize(new Dimension(35, 35));
				
				
				if(forestGrid[i][j] == false) {
					labelGrid[i][j].setIcon(grey);
				}else{
					labelGrid[i][j].setIcon(green);
				
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
	/**
	 * Brings all of the new program data into the GUI class
	 * @param forest
	 * @param rabbit
	 * @param wolf
	 */
	public void updateGridData(boolean[][]forest, boolean[][]rabbit, boolean[][]wolf) {
		for(int i = 0;i < 20;i++) {
			for(int j = 0;j < 20;j++) {
				forestGrid[i][j] = forest[i][j];
				rabbitSpawn[i][j] = rabbit[i][j];
				wPosition[i][j] = wolf[i][j];
			}
		}
	}
	/**
	 * Updates the GUI with the new data once a tick
	 */
	public void tick() {
		
		for(int i = 0;i < 20;i++) {
			for(int j = 0;j < 20;j++) {
				if(forestGrid[i][j] == true) {
					if(rabbitSpawn[i][j] == true) {
						labelGrid[i][j].setIcon(greenRabbit);
					}else if(wPosition[i][j] == true){
						labelGrid[i][j].setIcon(greenWolf);
					}else{
						labelGrid[i][j].setIcon(green);
					}
				}else{
					if(rabbitSpawn[i][j] == true) {
						labelGrid[i][j].setIcon(greyRabbit);
					}else if(wPosition[i][j] == true) {
						labelGrid[i][j].setIcon(greyWolf);
					}else{
						labelGrid[i][j].setIcon(grey);
					}
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String eventName = event.getActionCommand();
		
		if(eventName.equals("tick")) {
			for(int i = 0;i < 20;i++) {
				for(int j = 0;j < 20;j++) {
					if(forestGrid[i][j] == true) {
						if(rabbitSpawn[i][j] == true) {
							labelGrid[i][j].setIcon(greenRabbit);
						}else if(wPosition[i][j] == true){
							labelGrid[i][j].setIcon(greenWolf);
						}else{
							labelGrid[i][j].setIcon(green);
						}
					}else{
						if(rabbitSpawn[i][j] == true) {
							labelGrid[i][j].setIcon(greyRabbit);
						}else if(wPosition[i][j] == true) {
							labelGrid[i][j].setIcon(greyWolf);
						}else{
							labelGrid[i][j].setIcon(grey);
						}
					}
				}
			}
		}
		
	}
	
}