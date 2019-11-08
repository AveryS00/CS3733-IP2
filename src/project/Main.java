package project;

import project.boundary.App;
import project.entity.Model;

public class Main {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Model m = new Model();
		App app = new App(m);
		
		app.setVisible(true);
	}
}
