import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

public class SimpleIntegerList extends SimpleList {

	private int[] input;
		
	
	public SimpleIntegerList(Collection<Integer> integers) {
		input = integers.stream().mapToInt(Integer::intValue).toArray(); //https://stackoverflow.com/questions/960431/how-can-i-convert-listinteger-to-int-in-java		
	}

	@Override
	public void sum() {
		int sum = 0;
		for(int i : input) {
			sum += i;
		}
		output = Integer.toString(sum);
	}


	@Override
	public void average() {
		
		// probably dumb to have to parse output and turn it into a string again but i wanted to reuse code
		sum();
		
		output = Float.toString((float) Integer.parseInt(output) /  input.length); //output can only be integer values so no need to try catch
		
	}
	

	@Override
	public void max() {
		Arrays.sort(input);
		output = Integer.toString(input[input.length-1]);
	}


	@Override
	public void min() {
		Arrays.sort(input);
		output = Integer.toString(input[0]);
	}
	
	
	
}
