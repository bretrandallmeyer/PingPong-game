
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

public class Ball{
	

	public int x, y, width, height;
	public int velx, vely;

	public Ball(int x, int y, int width, int height){

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void tick(){

		x+=velx;
		y+=vely;

		collision();
	}

	public void render(Graphics g){

		Graphics2D gd = (Graphics2D)g;

		g.setColor(Color.BLACK);
		gd.fill(getBounds());


	}

	public void collision(){

		if(x >= 800 || x <= 0){
			velx = -velx;
		}

		if(y >=5000 || y <=0){
			vely= -vely;
		}

	}

	public Ellipse2D getBounds(){
		return(new Ellipse2D.Double(x, y, width, height));
	}
}