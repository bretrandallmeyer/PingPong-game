import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.awt.geom.Ellipse2D;

public abstract class GameObject{
	
	protected int x, y;
	protected int velX, velY;
	protected int width, height;
	protected Id id;



	public GameObject(int x, int y, int width, int height, Id id){

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.id = id;

	}

	public abstract void tick(LinkedList<GameObject> object) ;
	public abstract void render(Graphics g);

	public Rectangle getBounds(){
		return (new Rectangle(x, y, width, height/5));
	}

	public Rectangle middleBounds(){
		return (new Rectangle(x, y+20, width, height/5));

	}

	public Rectangle bottomBounds(){
		return(new Rectangle(x, y+40, width, height/5));

	}

	public Rectangle underBounds(){
		return(new Rectangle(x, y+60, width, height/5));

	}

	public Rectangle lowestBounds(){
		return(new Rectangle(x, y+80, width, height/5));

	}


	public Ellipse2D Bounds(){
		return(new Ellipse2D.Double(x, y, width, height));
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

	//Setters and Getters for speed;
	public int getVelX(){
		return this.velX;
	}

	public int getVelY(){
		return this.velY;
	}

	public void setVelX(int velX){
		this.velX = velX;
	}

	public void setVelY(int velY){
		this.velY = velY;
	}

	//Setters and getters for size
	public int getWidth(){
		return this.width;
	}

	public int getHeight(){
		return this.height;
	}

	public void setWidth(int width){
		this.width = width;
	}

	public void setHeight(int height){
		this.height = height;
	}

	public Id getId(){
		return this.id;
	}

	public void setId(Id id){
		this.id = id;
	}

}