package States;

import Model.Data;
import CalcGUI.CalculatorGui;
import CalcGUI.StateInterface;

public class ComputeState implements StateInterface{

	Data data;
	public String operation;
	double valueOfOperation;


	public ComputeState(String first, String second) {


		data = new Data(first, second);


	}

	public ComputeState(String str1, int opZero) {
		
		if(opZero==0) {
			
			valueOfOperation = 0;
			operation = "1/X";
			data = new Data(str1,"0");
		}
		else if(opZero==1) {
			
			valueOfOperation = 1;
			operation = "sqrt";
			data = new Data(str1,"0");		
		}
			
	}

	@Override
	public double sum (String number1, String number2 ) {

		double  value1 = Double.parseDouble(number1);
		double value2= Double.parseDouble(number2);
		return value1 + value2;

	}

	@Override
	public double substraction(String number1, String number2 ) {

		double  value1 = Double.parseDouble(number1);
		double value2= Double.parseDouble(number2);

		return value1 - value2;

	}
	@Override
	public double multiplication(String number1, String number2 ) {

		double  value1 = Double.parseDouble(number1);
		double value2= Double.parseDouble(number2);

		return value1 * value2;

	}

	@Override
	public double division(String number1, String number2 ) {

		double  value1 = Double.parseDouble(number1);
		double value2= Double.parseDouble(number2);
		double value = 0;
		if(value2 != 0 ) {
			value =  value1 / value2;

		}
		return value;
	}

	public double inverse(String number1, String number2 ) {

		double  value1 = Double.parseDouble(number1);
		double value2= Double.parseDouble(number2);
		double value = 0;
		if(value2 != 0 ) {
			value =  value1 - value2;

		}
		return value;
	}

	public String result(String compute) {



		if(compute.equals("+")) {

			return( "" + sum(data.getOne(),data.getTwo()));
		}
		else if((compute.equals("-"))){

			return "" + substraction(data.getOne(),data.getTwo());
		}
		else if((compute.equals("/"))) {

			return "" + division(data.getOne(),data.getTwo());
		}

		else if((compute.equals("*"))) {

			return "" + multiplication(data.getOne(),data.getTwo());
		}

		return  "" + 0;

	}

	public class ErrorState{

		final String error;

		public ErrorState() {

			error = "ERROR";


		}

		public String getString() {

			return error;
		}
	}


	public String resultFromInverse(String op) {

		if(Double.parseDouble(data.getOne()) == 0 && op.equals("1/X")) {

			return new ErrorState().getString();
		}
		
		else if (Double.parseDouble(data.getOne()) != 0 && op.equals("1/X")) {

			return "" + 1/Double.parseDouble(data.getOne()) ;

		}
		else if (op.equals("sqrt")) {
			
			if(Double.parseDouble(data.getOne()) < 0) {
				return new ErrorState().getString();
				
			}

			return "" + Math.sqrt(Double.parseDouble(data.getOne()));

		}
		else {
			
			return "" + 1;
		}



	}




}
