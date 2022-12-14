package main.Payment;

import main.Transaction.ITransaction;
import main.Transaction.PaymentTransaction;
import main.Transaction.TransactionControl;

public class PaymentControl extends Discount{
	
	public int getBill(String service, int UID, int amount)
	{
		Bill bill = new ConcreteBill(service,amount);
		
		if (serviceDiscount(service))
		{
			Bill billSerDisBill = new ServiceDiscount(bill);
			
			if (overallDiscount(UID))
			{
				Bill billOverallDisBill = new ServiceDiscount(billSerDisBill);
				billOverallDisBill.getbill();
				System.out.println("Service & Overall Discount Applied");
				return billOverallDisBill.getAmount();
			}
			else 
			{
				billSerDisBill.getbill();
				System.out.println("Service Discount Applied");
				return billSerDisBill.getAmount();
			}
		}
		
		else if (overallDiscount(UID))
		{
			Bill billOverallDisBill = new ServiceDiscount(bill);
			billOverallDisBill.getbill();
			System.out.println("Overall Discount Applied");
			return billOverallDisBill.getAmount();
		}
		
		else 
		{
			bill.getbill();
			System.out.println("No Discount Applied");
			return bill.getAmount();
		}
	}
	
	public void payBill(int amount, int choice)
	{
		PaymentMethod paymentMethod;
		switch (choice) 
		{
			case 1: 
			{
				paymentMethod = new Cash();
				paymentMethod.pay(amount);
			}
			case 2: 
			{
				paymentMethod = new Credit_Card();
				paymentMethod.pay(amount);
			}
			case 3: 
			{
				paymentMethod = new WalletPay();
				paymentMethod.pay(amount);
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
		}
	}
	
	public void createTransaction(int UID, String service, int amount)
	{
		TransactionControl tControl = new TransactionControl();
		tControl.newPaymentTransaction(UID, service, amount);
		System.out.println("Transaction Completed Successfully");
	}
}
