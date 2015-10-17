
public class AbilityScore {
	//Instance variables
	double abilityScore;
	double abilityScoreModifier;
	//Constructor for AbilityScore
	public AbilityScore(int abilityScore) {
		this.abilityScore = (double) abilityScore;
		setASM();
	}
	//modify ability scores if needed
	public void setASFromClass(double as) {
		abilityScore = as;
		setASM();
	}
	//calculate ability score modifier
	public void setASM() {
		abilityScoreModifier = Math.round(((abilityScore - 10) / 2) - .1);
	}
	//add one from leveling 4,8,12,16,20
	public void addOne(double as) {
		abilityScore = as + 1;
		setASM();
	}
	//return the ability score
	public int getAbilityScore() {
		return (int) abilityScore;
	}
	//return the ability score modifier
	public int getASM() {
		return (int) abilityScoreModifier;
	}
}
