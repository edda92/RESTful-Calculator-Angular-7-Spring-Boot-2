package com.restcalculator.models.operations;

import com.restcalculator.models.Result;

public interface OperationInterface {
	
	/**
	 * Run method execute the proper operation for each implementation of this interface.
	 * See the implemented interface for more detail about the operation executed.
	 * @return Result of the executed operation
	 * @throws Exception
	 */
	public Result run() throws Exception;

}
