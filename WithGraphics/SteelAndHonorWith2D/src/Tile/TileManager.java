package Tile;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import main.GamePanel;


public class TileManager {
	GamePanel gamePanel;
	public Tile[] tile;
	public int mapTileNum[][];
	
	public TileManager(GamePanel gp) {
		this.gamePanel = gp;
		tile = new Tile[10];
		mapTileNum = new int[gp.wordMaxCol][gp.wordMaxRow];
		getTileImage();
		loadMap("/maps/map_02.txt");
	}
	public void loadMap(String args) {
		
		try {
			//obtenemos el map_01
			InputStream st = getClass().getResourceAsStream(args);
			BufferedReader br = new BufferedReader(new InputStreamReader(st));
			
			int col = 0;
			int row = 0;
			
			while(col < gamePanel.wordMaxCol && row < gamePanel.wordMaxRow) {
				String line = br.readLine();
				
					while(col < gamePanel.wordMaxCol) {
						String Numbers[] = line.split(" ");
						
						int num = Integer.parseInt(Numbers[col]);
						
						mapTileNum[col][row] = num;
						
						col++;
					}
					if(col == gamePanel.wordMaxCol) {
						col = 0;
						row++;
					}
				
				
			}
			
			br.close();
				
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void getTileImage() {
		try {
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResource("/tiles/grass.png")); 

			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResource("/tiles/wall.png")); 
			tile[1].colision = true;//seteamos la colision

			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResource("/tiles/water.png")); 
			tile[2].colision = true; //seteamos la colision 
			
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResource("/tiles/earth.png")); 
			
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResource("/tiles/tree.png"));
			tile[4].colision = true; //seteamos la colision
			
			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResource("/tiles/sand.png")); 
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void draw(Graphics2D g2) {
		int worldCol  = 0;
		int wordRow = 0;
		
		//mapeamos el mapa
		
		while(worldCol < gamePanel.wordMaxCol && wordRow < gamePanel.wordMaxRow) {
			
				int tileNum = mapTileNum[worldCol][wordRow];
				
				int wordX = worldCol * gamePanel.titleSize;
				int wordY = wordRow * gamePanel.titleSize;
				
				int screenX = wordX - gamePanel.player.Worldx + gamePanel.player.screenX;
				int screenY = wordY - gamePanel.player.Worldy + gamePanel.player.screenY;
				//wordX + gamePanel.titleSize con la sentencia (wordX + gamePanel.titleSize) controlamos el renderizado 
				
				if( 
					wordX + gamePanel.titleSize > gamePanel.player.Worldx - gamePanel.player.screenX 
					&& wordX - gamePanel.titleSize < gamePanel.player.Worldx + gamePanel.player.screenX
					&& wordY + gamePanel.titleSize > gamePanel.player.Worldy - gamePanel.player.screenY
					&& wordY - gamePanel.titleSize < gamePanel.player.Worldy + gamePanel.player.screenY	
				  ) {
					
					g2.drawImage(tile[tileNum].image, screenX, screenY, gamePanel.titleSize, gamePanel.titleSize, null);
					
					}
				
			
				worldCol++;
			
				if(worldCol == gamePanel.wordMaxCol) {
					worldCol = 0;
					
					wordRow++;
				
				
				}			
		 
			}
		
	  }
}
