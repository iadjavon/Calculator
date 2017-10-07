package States;

public class ListeningState {

	String firstNumber;
	String secondNumber;
	String operation;
	String [ ]memory;


	public ListeningState(String dtr) {

		parserMachine( dtr);
		firstNumber = memory[0];
		secondNumber = memory[1];
		operation = memory[2];
		new ComputeState(firstNumber,secondNumber,operation);

	}

	public void parserMachine( String toBeParsed) {

		String delimiters = "[+\\-/*1/x]+";
		memory = toBeParsed.split(delimiters);

	}
	
//	public void numberPaneListener() {
//		
//		for(int i = 0; i < )
//		
//		
//		
//	}


	
	
	
	

}
