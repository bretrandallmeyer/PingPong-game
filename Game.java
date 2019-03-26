import java.awt.Canvas;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.util.Random;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Font;
import javax.imageio.ImageIO;
import java.io.IOException;


public class Game extends Canvas implements Runnable{
	
	private static Frame frame;


	protected final static String _TITLE = "Ping PONG";
	protected final static int _WIDTH = 800;
	protected final static int _HEIGHT = 600;
	private boolean isRunning = false;
	private Thread thread;
	private Handler handler;
	private SoundLoader sound;
	private String soundPath = "Puzzle-Game.wav";


	private Camera cam;

	private Player player1;
	private Player player2;
	private Ball ball;

	private KeyInput keyInput;

	public BufferedImage image;




	public Game(){

		handler = new Handler();
		sound = new SoundLoader();
		sound.loadSound(soundPath);

		init();
	}

	private void init(){


		
		sound.playBackGroundMusic();

		ball = new Ball(300, 300, 25,25, Id.Ball, handler);
		handler.add(ball);

		player1 = new Player(1, ball.y, 25, 100, Id.Player, handler);
		handler.add(player1);

		player2 = new Player(769, ball.y, 25, 100, Id.Player, handler);
		handler.add(player2);

		try{
			image = ImageIO.read(getClass().getResource("sky.JPEG"));
	
		}catch(IOException e){
			e.printStackTrace();
		}


		cam = new Camera(0, 0);

		keyInput = new KeyInput(player1, player2, ball);

		addKeyListener(keyInput);



	}


	public synchronized void start(){

		if(isRunning)
			return;

		isRunning = true;

		thread = new Thread(this);
		thread.run();

	}

	public void run(){

		init();
		this.requestFocus();

		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double nanoSec = 1000000000/amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;


		while(isRunning){
			long now = System.nanoTime();
			delta += (now - lastTime)/ nanoSec;
			lastTime = now;

			while(delta >= 1){
				tick();
				updates++;
				delta--;
			}

			render();
			frames++;

			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				frames = 0;
				updates = 0;

			}
		}		
	}

	private void render(){

		BufferStrategy bs = this.getBufferStrategy();

		if(bs == null){
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		Graphics2D g2d = (Graphics2D)g;

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, _WIDTH, _HEIGHT);


		//////////////////////////////
			
			g.translate(cam.getX(), cam.getY());

			for(int i = 0; i < image.getHeight()* 30; i+=image.getHeight()){
				g.drawImage(image, 0, i, 800, 900, null);	
			}
				g.setColor(Color.WHITE);
				g.fillRect(_WIDTH/2 , 1, 10, 10000);

		
				handler.render(g);



			g.setColor(Color.WHITE);


			g.translate(-cam.getX(), -cam.getY());

		/////////////////////////////
			g.setColor(Color.RED);





			
			
		g.dispose();
		bs.show();
	}

	private void tick(){
		
		handler.tick();
		cam.tick(ball);

	}

	public void collision(){


	}

	public static void main(String args[]){
		frame = new Frame(_WIDTH, _HEIGHT, _TITLE, new Game());
	}
}