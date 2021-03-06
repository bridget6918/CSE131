package lab1;

import cse131.ArgsProcessor;

public class Nutrition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap = new ArgsProcessor(args);
		String name = ap.nextString("name of the food");
		//accept the inputs
		double carbs = ap.nextDouble("number of grams of carbs");
		double fat = ap.nextDouble("number of grams of fat");
		double protein = ap.nextDouble("number of grams of protein");
		double statedCals = ap.nextDouble("number of calories stated");
		
		//convert each into Calories
		double calCarb = (double) (4*carbs*10/10);
		double calProtein = (double) (4*protein*10/10);
		double calFat = (double) (9*fat*10/10);
		double unavailable = (double) Math.round((calCarb + calProtein + calFat - statedCals)*10)/10;
		double fiber = (double) Math.round((unavailable/4)*10)/10;
		
		//calculate percentages of each
		double percentCarb = (double) Math.round((calCarb*100 / statedCals)*10)/10;
		double percentProtein = (double) Math.round((calProtein*100 / statedCals)*10)/10;
		double percentFat = (double) Math.round((calFat*100 / statedCals)*10)/10;
		
		//determine whether low-carb, low-fat
		boolean lowCarb = percentCarb / 100 < 0.25;
		boolean lowFat = percentFat / 100 < 0.15;
		
		//generate random # and flip a coin
		double rand = Math.random();
		boolean heads = rand < 0.5;
		
		System.out.println(name + " has" + "\n" 
				+ "\t" + carbs + " grams of carbohydrates = " + calCarb + " Calories" + "\n"
				+ "\t" +  fat + " grams of fat = " + calFat + " Calories" + "\n"
				+ "\t" +  protein + " grams of protein = " + calProtein + " Calories" + "\n");
		
		System.out.println("This food is said to have " 
				+ statedCals + " (available) Calories." + "\n"
				+ "With " + unavailable + " unavailable Calories, this food has "
				+ fiber + " grams of fiber.");
		
		System.out.println("Approximately" + "\n"
				+ "\t" +  percentCarb + "% " + "of your food is carbohydrates" + "\n"
				+ "\t" +  percentProtein + "% " + "of your food is protein" + "\n"
				+ "\t" +  percentFat + "% " + "of your food is fat" + "\n");
		
		System.out.println("This food is acceptable for a low-carb diet? " + lowCarb);
		
		System.out.println("This food is acceptalbe for a low-fat diet? " + lowFat);
		
		System.out.println("By coin flip, you should eat this food? " + heads);
	}

}
