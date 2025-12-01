package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import object.OBJ_Key;

public class UI {
	GamePanel gamepanel;
	Font arial_40, arial_80B;
	BufferedImage keyImage;
	int messageCounter = 0;
	public boolean gameFinished = false;
	public boolean messageOn = false;
	public String message = "";
	DecimalFormat df = new DecimalFormat("#0.00");
	
	double playTime;
	
	
	public void showMessage(String text) {
		message = text;
		messageOn = true;
	}
	
	public UI(GamePanel gp) {
		this.gamepanel = gp;
		 this.arial_40 = new Font("Arial",Font.PLAIN, 40);
		 this.arial_80B = new Font("Arial", Font.BOLD, 80);
		 OBJ_Key key = new OBJ_Key();
		 keyImage = key.image;
	}
	
	public void draw(Graphics2D g2) {
		if(gameFinished == true) {
			String text;
			int textLo, x, y;
			g2.setFont(arial_40);
			g2.setColor(Color.white);
			
			text = "Has encontrado el cofre!!";
			textLo= (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			 x = gamepanel.screenWith/2 - textLo/2;
			 y = gamepanel.screenHeight/2 - (gamepanel.titleSize * 3);
			 g2.drawString(text, x, y);
				
				text = "Tu tiempo fue de: " + df.format(playTime) + "!";
				textLo= (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
				 x = gamepanel.screenWith/2 - textLo/2;
				 y = gamepanel.screenHeight/2 + (gamepanel.titleSize * 4);
				 g2.drawString(text, x, y);
				 
			 
			 g2.setFont(arial_80B);
			g2.setColor(Color.yellow);
			
			text = "Felicidades!!";
			textLo= (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			
			
			 x = gamepanel.screenWith/2 - textLo/2;
			 y = gamepanel.screenHeight/2 + (gamepanel.titleSize * 2);
			 g2.drawString(text, x, y);
			 
			 
			 
			 gamepanel.GameThread = null;
			 
			 
			 
		}else {
				g2.setFont(arial_40);
				g2.setColor(Color.white);
				g2.drawImage(keyImage, gamepanel.titleSize/2, gamepanel.titleSize/2, gamepanel.titleSize, gamepanel.titleSize, null );
				g2.drawString("X " + gamepanel.player.hasKey, 74, 65);
				playTime += (double) 1/60;
				g2.drawString("Time:" + df.format(playTime), gamepanel.titleSize * 11, 65);
				
				if(messageOn == true) {
					g2.setFont(g2.getFont().deriveFont(30f));
					g2.drawString(message, gamepanel.titleSize/2, gamepanel.titleSize * 5);
					messageCounter++;
					if(messageCounter > 120) {
						messageCounter = 0;
						messageOn = false;
				}
			}	
		}
	}
}
