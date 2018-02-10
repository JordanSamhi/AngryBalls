package sounds;

public class CollisionBilleSound extends Sound{

	
	private static CollisionBilleSound instance = null;
	
	private CollisionBilleSound(String file){
		super(file);
	}
	
	public static CollisionBilleSound getInstance() {
		if(instance == null)
			instance = new CollisionBilleSound("sounds/collisionBille.wav");
		return instance;
	}
	
	
}
