package sounds;

public class CollisionBordSound extends Sound{

	private static CollisionBordSound instance = null;
	
	private CollisionBordSound(String file){
		super(file);
	}
	
	public static CollisionBordSound getInstance() {
		if(instance == null)
			instance = new CollisionBordSound("sounds/billeBord.wav");
		return instance;
	}
}