package entity;
import main.KeyHandler;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import main.GamePanel;



public class Player extends Entity {

	GamePanel gamePanel;
	KeyHandler keyHandler;

	public final int screenX;
	public final int screenY;
	public int hasKey = 0;
	
	public Player(GamePanel gp, KeyHandler kh) {
		this.gamePanel = gp;
		this.keyHandler = kh;
		
		setDefaultValues();
		getPlayerImage();
		screenX = gp.screenWith / 2 - (gp.titleSize / 2);
		screenY = gp.screenHeight / 2 - (gp.titleSize /2);
	
		//instanseamos el hit-Box
		solidArea = new Rectangle(8, 16, 32, 32); //aqui instaceamos de Entity
		this.solidAreaDefaultX  = solidArea.x;
		this.solidAreaDefaultY  = solidArea.y;
	}
	
	
	public void setDefaultValues() {
		Worldx = gamePanel.titleSize * 23;
		Worldy = gamePanel.titleSize * 21;
		speed = 4;
		direction = "down";
	}
	public void getPlayerImage() {
		//vamos a tratar de cargar las imagenes TODO: no cargar el juego si no cargan las imagenes
		//	up1, up2, down1, down2, left1, left2, right1, right2
		
		try {
			up1 = ImageIO.read(getClass().getResource("/player/boy_up_1.png"));
			up2 = ImageIO.read(getClass().getResource("/player/boy_up_2.png"));
			down1 = ImageIO.read(getClass().getResource("/player/boy_down_1.png"));
			down2 = ImageIO.read(getClass().getResource("/player/boy_down_2.png"));
			left1 = ImageIO.read(getClass().getResource("/player/boy_left_1.png"));
			left2 = ImageIO.read(getClass().getResource("/player/boy_left_2.png"));
			right1 = ImageIO.read(getClass().getResource("/player/boy_right_1.png"));
			right2 = ImageIO.read(getClass().getResource("/player/boy_right_2.png"));
			onion = ImageIO.read(getClass().getResource("/player/onion.png"));
		}catch(IOException e) {
				e.printStackTrace();
		}
		
		
	}
	public void update() {
		
		if(keyHandler.upPressed == true || keyHandler.downPressed == true || keyHandler.leftPressed == true ||keyHandler.rightPressed == true ) {
				if(keyHandler.upPressed == true) {
					direction = "up";
				
					
					
				}else if(keyHandler.downPressed == true) {
					direction = "down";
				
				}
				else if(keyHandler.leftPressed == true) {
					direction = "left";
					
					
				}else if(keyHandler.rightPressed == true) {
					direction = "right";
					
				}
				spriteCounter++;
				CollisionOn = false;
				
				gamePanel.collision.checkTile(this);
				
				int index = gamePanel.collision.checkObject(this, true);
				pickUpObject(index);
				
				
				//SI LA COLISION ES VERDADERA EL JUGAR NO C PUEDO MOVER EN ESA DIRECCION
				if(CollisionOn == false) {
						
					if(direction.equals("up")) {
						Worldy -=  speed;
					}else if(direction.equals("down")) {
						Worldy +=  speed;
						
					}else if(direction.equals("left")) {
						Worldx -=  speed;
					}else if(direction.equals("right")) {
						Worldx +=  speed;
					}
					
					
					
				}
				
				
				
				//recordemos que este metodo se manda a llamr 60 veces por segundo!!
				if(spriteCounter > 12) {
					if(spriteNumber == 1) {
						spriteNumber=2;
					}else if(spriteNumber == 2) {
						spriteNumber = 1;
					}
					spriteCounter = 0;
				}
			
		   }
		
	}
	public void pickUpObject(int index) {
		if(index != 999) {
			String objName = gamePanel.obj[index].name;
			
			if(objName.equals("Key")) {
				this.hasKey++;
				gamePanel.obj[index] = null;
				gamePanel.soundEfect(1);
				gamePanel.ui.showMessage("Tienes una LLave!!");
				//System.out.println("you have a" + this.hasKey + " in your invetory");
				
			}else if(objName.equals("Door")) {
				if(this.hasKey > 0) {
					gamePanel.soundEfect(3);
					gamePanel.obj[index] = null;
					this.hasKey--;
					gamePanel.ui.showMessage("Has abierto una puerta!!");
				}else {
					gamePanel.ui.showMessage("Tu necesitas una Llave!!");
				}
				System.out.println("you have a" + this.hasKey + " in your invetory");
			}else if(objName.equals("Boots")) {
				speed += 2;
				gamePanel.soundEfect(2);
				gamePanel.obj[index] = null;
				gamePanel.ui.showMessage("Velocidad X 2!!");
			}else if(objName.equals("Chest")) {
				gamePanel.ui.gameFinished = true;
				gamePanel.stopMusic();
				gamePanel.soundEfect(4);
			}
		}
	}
	public void draw(Graphics2D g2) {
		/* 	datos d eprueba
		 * 	g2.setColor(Color.white);
		 *	g2.fillRect(x, y, gamePanel.titleSize,gamePanel.titleSize);
		 *		up1, up2, down1, down2, left1, left2, right1, right2
		 */
		
		BufferedImage image = null;
		
			if(direction.equals("up")) {
				if(spriteNumber == 1) {
					  image = up1;
				}
				if(spriteNumber == 2) {
					  image = up2;
				}
			} else if(direction.equals("down")) {
				if(spriteNumber == 1) {
					   image = down1;
				}
				if(spriteNumber == 2) {
					   image = down2;
				}
		
			} else if(direction.equals("left")) {
				if(spriteNumber == 1) {
					   image = left1;
				}
				if(spriteNumber == 2) {
					   image = left2;
				}
			} else if(direction.equals("right")) { 
				if(spriteNumber == 1) {
					   image = right1;
				}
				if(spriteNumber == 2) {
					   image = right2;
				}
			}
			
			// el "null" de drawImage se debe a el ImageObserver algo relacionado con el cambio de imagen
			g2.drawImage(image, screenX, screenY, (int)(gamePanel.titleSize ), (int)(gamePanel.titleSize ), null);

		
		
		
	}
	
		
}
