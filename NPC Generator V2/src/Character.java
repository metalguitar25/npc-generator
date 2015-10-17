import java.util.Random;


public class Character {

	// Instance Variables
	Random RNG;
	private String name;
	private String sex;
	private String race;
	private String className;
	private String combatStyle;
	private int level;
	private int BAB;
	private int[] abilityScores;
	private int[] abilityScoreModifiers;
	private AbilityScore str;
	private AbilityScore dex;
	private AbilityScore con;
	private AbilityScore inte;
	private AbilityScore wis;
	private AbilityScore cha;

	//pure random
	public Character(String name) {
		//initialize containers and other variables
		abilityScores = new int[6];
		abilityScoreModifiers = new int[6];
		RNG = new Random();
		//leveling... <-- will be a lot of work 
		level = 1;
		//initialize name
		if (name.equals("")) 
			this.name = "Character";
		else 
			this.name = name;
		//initialize sex
		setSex();
		//initialize class
		//TODO user chosen class should overwrite the randomly rolled class
		setRandomClass();
		//initialize combat style

		//initialize the ability scores
		//TODO user-chosen ability scores should overwrite the randomly rolled scores
		str = new AbilityScore(DieRoller.rollDie("4d6l1"));
		dex = new AbilityScore(DieRoller.rollDie("4d6l1"));
		con = new AbilityScore(DieRoller.rollDie("4d6l1"));
		inte = new AbilityScore(DieRoller.rollDie("4d6l1"));
		wis = new AbilityScore(DieRoller.rollDie("4d6l1"));
		cha = new AbilityScore(DieRoller.rollDie("4d6l1"));
		//organize ability scores based on class/combat style

		//initialize race
		setRace();
		//apply racial modifiers

		//initialize saves, requires ability score modifiers

		//initialize BAB

		//initialize naked AC, requires ability score modifiers





	}

	// RNG for choosing what thing to pick
	public String weightedRNG(String[] listOfThings, double[] probability) {
		String chosenThing;
		double generate = 0, sum = 0;
		generate = RNG.nextDouble();
		for (int i = 0; i < probability.length; i++) {
			sum = sum + probability[i];
			if (generate <= sum) {
				chosenThing = listOfThings[i];
				return chosenThing;
			}
		}
		return null;
	}

	// determine the sex of the character
	public void setSex() {
		String[] sex = {"female", "male"};
		double[] probability = {.5, .5};
		this.sex = weightedRNG(sex, probability);
	}
	// determine the race of the character
	public void setRace() {
		//TODO read in race names from a file
		String[] race = {"half-orc", "gnome", "halfling", "half-elf", "elf", "dwarf", "human"};
		double[] probability = {.04, .05, .08, .08, .10, .10, .55};
		this.race = weightedRNG(race, probability);
	}
	// determine the user-specified class of the character
	public void setChosenClass() {

	}
	// determine the random class of the character
	public void setRandomClass() {
		//TODO read in class names from file
		//TODO set probabilities on a by-race basis
		String[] classes = {"fighter", "cleric", "rogue", "wizard"};
		double[] probability = {.25, .25, .25, .25};
		className = weightedRNG(classes, probability);
	}

	public void setBAB(String type, int level) {
		switch (type) {
		case "full": 
			int[] fullBAB = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
			BAB = fullBAB[level];
			break;
		case "3/4":
			int[] threeFourthsBAB = {0,1,2,3,3,4,5,6,6,7,8,9,9,10,11,12,12,13,14,15};
			BAB = threeFourthsBAB[level];
			break;
		case "1/2":
			int[] halfBAB = {0,1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9,10};
			BAB = halfBAB[level];
			break;
		default:
			break;
		}
	}





	public int[] getAbilityScores() {
		abilityScores[0] = str.getAbilityScore();
		abilityScores[1] = dex.getAbilityScore();
		abilityScores[2] = con.getAbilityScore();
		abilityScores[3] = inte.getAbilityScore();
		abilityScores[4] = wis.getAbilityScore();
		abilityScores[5] = cha.getAbilityScore();
		return abilityScores;
	}

	public int[] getAbilityScoreModifiers() {
		abilityScoreModifiers[0] = str.getASM();
		abilityScoreModifiers[1] = dex.getASM();
		abilityScoreModifiers[2] = con.getASM();
		abilityScoreModifiers[3] = inte.getASM();
		abilityScoreModifiers[4] = wis.getASM();
		abilityScoreModifiers[5] = cha.getASM();
		return abilityScoreModifiers;
	}

	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	public String getRace() {
		return race;
	}
	public String getClassName() {
		return className;
	}
}
