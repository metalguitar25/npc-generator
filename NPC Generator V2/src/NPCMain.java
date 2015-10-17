
public class NPCMain {

	public static void main(String[] args) {
		int[] ab = new int[6];
		int[] abm = new int[6];
		Character c = new Character("Name");
		ab = c.getAbilityScores();
		abm = c.getAbilityScoreModifiers();
		for (int i = 0; i < 6; i++) {
			System.out.println(ab[i] + " " + abm[i]);
		}
		System.out.println(c.getName() + " is a " + c.getSex() + " " + c.getRace());

	}

}
