package project.boundary;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class App {

	public JFrame frame;
	PuzzleView panel;

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnReset = new JButton("Reset");
		
		JLabel lblMoves = new JLabel("Moves: ");
		
		JLabel numberOfMoves = new JLabel("New label");
		
		panel = new PuzzleView();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblMoves)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(numberOfMoves)
							.addPreferredGap(ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
							.addComponent(btnReset)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnReset)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblMoves)
							.addComponent(numberOfMoves)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
