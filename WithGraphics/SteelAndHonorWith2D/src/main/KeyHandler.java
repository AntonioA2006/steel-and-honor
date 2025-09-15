package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	//posiciones del caracter 
				
	/*		   |
	 *    r     |j			
	 *  <------x----->
	 *         |d
	 *         |
	 *         
	 */
	public boolean upPressed, downPressed, leftPressed,rightPressed;
	@Override
	public void keyTyped(KeyEvent e) {}
	
	

	@Override
	public void keyPressed(KeyEvent e) {
		//obtenemos el codigo de la tecla que presionada
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_W) {
			upPressed = true;
		}
		if(code == KeyEvent.VK_S) {
			downPressed = true;
		}
		if(code == KeyEvent.VK_A) {
			leftPressed = true;
		}		
		if(code == KeyEvent.VK_D) {
			rightPressed = true;
		}		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//obtenemos el codigo de la tecla que soltada
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_W) {
			upPressed = false;
		}
		if(code == KeyEvent.VK_S) {
			downPressed = false;
		}
		if(code == KeyEvent.VK_A) {
			leftPressed = false;
		}		
		if(code == KeyEvent.VK_D) {
			rightPressed = false;
		}		
		
		
	}

}
