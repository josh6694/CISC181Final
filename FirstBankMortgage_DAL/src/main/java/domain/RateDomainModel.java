
package domain;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class RateDomainModel implements Serializable {
	
	private int RateID;
	private int MinCreditScore;
	private static double InterestRate;
	private static double Income;
	private double Expenses;
	private double HouseCost;
	public RateDomainModel(int rateID, int minCreditScore, double interestRate, double income,
			double expenses,double houseCost) {
		super();
		RateID = rateID;		
		MinCreditScore = minCreditScore;
		InterestRate = interestRate;
		Income=income;
		Expenses=expenses;
		HouseCost=houseCost;
	}

	public RateDomainModel(RateDomainModel per)
	{
		super();	
		RateID = per.getRateID();
		MinCreditScore = per.getMinCreditScore();
		InterestRate = RateDomainModel.getInterestRate();
		Income=RateDomainModel.getIncome();
		Expenses=per.getExpenses();
		HouseCost=per.getHouseCost();
	}
	
	
	
	
	public RateDomainModel()
	{
	}
	public double getHouseCost(){
		return HouseCost;
	}		

	public double getExpenses(){
		return Expenses;
	}
	public static double getIncome(){
		return Income;
	}
	public int getRateID() {
		return RateID;
	}
	public void setRateID(int rateID) {
		RateID = rateID;
	}
	public int getMinCreditScore() {
		return MinCreditScore;
	}
	public void setMinCreditScore(int minCreditScore) {
		MinCreditScore = minCreditScore;
	}
	public static double getInterestRate() {
		return InterestRate;
	}
	public void setInterestRate(double interestRate) {
		InterestRate = interestRate;
	}
	
	
}