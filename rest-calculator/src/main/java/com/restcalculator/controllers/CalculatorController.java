package com.restcalculator.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restcalculator.models.Result;
import com.restcalculator.models.operations.AddOperation;
import com.restcalculator.models.operations.DivideOperation;
import com.restcalculator.models.operations.MultiplyOperation;
import com.restcalculator.models.operations.OperationInterface;
import com.restcalculator.models.operations.SubtractOperation;
import com.restcalculator.util.Constants;


@RestController
@RequestMapping(Constants.CALCULATOR_PATH)
@CrossOrigin()
public class CalculatorController {
	
	
	private static final Logger logger = LogManager.getLogger(CalculatorController.class);

	/**
	 * this method is responsible for addition operations only
	 * @param operation
	 * @return
	 */
	@PostMapping("/add")
	public Result add(@RequestBody AddOperation operation) {
		
		logger.info("Calling add operation!");
		
		Result result = new Result();
		
		if(operation != null) {
			logger.info("Input data:" + operation.toString());
			result = this.doOperation(operation);
		}else {
			logger.error("Operation is null");
			result.setError(Boolean.TRUE);
			result.setMessage("Operation is not initializzed");
		}
		
		return result;
	}
	
	/**
	 * this method is responsible for subtraction operations only
	 * @param operation
	 * @return
	 */
	@PostMapping("/substract")
	public Result subtract(@RequestBody SubtractOperation operation) {

		logger.info("Calling substract operation!");
		Result result = new Result();

		if(operation != null) {
			logger.info("Input data: " + operation.toString());
			result = this.doOperation(operation);
		}else {
			logger.error("Operation is null");
			result.setError(Boolean.TRUE);
			result.setMessage("Operation is not initializzed");
		}
		
		return result;
	}
	
	/**
	 * this method is responsible for multiplication operations only
	 * @param operation
	 * @return
	 */
	@PostMapping("/multiply")
	public Result multiply(@RequestBody MultiplyOperation operation) {
		
		logger.info("Calling multiply operation!");
		Result result = new Result();

		if(operation != null) {
			logger.info("Input data: " + operation.toString());
			result = this.doOperation(operation);
		}else {
			logger.error("Operation is null");
			result.setError(Boolean.TRUE);
			result.setMessage("Operation is not initializzed");
		}
		
		return result;
	}
	
	/**
	 * this method is responsible for division operations only
	 * @param operation
	 * @return
	 */
	@PostMapping("/divide")
	public Result divide(@RequestBody DivideOperation operation) {

		logger.info("Calling divide operation!");
		Result result = new Result();
		
		if(operation != null) {
			logger.info("Input data: " + operation.toString());
			result = this.doOperation(operation);
		}else {
			logger.error("Operation is null");
			result.setError(Boolean.TRUE);
			result.setMessage("Operation is not initializzed");
		}
		return result;
	}
	
	
	/**
	 * this method is responsible for executing the operation and catching error if there is one.
	 * @param operation
	 * @return Result object with the result of the operation and with 
	 */
	private Result doOperation(OperationInterface operation){
		
		Result result = null;
		try {
			logger.info("Executing the operation.");
			result = operation.run();
		}catch(Exception ex) {
			logger.error("Error during execution of doOperation method: ", ex);
			result.setError(Boolean.TRUE);
			result.setMessage("Ops! something wrong happened while executing doOperation!");
		}
		
		logger.info("Final operation result : " + result.toString());
		
		return result;

	}

}
