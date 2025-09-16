package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

//clase para mejar personajes, NPC, etc..
public class Entity {
	public int Worldx, Worldy;
	public int speed;
	
	
	public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2, onion;
	
	public String direction;
	public int spriteCounter = 0;
	public int spriteNumber = 1;
	
	//hitbox por Entidad
	public Rectangle solidArea;
	public boolean CollisionOn = false;
	
}
