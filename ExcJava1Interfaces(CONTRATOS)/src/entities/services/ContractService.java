package entities.services;

import entities.Contract;
import entities.Installment;

public class ContractService {

	public void processContract(Contract contract, Integer mounths) {

		Installment[] installment = new Installment[mounths];
		
		for (int i = 0; i <= installment.length; i++) {
			
			installment[i].setAmount(contract.getTotalValue() / i + 1);
			installment[i].setDueDate(contract.getDate());
			
			Double result;
			result = OnlinePaymentService.interest(installment[i].getAmount(), i);
		}

	}
}
