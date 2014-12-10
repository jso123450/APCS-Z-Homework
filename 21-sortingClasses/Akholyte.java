import java.util.*;

public class Akholyte extends Basechar{
    
    private int PEBoost = 5;
    private int MAtkBoost = 3;
    private String name;
    //private String spells = "Energy Bolt";
    private int EnergyBoltDMG = 5;
    private int EnergyBoltCOST = 5;
    private String EnergyBoltInfo = "Base MATK: " + EnergyBoltDMG + " \n Pwr Cost: " + EnergyBoltCOST;
    private String Weapons = "Bare Hands, Regents Physics Textbook, Wand";
    private String[] parts = Weapons.split(",");

    public Akholyte() {
		super("Kevin", "Regents Physics Textbook", "Wand R", "Body");
    }

    public Akholyte(String name){
        super(name, "Regents Physics Textbook", "Wand R", "Body");
		super.setPE(super.getPE() +  PEBoost);
		super.setMAtk(super.getMAtk() + MAtkBoost);
    }

	public void attack(Basechar other) { // More than just attack, encounter in general
		Scanner sc = new Scanner(System.in);
		String choice = "";

		while (! (choice.equals("1") || choice.equals("2") || choice.equals("3"))) {
			System.out.println("Do you want to use:");
			System.out.println("1. Melee attack with " + this.getWielded());
			System.out.println("2. Ranged attack with " + this.getQuivered());
			System.out.println("3. Rest to gain stamina");
			choice = sc.nextLine();
		}

		if (choice.equals("1")) {
			if (this.getStamina() > 0) {
				if (this.toHit(1)) {
					int damage = this.getAtk(false) - (other.getDef() / 2);
					other.setHP(other.getHP() - damage);
					System.out.println("You landed a hit!");
					wait(1000);
					System.out.println("You inflicted " + damage + " damage!!");
					wait(1000);
					this.setStamina(getStamina() - 1);
				}

				else {
					System.out.println("You missed!");
					wait(1000);
				}
			}

			else {
				System.out.println("You don't have enough strength to attack!!\n");
				wait(1000);
			}
		}

		else if (choice.equals("2")) {
			if (this.toHit(1)) {
				int damage = this.getAtk(true) - (other.getDef() / 2);
				other.setHP(other.getHP() - damage);
				System.out.println("You landed a hit!");
				wait(1000);
				System.out.println("You inflicted " + damage + " damage!!");
				wait(1000);
			}

			else {
				System.out.println("You missed!");
				wait(1000);
			}
		}

		else if (choice.equals("3")) {
			System.out.println("You feel better!\n");
			this.setStamina(this.getStamina() + 5);
			wait(1000);
		}
	}
	
	public static void wait(int ms){
		try {
		Thread.sleep(ms);
		} catch (Exception e) {};
	}
	
   /*
   Might be used for later
    public void attack(Basechar other) {
    	System.out.println("Do you want to attack with 1) Basic ATK or 2) a SPELL?");
	int attack;
	Scanner scatk = new Scanner(System.in);
	attack = scatk.nextInt();
	if ( attack == 2 ) {
	    System.out.println("Type your spell: " + spells);
	    String atkspell = "";
	    Scanner scspell = new Scanner(System.in);
	    atkspell = scspell.nextLine();
	    int overallMagicDmg;
	    if (atkspell.equals("Energy Bolt")) {
		System.out.println(EnergyBoltInfo);
		overallDmg = this.getMatk() + EnergyBoltDmg - ( 0.5 * other.getMDef() );
	    }
	    if ( Math.random() <= spellaccuracy ) {
		System.out.println( "You have successfully done " + overallMagicDmg + "to " + other.getName() + "!" );
		other.setHP( other.getHP() - overallMagicDmg );
		this.setPE( this.getPE() - EnergyBoltCOST );
	    }
	    else {
		System.out.println("Woooops! You miscalculated the trajectory for your spell!");
		this.setPE( this.getPE() - EnergyBoltCOST );
	    }
	}
	else {
	    System.out.println("Choose your weapon: " + Weapons);
	    String atkweapon = "";
	    while (! ( (atkweapon.equals( parts[0] )) || (atkweapon.equals(parts[1])) ) ) {
		Scanner scwep = new Scanner(System.in);
		atkweapon = scwep.nextLine();
	    }
	    if ( atkweapon.equals( parts[0] )) {
		this.setWielded( "Regents Physics Textbook" );
	    }
	    int overallDmg = this.getAtk(False) - (0.5 * other.getDef() );
	    if ( Math.random() <= accuracy ) {
		System.out.println("Huzzah! You have successfully smacked " + other.getName() + " with your " + getWielded() + "!" );
		System.out.println("You have successfully inflicted " + overallDmg );
		other.setHP( other.getHP - overallDmg );
	    }
	    else {
		System.out.println("Wow! How can you even miss at pointblank range with your " + getWielded() + "!?!" );
	    }
	}	    
    }
}

   */
}
		    
	    
