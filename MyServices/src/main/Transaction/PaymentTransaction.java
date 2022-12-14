package main.Transaction;

public class PaymentTransaction extends Transaction implements ITransaction
{
	public PaymentTransaction(int userid, String Service, int amount) {
		this.Service = Service;
		this.amount = amount;
		TransactionCounter.TCounter++;
		TransactionID = TransactionCounter.TCounter;
		this.userId = userid;
		type = "Payment Transaction";
	}
	
	@Override
	public void printTransaction() 
	{
		System.out.println(userId+"/t"+TransactionID+"/t"+Service+"/t"+amount+"/t"+type);
	}
}
