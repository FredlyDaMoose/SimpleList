import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class SimpleListRunner {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		// PROMPT USER FOR ARRAY INPUT

		System.out.print("Enter a list of values: ");
		String values = input.nextLine();
		
		SimpleList simpleList;
		
		List<String> stringArray = Arrays.asList(values.replaceAll(",", "").split(" "));
		
		// Try to convert to integers
		ArrayList<Integer> intArray = new ArrayList<Integer>();
		boolean isIntegerInput = parseIntegerArrayList(stringArray, intArray);
		
		// PROMPT USER FOR OPERATION INPUT
		if(isIntegerInput)
		{
			simpleList = new SimpleIntegerList(intArray);
			System.out.print("Enter an operation (sum, average, min, max): ");

		} else {
			simpleList = new SimpleStringList(stringArray);
			System.out.print("Enter an operation (sum, min, max): ");

		}
		
		boolean validInput = true;
		
		do {
			values = input.next(); //reusing variable
			switch(values) {
			
			case "sum": 
				simpleList.sum();
				break;
				
			case "average": 
				simpleList.average();
				break;
				
			case "min": 
				simpleList.min();
				break;

			case "max": 
				simpleList.max();
				break;

			default:
				System.out.println("Invalid Input. Try again.");
				validInput = false;
				
			} 
		} while(!validInput); //use dowhile to avoid having to put four "validInput = true;"
		
		System.out.print("Output: " + simpleList.getOutput() + "\n");
		
		input.close();
		
	}

	/**
	 * Adds parsed integer from a given string collection to a given array list.
	 * 
	 * @param inStringArray The string collection to parse integers from.
	 * @param inIntegerArrayList The integer array list to add parsed integers to.
	 * @return True if all values were successfully parsed.
	 */
	private static final boolean parseIntegerArrayList(Collection<String> inStringArray, ArrayList<Integer> inIntegerArrayList) {
		
		boolean isIntegerInput = true;
		
		for(String s : inStringArray) {
			try {
				inIntegerArrayList.add(Integer.parseInt(s));
			} catch(NumberFormatException e) {
				return false;
			}
		}
		
		return true;
		
	}
	
}
