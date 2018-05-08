package mjack.net;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import java.util.Random;

public class PlayerMat {
	
	public final static int[][] LegalTRAs = new int[][] {
		new int[]{1,2,3,4},
		new int[]{1,2,4,3},
		new int[]{1,3,2,4},
		new int[]{1,3,4,2},
		new int[]{1,4,2,3},
		new int[]{1,4,3,2},
		
		new int[]{2,1,3,4},
		new int[]{2,1,4,3},
		new int[]{2,3,1,4},
		new int[]{2,3,4,1},
		new int[]{2,4,1,3},
		new int[]{2,4,3,1},
		
		new int[]{3,1,2,4},
		new int[]{3,1,4,2},
		new int[]{3,2,1,4},
		new int[]{3,2,4,1},
		new int[]{3,4,1,2},
		new int[]{3,4,2,1},
		
		new int[]{4,1,2,3},
		new int[]{4,1,3,2},
		new int[]{4,2,1,3},
		new int[]{4,2,3,1},
		new int[]{4,3,1,2},
		new int[]{4,3,2,1}
	};
	
	
	public final static int[][] LegalCoins = new int[][] {
		new int[] {3,3,0,0},
		new int[] {2,2,2,0},
		new int[] {2,2,0,2},
		new int[] {1,2,3,0},
		//new int[] {1,2,0,3},
		new int[] {1,3,2,0},
		//new int[] {1,3,0,2},
		new int[] {2,1,3,0},
		new int[] {2,1,0,3},
		new int[] {2,3,1,0},
		new int[] {2,3,0,1},
		new int[] {3,1,2,0},
		new int[] {3,1,0,2},
		new int[] {3,2,1,0},
		new int[] {3,2,0,1}
	};
	
	public final static int[][][] LegalBRACosts = new int[][][] {
		new int[][] {{2,4,4,3}, {2,1,2,2}},
		new int[][] {{2,4,4,3}, {2,1,3,1}},
		new int[][] {{2,4,4,3}, {2,2,2,1}},
		new int[][] {{2,4,4,3}, {2,2,1,2}},
		new int[][] {{2,4,4,3}, {2,3,1,1}},
		new int[][] {{2,4,3,4}, {2,1,2,2}},
		new int[][] {{2,4,3,4}, {2,1,1,3}},
		new int[][] {{2,4,3,4}, {2,2,1,2}},
		new int[][] {{2,4,3,4}, {2,2,2,1}},
		new int[][] {{2,4,3,4}, {2,3,1,1}},
		new int[][] {{2,3,4,4}, {2,2,1,2}},
		new int[][] {{2,3,4,4}, {2,1,1,3}},
		new int[][] {{2,3,4,4}, {2,1,2,2}},
		new int[][] {{2,3,4,4}, {2,2,2,1}},
		new int[][] {{2,3,4,4}, {2,1,3,1}},
		new int[][] {{3,4,3,3}, {3,1,1,2}},
		new int[][] {{3,4,3,3}, {3,1,2,1}},
		new int[][] {{3,4,3,3}, {3,2,1,1}},
		new int[][] {{3,3,4,3}, {3,1,1,2}},
		new int[][] {{3,3,4,3}, {3,1,2,1}},
		new int[][] {{3,4,4,3}, {3,2,1,1}},
		new int[][] {{3,3,3,4}, {3,1,1,2}},
		new int[][] {{3,3,3,4}, {3,1,2,1}},
		new int[][] {{3,3,3,4}, {3,2,1,1}},
		new int[][] {{3,4,3,3}, {2,1,2,2}},
		new int[][] {{3,4,3,3}, {2,2,1,2}},
		new int[][] {{3,4,3,3}, {2,2,2,1}},
		new int[][] {{3,4,3,3}, {2,3,1,1}},
		new int[][] {{3,3,4,3}, {2,2,1,2}},
		new int[][] {{3,3,4,3}, {2,1,2,2}},
		new int[][] {{3,3,4,3}, {2,2,2,1}},
		new int[][] {{3,3,4,3}, {2,1,3,1}},	
		new int[][] {{3,3,3,4}, {2,2,2,1}},
		new int[][] {{3,3,3,4}, {2,1,2,2}},
		new int[][] {{3,3,3,4}, {2,2,1,2}},
		new int[][] {{3,3,3,4}, {2,1,1,3}},
		new int[][] {{3,4,3,3}, {1,3,1,2}},
		new int[][] {{3,4,3,3}, {1,3,2,1}},
		new int[][] {{3,3,4,3}, {1,1,3,2}},
		new int[][] {{3,3,4,3}, {1,2,3,1}},
		new int[][] {{3,3,3,4}, {1,2,1,3}},
		new int[][] {{3,3,3,4}, {1,1,2,3}}
	};
	
	
	public String name;
	public int[] topRowAction;
	public int[] initialResourceCost;
	public int[] finalResourceCost;
	public int[] coins;
	public int matNumber;
	public int bonusCoins;
	public int bonusPop;

	public PlayerMat() {		
	}	
	
	public boolean validatePlayerMat() {
		//Validate name
		if (name == null || name.length() > 20) return false;

		//Validate TRA
		if (topRowAction == null || topRowAction.length != 4) return false;
		for (int x = 0; x < 4; x++) {
			if (topRowAction[x] < 1 || topRowAction[x] > 4) return false;
			for (int y = x+1; y< 4; y++) {
				if (topRowAction[x] == topRowAction[y]) return false;				
			}
		}
		
		//Validate initialResourceCost 
		if (initialResourceCost == null || initialResourceCost.length != 4) return false;
		for (int x = 0; x < 4; x++) {
			if (initialResourceCost[x] < 2 || initialResourceCost[x] > 4) return false;
		}

		//Validate finalResourceCost 
		if (finalResourceCost == null || finalResourceCost.length != 4) return false;
		for (int x = 0; x < 4; x++) {
			if (finalResourceCost[x] < 1 || finalResourceCost[x] > 4) return false;
			if (finalResourceCost[x] > initialResourceCost[x]) return false;
			if (initialResourceCost[x] == 2 && finalResourceCost[x] != 2) return false;
		}

		//validate coins
		if (coins == null || coins.length != 4) return false;
		for (int x = 0; x < 4; x++) {
			if (coins[x] < 0 || coins[x] > 3) return false;
		}

		//validate matNumber
		if (matNumber < 1 || matNumber > 7) return false;
		
		//validate bonusCoins
		if (bonusCoins < 1 || bonusCoins > 9) return false;

		//validate bonusPop
		if (bonusPop < 1 || bonusPop > 7) return false;
		
		return true;
	}
	
	public static PlayerMat getRandomMat(Properties nameProperties) {
		
		PlayerMat mat = new PlayerMat();
		Random rand = new Random();
				
		mat.topRowAction = Arrays.copyOf(LegalTRAs[rand.nextInt(LegalTRAs.length)],4);
		int bra = rand.nextInt(LegalBRACosts.length);
		mat.initialResourceCost = Arrays.copyOf(LegalBRACosts[bra][0], 4);
		mat.finalResourceCost = Arrays.copyOf(LegalBRACosts[bra][1], 4);
		
		int[] unsortedCoins = LegalCoins[rand.nextInt(LegalCoins.length)];
		mat.coins = new int[4];
		for (int i = 0; i < 4; i++) {
			mat.coins[i] = unsortedCoins[mat.topRowAction[i]-1];
		}
		
		ArrayList<String> nameList = new ArrayList<String>(nameProperties.stringPropertyNames());		
		mat.name = nameList.get(rand.nextInt(nameList.size()));		
		mat.matNumber = rand.nextInt(7)+1;
		
		mat.bonusCoins = rand.nextInt(3)+mat.matNumber;
		mat.bonusPop = mat.matNumber+5-mat.bonusCoins;
		
		return mat;
	}
	
	public static int BOLSTER=1, PRODUCE=2, MOVE=3, TRADE=4;
	public static int UPGRADE=1, DEPLOY=2, BUILD=3, ENLIST=4;
	
	public static String tra(int action) {
		switch (action) {
			case 1: return "Bolster";
			case 2: return "Produce";
			case 3: return "Move";
			case 4:	return "Trade";
		}
		return null;
	}
	
	public static String bra(int action) {
		switch (action) {
			case 1: return "Upgrade";
			case 2: return "Deploy";
			case 3: return "Build";
			case 4:	return "Enlist";
		}
		return null;
	}	
}
