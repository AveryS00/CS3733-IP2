package project.boundary;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import project.controller.MoveTile;
import project.controller.ResetPuzzle;
import project.entity.Model;

public class App extends JFrame {

	private JPanel contentPane;
	PuzzleView panel;
	Model model;
	JLabel numberOfMoves;
	JButton btnReset;

	/**
	 * Create the application.
	 */
	public App(Model model) {
		this.model = model;
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnReset = new JButton("Reset");
		btnReset.addMouseListener(new ResetPuzzle(model, this));
		btnReset.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblMoves = new JLabel("Moves: ");
		lblMoves.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		numberOfMoves = new JLabel("0");
		numberOfMoves.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		panel = new PuzzleView(model);
		panel.addMouseListener(new MoveTile(model, this));
		
		
		GroupLayout groupLayout = new GroupLayout(contentPane);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addComponent(lblMoves)
					.addGap(3)
					.addComponent(numberOfMoves)
					.addPreferredGap(ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
					.addComponent(btnReset)
					.addGap(55))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnReset)
						.addComponent(lblMoves)
						.addComponent(numberOfMoves))
					.addGap(6)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(groupLayout);
	}
	
	public JLabel getMovesLabel () {
		return numberOfMoves;
	}
	
	public PuzzleView getPanel () {
		return panel;
	}
	
	public JButton getResetButton () {
		return btnReset;
	}
}
