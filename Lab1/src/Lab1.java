import java.util.Scanner;

import org.apache.poi.ss.formula.functions.FinanceLib;

public class Lab1 {
	public static void main(String[] args)
	{
		// Partners: Francis Field and Carson Hake
		// This program will ask the user for years worked, years retired, return rate before retirement
		// return rate after retirement, required income during requirement, and expected SSI income during 
		// retirement.  It will use this information to tell the user how much to save each month in order to 
		// meet the user's desired income during retirement.
		
		// Declaring all the necessary variables
		double annualReturnInvesting;
		double annualReturnPayment;
		double yearsRetired;
		double numberFuturePayments;
		double yearsWorked;
		double numberPayments;
		double requiredIncome;
		double expectedIncome;
		double presentValue;
		double remainingMoney;
		double payment;
		boolean bool = false;
		double PV;
		double PMT;
		// Obtaining the necessary information from the user.  While statements are used for 
		// input verification for the annualReturn variables.
		Scanner input = new Scanner(System.in);
		System.out.print("How many years do you plan to work?");
			yearsWorked = input.nextDouble();
		System.out.print("How long do you wish to draw?");
			yearsRetired = input.nextDouble();
		System.out.print("What is your expected average return on your investment? (Please enter value from 0-.2) ");
			annualReturnInvesting = input.nextDouble();
			while (annualReturnInvesting > .2 || annualReturnInvesting<0) 
			{
				System.out.print("Incorrect value entered.  Please enter a value from 0-.2");
				annualReturnInvesting = input.nextDouble();
			}
		System.out.print("What is your expected annual return on your payments? (Please enter a value from 0-.03)");
			annualReturnPayment = input.nextDouble();
			while (annualReturnPayment > .03 || annualReturnPayment<0) 
			{
				System.out.print("Incorrect value entered.  Please enter a value from 0-.03");
				annualReturnPayment = input.nextDouble();
			}
		System.out.print("What will be your required income?");
			requiredIncome = input.nextDouble();
		System.out.print("What will be your expected SSI income?");
			expectedIncome = input.nextDouble();
		// The appropriate variables are set up to be used with the FinanceLib class.  Then the FinanceLib.pv 
		// class is used to calculate the amount of money that needs to be saved before retirement.  Then that
		// value is used in the FinanceLib.pmt class as the future value to calculate the amount that needs to 
		// be saved each month.  This is then printed.
		numberFuturePayments = yearsRetired*12;
		numberPayments = yearsWorked*12;
		remainingMoney = 0;
		payment = requiredIncome - expectedIncome;
		annualReturnPayment = annualReturnPayment/12;
		annualReturnInvesting = annualReturnInvesting/12;
		
		PV = FinanceLib.pv(annualReturnPayment, numberFuturePayments, payment, remainingMoney, bool);
		presentValue = 0;
		PMT = FinanceLib.pmt(annualReturnInvesting, numberPayments, presentValue, PV, bool);
		System.out.printf("You need to save $%5.2f each month",PMT);
		}

}
