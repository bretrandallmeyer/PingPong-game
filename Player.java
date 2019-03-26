import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.awt.Font;
import java.util.LinkedList;
import java.util.Random;
import javax.sound.sampled.Clip;
import java.util.Scanner;
import javax.swing.JLabel;


public class Player extends GameObject{

	public String name;
	public int velx, vely;
	public int score = 0;
	private Handler handler;
	private int loop;


	public Player(int x, int y, int width, int height, Handler handler){
		super(x, y, width, height);
	
		this.handler = handler;
	}

	public void tick(LinkedList<GameObject> object){
		
		y += vely;

		if(loop == 10){
			loop = 0;
			collision();
		}else{
			loop++;
		}
	}

	public void collision(){

		if(y <= 2){
			y = 2;
		}

		if(y >= 470){
			y = 470;
		}

		for(int i = 0; i < handler.objects.size(); i++){
			
			GameObject temp = handler.objects.get(i);
			if(temp != this){

				if(temp.getBounds().intersects(getBounds())){
				
					temp.x = -temp.x;
					System.out.println("load");
				}

			}
		}
	
	}

	

	public void render(Graphics g){

		Graphics2D g2d = (Graphics2D)g;

		g.setColor(Color.WHITE);

		g2d.draw(getBounds());

		g2d.draw(middleBounds());

		g2d.draw(bottomBounds());

		g2d.draw(underBounds());

		g2d.draw(lowestBounds());


		
	}

	

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



}
	