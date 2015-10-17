import java.util.*;
public class DieRoller {


	public static int rollDie(String input) {
		
		// TODO Input Validation for custom entering formula
		// MUST BE IN FORM: #d#l#r#+# 
		
		int rollValue = 0;
		int dropped = 0;
		int reroll = 0;
		
		String parsePlus = input;
		String delimsPlus = "[+]+";
		String[] initialBreak = parsePlus.split(delimsPlus);
		
		for (int i = 0; i < initialBreak.length; i++) {
			// Check if the die can be rerolled
			if (initialBreak[i].contains("r")) {
				String parseReroll = initialBreak[i];
				String delimsR = "[r]+";
				String[] rBreak = parseReroll.split(delimsR);
				reroll = Integer.parseInt(rBreak[1]);
				initialBreak[i] = rBreak[0];
			}
			// Check if the roll drops the lowest die numbers
			if (initialBreak[i].contains("l")) {
				String parseLow = initialBreak[i];
				String delimsL = "[l]+";
				String[] lBreak = parseLow.split(delimsL);
				dropped = Integer.parseInt(lBreak[1]);
				initialBreak[i] = lBreak[0];
			}
			// Check what type of die is being rolled
			if (initialBreak[i].contains("d")) {
				String parseDie = initialBreak[i];
				String delimsDie = "[d]+";
				String[] diceAndSide = parseDie.split(delimsDie);
				rollValue += (roller(Integer.parseInt(diceAndSide[0]), Integer.parseInt(diceAndSide[1]), dropped, reroll));
			} else {
				rollValue += (Integer.parseInt(initialBreak[i]));
			}
			dropped = 0;
			reroll = 0;
		}
		return rollValue;
	}

	private static int roller(int dice, int side, int droppedDice, int reRollNumber) {
		ArrayList<Integer> rollList = new ArrayList<Integer>();
		Random RNG = new Random();
		int rolling = 0;
		for (int i = 0; i < dice; i++) {
			rollList.add(RNG.nextInt(side) + 1);
			while (rollList.get(i) < reRollNumber) {
				rollList.remove(i);
				rollList.add(RNG.nextInt(side) + 1);
			}
		}
		for (int j = 0; j < droppedDice; j++) {
			Integer removeLowest = Collections.min(rollList);
			rollList.remove(removeLowest);
		}
		for(int k = 0; k < rollList.size(); k++) {
			rolling += rollList.get(k);
		}
		rollList.removeAll(rollList);
		return rolling;
	}
}
