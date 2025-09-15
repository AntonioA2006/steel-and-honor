package Tile;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;


public class TileManager {
	GamePanel gamePanel;
	Tile[] tile;
	
	
	public TileManager(GamePanel gp) {
		this.gamePanel = gp;
		tile = new Tile[10];
		
		getTileImage();
	}
	
	public void getTileImage() {
		try {
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResource("/tiles/grass.png")); 

			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResource("/tiles/wall.png")); 

			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResource("/tiles/water.png")); 
			
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResource("/tiles/sand.png")); 
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void draw(Graphics2D g2) {
		int col  = 0;
		int row = 0;
		int x = 0;
		int y = 0;
		
		//mapeamos el mapa
		
		while(col < gamePanel.maxScreenCol && row < gamePanel.maxScreenRow) {
				g2.drawImage(tile[3].image, x, y, gamePanel.titleSize, gamePanel.titleSize, null);
				col++;
				x+= gamePanel.titleSize;
				
				if(col == gamePanel.maxScreenCol) {
					col = 0;
					x = 0;
					row++;
					y += gamePanel.titleSize;
				
				}			
		 
			}
		
	  }
}
