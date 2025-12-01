package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class SuperObject {
	public BufferedImage image;
	public String name;
	public boolean collisionn = false;
	
	public int wordX, wordY;
	public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
	
	public int solidAreaDefaultX = 0;
	public int solidAreaDefaultY = 0;
	
	public void draw(Graphics2D g2, GamePanel gamePanel) {
		
		int screenX = wordX - gamePanel.player.Worldx + gamePanel.player.screenX;
		int screenY = wordY - gamePanel.player.Worldy + gamePanel.player.screenY;
		//wordX + gamePanel.titleSize con la sentencia (wordX + gamePanel.titleSize) controlamos el renderizado 
		
		if( 
				wordX + gamePanel.titleSize > gamePanel.player.Worldx - gamePanel.player.screenX 
				&& wordX - gamePanel.titleSize < gamePanel.player.Worldx + gamePanel.player.screenX
				&& wordY + gamePanel.titleSize > gamePanel.player.Worldy - gamePanel.player.screenY
				&& wordY - gamePanel.titleSize < gamePanel.player.Worldy + gamePanel.player.screenY	
			  ) {
				
			g2.drawImage(image, screenX, screenY, gamePanel.titleSize, gamePanel.titleSize, null);
				
		 		}
		
		}
	
}
