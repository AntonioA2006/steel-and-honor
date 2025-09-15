package main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		JFrame Window  = new JFrame();//creamos una Ventana
		Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//botos x para salir
		Window.setResizable(false);//no podemos cambiar el tamamno de la vetana
		Window.setTitle("StellAndHonor");
		
		
		
			
		GamePanel gamePanel = new GamePanel();
		Window.add(gamePanel);
		
		Window.pack();		
		Window.setLocationRelativeTo(null);//centramos la pantalla al centro
		Window.setVisible(true);
		gamePanel.StarGameThread();
		

	}

}
