package com.restcalculator.models.operations;

import java.math.BigDecimal;

import com.restcalculator.models.Result;
import com.restcalculator.util.Constants;

public class DivideOperation extends OperationAbstract {
	
	private final BigDecimal ZERO = new BigDecimal(0);
	
	@Override
	public Result run() throws Exception {
		
		Result result = new Result();

		if(this.operand1 != null && this.operand2 != null) {
			if(operand2.compareTo(ZERO) == 0) {
				result.setError(Boolean.TRUE);
				result.setMessage(Constants.ERROR_MESSAGE_DIVIDE_BY_ZERO);
				getLogger().error("Can't divide by Zero");
			}else {
				result.setResult(operand1.divide(operand2));
				result.setError(Boolean.FALSE);
			}
		}else {
			result.setError(Boolean.TRUE);
			result.setMessage(Constants.ERROR_MESSAGE_OPERAND_NOT_VALID);
			getLogger().error("One of the operands is not valid" + this.toString());
		}

		return result;
	}

	
	@Override
	public String toString() {
		return "DivideOperation [getOperand1()=" + getOperand1() + ", getOperand2()=" + getOperand2() + "]";
	}

}
