import java.util.*;

public class Nomar extends Basechar{
    private String name;
    private double intimidation;

    public Nomar(){
		super();
		name = "The Great Nomar";
		intimidation = 0.5;
    }
    
    public Nomar(String name){
    	super(name);
    	intimidation = 0.1;
    }

    public void setStats(Basechar other){
		Random r = new Random();
		int levelFactor = r.nextInt(5) - 3;
		if (levelFactor <= 0){
	    	this.setLv(1);
		}
		else{
	    	this.setLv(levelFactor + other.getLv());
		}
		this.setHP(this.getLv() * 10);
    }
    
    public double getIntimidation(){
    	return intimidation;
    }
    
    public void setIntimidation(double NewIntimidation){
    	intimidation = NewIntimidation;
    }
    
    public static void wait(int ms){
    	try {
    		Thread.sleep(ms);
    	} catch (Exception e) {}
    }

	public void attack(Basechar other) {
		Random r = new Random();
		int i = r.nextInt(4);

		switch (i) {
			case 0:
				basicAttack(other);
				break;
			
			case 1:
				lecture(other);
				break;

			case 2:
				instaKill(other);
				break;

			case 3:
				confiscation(other);
				break;
		}
	}

	public void basicAttack(Basechar other) {
	    System.out.println(this + " attacks you!");
	    wait(2000);
		if (this.toHit(1)) {
			int damage = this.getAtk(false) - (other.getDef() / 2);
			other.setHP(other.getHP() - damage);
			System.out.println(this + " landed a hit!");
			wait(2000);
			System.out.println(this + " inflicted " + damage + " damage!!");
			wait(2000);
		}

		else {
			System.out.println(this + " missed!!");
			wait(2000);
		}
	}
	
    public void lecture(Basechar other){

		Random chanceToHit = new Random();
		Random IntFactor = new Random();
		double intd = this.getIntimidation();
		
		if (chanceToHit.nextDouble() < this.getAccuracy()){
	    	System.out.println(this + " gives you a lengthy lecture");
            wait(5000);
	    	other.setHP(other.getHP() - (this.getAtk(false) - (other.getDef() / 2)));
	    	this.setIntimidation(intimidation + ((Math.abs(IntFactor.nextDouble() - intimidation)) * 0.5));
	    }

		else{
 	    	System.out.println(this + " tries to lecture you but you can't hear him over your blasting headphones");
		wait(2000);
		}
    }
    
    public void instaKill(Basechar other){
        Random chanceToHit = new Random();
        if (chanceToHit.nextDouble() < (this.getAccuracy() * 0.3)){
        	System.out.println(this + " calls your parents");
        	wait(2000);
        	other.setHP(0);
        }
        else{
        	System.out.println(this + " calls your parents but no one answers");
        	wait(2000);
        }
    
    }
    
    public void confiscation(Basechar other){
    	Random chanceToHit = new Random();
    	if (chanceToHit.nextDouble() < (this.getAccuracy())) {
    		if (other.getWielded().equals("Bare Hands")) {
    			System.out.println(this + " uses confiscate");
    			wait(2000);
    			System.out.println("...but you had nothing on you");
			wait(2000);
    		}
    		else{
    		        System.out.println(this + " confiscates your " + other.getWielded());
			wait(2000);
    		        other.setWielded("Bare Hands");	
    		}
    		
    	}
    }
}

  

	
