package kodlamaio.hrms.core.utilities.result.BusinessRules;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;

public class BusinessRules {

	public static Result Run(Result... logics) {
		for (Result logic : logics) {
			if (!logic.isSuccess()) {
				return logic;
			}
		}
		return new SuccessResult();
	}
}
