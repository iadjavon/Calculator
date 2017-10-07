package States;

import Model.Data;

public class ComputeState {

	Data data;
	String operation;


	public ComputeState(String first, String second, String op) {


		new Data(first, second);
		operation = op;

	}


	public double sum (String number1, String number2 ) {

		double  value1 = Double.parseDouble(number1);
		double value2= Double.parseDouble(number2);
		return value1 + value2;

	}

	public double substratction(String number1, String number2 ) {

		double  value1 = Double.parseDouble(number1);
		double value2= Double.parseDouble(number2);

		return value1 - value2;

	}

	public double division(String number1, String number2 ) {

		double  value1 = Double.parseDouble(number1);
		double value2= Double.parseDouble(number2);
		double value = 0;
		if(value2 != 0 ) {
			value =  value1 - value2;

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

}
