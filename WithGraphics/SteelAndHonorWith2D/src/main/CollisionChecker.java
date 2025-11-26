package main;
import java.awt.Rectangle;

import entity.Entity;

public class CollisionChecker {
	
	 GamePanel gamePanel;
	
	
	public CollisionChecker(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	public void checkTile(Entity en) {
		/*
		 * 
		 * Recordemos que el caracter mide por default lo mismo que una losa que son aprox 48px
		 * La hitbox no puedo medir eso ya que no quedaria margen para la colision asi que obtenemos
		 * la hit box de la siguiente manera
		 * 
		 * solidArea = new Rectangle(8, 16, 32, 32); //aqui instaceamos de Entity
		 * solidArea.x = 8
		 * solidArea.x = 16
		 * solidArea.Width = 32
		 * solidArea.Height = 32
		 *  k = A una posicion en el mundo del personaje
		 * sumamos las Posiciones relativas K mas su contra parte del area del rectangulo asi obtenemos la hit bpx
		 * 
		 * 
		 */
		int entityLeftWorldX = en.Worldx + en.solidArea.x;
		int entityRightWordX = en.Worldx + en.solidArea.x + en.solidArea.width;
		int entityTopWordY = en.Worldy + en.solidArea.y;
		int entityBottomWordY = en.Worldy + en.solidArea.y + en.solidArea.height;
		
		int entityLeftCol = entityLeftWorldX / gamePanel.titleSize;
		int entityRightCol = entityRightWordX / gamePanel.titleSize;
		int entityTopRow = entityTopWordY / gamePanel.titleSize;
		int entityBottomRow = entityBottomWordY / gamePanel.titleSize;
		
		int titleNum1, titleNum2;
		
		if(en.direction.equals("up")) {
			entityTopRow = (entityTopWordY - en.speed) / gamePanel.titleSize;
			
			titleNum1 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityTopRow];
			
			titleNum2 = gamePanel.tileManager.mapTileNum[entityRightCol][entityTopRow];
			
			if(gamePanel.tileManager.tile[titleNum1].colision == true || gamePanel.tileManager.tile[titleNum2].colision == true) {
				en.CollisionOn =  true;
			}
			
			
		}else if(en.direction.equals("down")) {
			
			entityBottomRow = (entityBottomWordY + en.speed) / gamePanel.titleSize;
			
			titleNum1 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityTopRow];
			
			titleNum2 = gamePanel.tileManager.mapTileNum[entityRightCol][entityBottomRow];
			
			if(gamePanel.tileManager.tile[titleNum1].colision == true || gamePanel.tileManager.tile[titleNum2].colision == true) {
				en.CollisionOn =  true;
			}
			
		}else if(en.direction.equals("left")) {

			
			entityLeftCol = (entityLeftWorldX - en.speed) / gamePanel.titleSize;
			
			titleNum1 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityTopRow];
			
			titleNum2 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
			
			if(gamePanel.tileManager.tile[titleNum1].colision == true || gamePanel.tileManager.tile[titleNum2].colision == true) {
				en.CollisionOn =  true;
			}
		}else if(en.direction.equals("right")) {
			entityRightCol = (entityRightWordX + en.speed) / gamePanel.titleSize;
			
			titleNum1 = gamePanel.tileManager.mapTileNum[entityRightCol][entityTopRow];
			
			titleNum2 = gamePanel.tileManager.mapTileNum[entityRightCol][entityBottomRow];
			
			if(gamePanel.tileManager.tile[titleNum1].colision == true || gamePanel.tileManager.tile[titleNum2].colision == true) {
				en.CollisionOn =  true;
			}
		}
		
		
		
	}
	
}
