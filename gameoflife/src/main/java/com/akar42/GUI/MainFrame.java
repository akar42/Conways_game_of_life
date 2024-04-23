package com.akar42.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ColorUIResource;

public class MainFrame extends JFrame{
	private Cell[][] cells = new Cell[10][];
	private JPanel gameBoard;
	private JPanel mainPanel;
	private JPanel menuPanel;
	private JButton startButton;
	private boolean isGameRunning = false;
	
	public MainFrame() {
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(new BorderLayout());
		
		gameBoard = new JPanel();
		menuPanel = new JPanel();
		
		for (int i = 0; i < 10; i++) {
			cells[i] = new Cell[10];
			for (int j = 0; j < 10; j++) {
				final int row = i;
				final int col = j;
				cells[i][j] = new Cell();
				
				cells[i][j].addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						changeStateOfCell(row, col);
					}
				});
				
				if ((i + j) % 2 == 0) {
					cells[i][j].setBackground(new ColorUIResource(255, 0, 0));
					cells[i][j].setAlive(false);
				} else {
					cells[i][j].setBackground(new ColorUIResource(0, 255, 0));
					cells[i][j].setAlive(true);
				}
				gameBoard.add(cells[i][j]);
			}
		}
		
		gameBoard.setLayout(new GridLayout(10, 10));
		// gameBoard.setMinimumSize(new Dimension(450, 450));
		
		getMainPanel().add(gameBoard, BorderLayout.CENTER);
		
		startButton = new JButton("Start");

		startButton.addActionListener(e -> {
			isGameRunning = true;
			provideData();
		});


		menuPanel.add(startButton);
		getMainPanel().add(menuPanel, BorderLayout.SOUTH);
		
		
	}
	
	// public static void main(String[] args) {
	// 	MainFrame mainFrame = new MainFrame();
    //     mainFrame.setTitle("Test Game of Life");
    //     mainFrame.setContentPane(mainFrame.mainPanel);
    //     mainFrame.setSize(500,500);
    //     mainFrame.setLocationRelativeTo(null);
    //     mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     mainFrame.setVisible(true);
    // }

	private void provideData() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'provideData'");
	}

	public JPanel getMainPanel() {
		return mainPanel;
		
	}

	private void changeStateOfCell(int row, int col) {
		if (cells[row][col].isAlive()) {
			cells[row][col].setBackground(new ColorUIResource(255, 0, 0));
		} else {
			cells[row][col].setBackground(new ColorUIResource(0, 255, 0));
		}

		cells[row][col].setAlive(!cells[row][col].isAlive());
	}

	private class Cell extends JPanel {
		private boolean alive = false;

		public boolean isAlive() {
			return alive;
		}

		public void setAlive(boolean isAlive) {
			this.alive = isAlive;
		}
	}
}
