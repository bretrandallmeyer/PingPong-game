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
			player.velx = 7;


		}else if(code == KeyEvent.VK_LEFT){
			player.velx = -7;
		
		}else if(code == KeyEvent.VK_UP){
			player.vely = -7;


		}else if(code == KeyEvent.VK_DOWN){
			player.vely = 7;

		}

		if(code == KeyEvent.VK_D){
			player2.velx = 7;


		}else if(code == KeyEvent.VK_A){
			player2.velx = -7;
		
		}else if(code == KeyEvent.VK_W){
			player2.vely = -7;


		}else if(code == KeyEvent.VK_S){
			player2.vely = 7;

		}

		if(code == KeyEvent.VK_SPACE){

			ball.velx = 5;
			ball.vely = 5;
		}
	}

	public void keyReleased(KeyEvent e){

		int code = e.getKeyCode();

		if(code == KeyEvent.VK_RIGHT){
			player.velx = 0;

		}else if(code == KeyEvent.VK_LEFT){
			player.velx = 0;
		
		}else if(code == KeyEvent.VK_UP){
			player.vely = 0;

		}else if(code == KeyEvent.VK_DOWN){
			player.vely = 0;
		
		}

		if(code == KeyEvent.VK_D){
			player2.velx = 0;


		}else if(code == KeyEvent.VK_A){
			player2.velx = 0;
		
		}else if(code == KeyEvent.VK_W){
			player2.vely = 0;


		}else if(code == KeyEvent.VK_S){
			player2.vely = 0;

		}
	}

}