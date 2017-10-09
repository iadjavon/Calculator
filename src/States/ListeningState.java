package States;

public class ListeningState {

	String firstNumber;
	String secondNumber;
	public String operation;
	String [ ]memory;
	public ComputeState computer;

	/*
	 * instantiate a listener state
	 */
	public ListeningState(String dtr) {

		//we parse the string from the text field and initialise the memory array
		parserMachine( dtr);
		//assign the first number
		firstNumber = memory[0];
		//assingn the second number
		secondNumber = memory[1];
		//assign the operation
		//operation = memory[2];
		//instantiate a compute state object
		computer = new ComputeState(firstNumber,secondNumber);

	}

	public ListeningState(String str, int zero) {

		if(zero == 0) {

			firstNumber = str;
			secondNumber = "0";
			operation = "1/X";
			memory = null;
			computer = new ComputeState(str, 0);

		}
		if(zero == 1) {
			firstNumber = str;
			secondNumber = null;
			operation = "sqrt";
			memory = null;
			computer = new ComputeState(firstNumber, 1);
		}


	}

	/*
	 * This method parse the string read from the text field
	 * of the calculator and instantiate the memory field
	 */
	public void parserMachine( String toBeParsed) {

		if(toBeParsed.contains("+")) {
			operation = "+";
			System.out.println(operation);
		}
		if(toBeParsed.contains("-")) {
			operation = "-";
		}
		if(toBeParsed.contains("*")) {
			operation = "*";
		}
		if(toBeParsed.contains("/")) {
			operation = "/";
		}

		String delimiters = "[+\\-/*]+";
		memory = toBeParsed.split(delimiters);
		for (int i = 0 ; i < memory.length;i++ ) {

			System.out.println(memory[i]);
		}

	}


}
