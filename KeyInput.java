import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class KeyInput extends KeyAdapter{

	public Player player;
	public Player player2;
	public Ball ball;

	public KeyInput(Player player, Player player2, Ball ball){

		this.player = player;
		this.player2 = player2;
		this.ball = ball;

	}

	public void keyPressed(KeyEvent e){
		int code = e.getKeyCode();


		if(code == KeyEvent.VK_RIGHT){
			player.velX = 7;


		}else if(code == KeyEvent.VK_LEFT){
			player.velX = -7;
		
		}else if(code == KeyEvent.VK_UP){
			player.velY = -7;


		}else if(code == KeyEvent.VK_DOWN){
			player.velY = 7;

		}

		if(code == KeyEvent.VK_D){
			player2.velX = 7;


		}else if(code == KeyEvent.VK_A){
			player2.velX = -7;
		
		}else if(code == KeyEvent.VK_W){
			player2.velY = -7;


		}else if(code == KeyEvent.VK_S){
			player2.velY = 7;

		}

		if(code == KeyEvent.VK_SPACE){

			ball.velX = 5;
			ball.velY = 5;
		}
	}

	public void keyReleased(KeyEvent e){

		int code = e.getKeyCode();

		if(code == KeyEvent.VK_RIGHT){
			player.velX = 0;

		}else if(code == KeyEvent.VK_LEFT){
			player.velX = 0;
		
		}else if(code == KeyEvent.VK_UP){
			player.velY = 0;

		}else if(code == KeyEvent.VK_DOWN){
			player.velY = 0;
		
		}

		if(code == KeyEvent.VK_D){
			player2.velX = 0;


		}else if(code == KeyEvent.VK_A){
			player2.velY = 0;
		
		}else if(code == KeyEvent.VK_W){
			player2.velY = 0;


		}else if(code == KeyEvent.VK_S){
			player2.velY = 0;

		}
	}

}