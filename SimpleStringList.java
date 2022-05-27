import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

public class SimpleStringList extends SimpleList {

	private String[] input;
		
	
	public SimpleStringList(Collection<String> strings) {
		input = strings.stream().toArray(String[]::new); // https://www.techiedelight.com/convert-list-string-array-string/
	}
	

	@Override
	public void sum() {
		output = "";
		for(String s : input) {
			output += s;
		}
	}


	@Override
	public void average() {
		output = "Error: Unable to average given input.";
	}
	

	@Override
	public void max() {
		Arrays.sort(input);
		output = input[input.length-1];
	}


	@Override
	public void min() {
		Arrays.sort(input);
		output = input[0];
	}
	
	
	
}
