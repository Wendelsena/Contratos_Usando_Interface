package entities.services;

public class PaypalService implements OnlinePaymentService {

	public Double paymentFee(Double amount) {
		return amount * 0.01;
	}
	
	public Double interest(Double amount, Integer months) {
		return (paymentFee(amount) * 0.02) * months;
	}
}
