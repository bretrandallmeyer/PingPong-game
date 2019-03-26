import java.util.LinkedList;
import java.awt.Graphics;

public class Handler{
	
	protected LinkedList<GameObject> objects = new LinkedList<GameObject>();
	protected GameObject object;


	public void tick(){

		for(int i = 0; i < objects.size(); i++){
			object = objects.get(i);

			object.tick(objects);
		}
	}

	public void render(Graphics g){

		for(int i = 0; i< objects.size(); i++){
			object = objects.get(i);

			object.render(g);
		}
	}

	public void add(GameObject object){
		this.objects.add(object);

		}

	public void remove(GameObject object){
		
		this.objects.remove(object);
	}

}