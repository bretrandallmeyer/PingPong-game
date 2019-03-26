
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

public class Ball extends GameObject{
	

	private Handler handler;

	public Ball(int x, int y, int width, int height, Id id, Handler handler){
		super(x, y, width, height, id);

		this.handler = handler;

	}

	public void tick(LinkedList<GameObject> object){

		x+=velX;
		y+=velY;

		collision();
	}

	public void render(Graphics g){

		Graphics2D gd = (Graphics2D)g;

		g.setColor(Color.BLACK);
		gd.fill(Bounds());


	}

	public void collision(){

		for(int i = 0; i < handler.objects.size(); i++){

			GameObject temp = handler.objects.get(i);

			if(temp != this){
				if(temp.getBounds().intersects(temp.getBounds())){

				}
			}
		}
		

	}

	public Ellipse2D Bounds(){
		return(new Ellipse2D.Double(x, y, width, height));
	}

	public Rectangle getBounds(){
		return (new Rectangle(x, y, width, height));
	}
}