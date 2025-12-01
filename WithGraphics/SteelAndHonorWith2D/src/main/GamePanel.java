package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import Tile.TileManager;
import entity.Player;
import object.SuperObject;

public class GamePanel extends JPanel implements Runnable {

	//Configuraciones de vetana se setean como constantess
	final int originalTitleSize = 16; // esto ajusta a 16 x 16 del jugador/npc 
	final int scale = 3;
	
	public final int titleSize = scale * originalTitleSize;
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12; //asignamos un size de 2:3 recatangular
	
	public final int screenWith = titleSize * maxScreenCol; //768 px
	public final int screenHeight = titleSize * maxScreenRow; //576px
	
	
	public AssetSetter aSetter = new AssetSetter(this);
	public UI ui = new UI(this);
	public CollisionChecker collision = new CollisionChecker(this);
	
	KeyHandler keyHadler = new KeyHandler(); 
	TileManager tileManager = new TileManager(this);
	Sound music = new Sound();
	Sound SE = new Sound();
	Thread GameThread;
	public Player player = new Player(this, keyHadler);
	
	//Configuraciones del Mundo
	
	public final int wordMaxCol = 50;
	public final int wordMaxRow = 50;
	public final int wordWindth = titleSize * wordMaxCol;
	public final int wordHeight = titleSize * wordMaxRow;
	
	//FPS (frames per second)
	int FPS  = 60;
	//aqui preparamos el juego para que podamos pintar como maximo 10objetos 
	public SuperObject obj[] = new SuperObject[10];
	
	
	
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWith, screenHeight));// 768 x 576
		this.setBackground(Color.black);//color de fondo
		this.setDoubleBuffered(true);//solo mejoraos el rendimiento nada mas 9:
		
		this.addKeyListener(keyHadler);
		this.setFocusable(true);
		
	}
	public void setUpGame() {
		aSetter.setObject();
		playMusic(0);
	}
	
	public void StarGameThread() {
		GameThread = new Thread(this);
		GameThread.start();
	}

	@Override//usamos un hilo para apartar el proceso del juego
	public void run() {
		double drawInterval = 1000000000/FPS;	
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		long drawCount = 0;
		while(GameThread != null){
			/*******Saque todo este codigo de un repo de git para manejar el clock game XD*******/
			//System.out.println("THE GAME IS RUNNING");
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			timer+=(currentTime - lastTime);
			
			lastTime = currentTime;
			
			if(delta >= 1) {
				//UPDATE : actualizamos la posicion del caracter
				update();
				
				//DRAW: dibujamos dicho cambio
				repaint();
				drawCount++;
				delta--;
				
			}
			
			if(timer >= 1000000000) {
				System.out.println("FPS : " + drawCount);
				drawCount = 0;
				timer = 0;
			}
			
		}
		
		
	}
	public void update() {
		player.update();
	}
	
	/*
	 * 	!!!!OJO!!!!
	 * paintComponent es un metodo de la clase Jpanel para dibujar informacion
	 * usamos super en GamePanel ya que es una subclase de este mismo 
	 */
	public void paintComponent(Graphics g) {//esta clase es como un lapiz dibuja xDD
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;//parseamos son casi lo mismo pero segun chatGPT tiene mas funciones para dibujar
		tileManager.draw(g2);
		
		
		for(int i = 0; i < obj.length; i++) {
			if(obj[i] != null) {
				obj[i].draw(g2, this);
			}
		}
		
		
		
		player.draw(g2);
		ui.draw(g2);
		g2.dispose();
		
		
	}
	
	public void playMusic(int i) {
		music.setFile(i);
		music.play();
		music.loop();
	}
	public void stopMusic() {
		music.stop();
	}
	public void soundEfect(int i) {
		SE.setFile(i);
		SE.play();
	}
	
	
			
}
