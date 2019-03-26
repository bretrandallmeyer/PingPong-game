

public class Camera{
	
	protected int x;
	protected int y;

	public Ball ball;
	public Camera(int x, int y){

		this.x = x;
		this.y = y;
	}

	public void tick(Ball ball){
		this.ball = ball;

		if(ball.x <100 && ball.x >600){
			x = -ball.x + Game._WIDTH/2 - Game.WIDTH/2;

		}else{
		}
		y = -ball.y + Game._HEIGHT/2 - Game.HEIGHT/2;

		y--;

	}

	public int getX(){
		return this.x;
	}

	public int getY(){
		return this.y;
	}

	public void setX(int x){
		this.x = x;
	}

	public void setY(int y){
		this.y = y;
	}
}