package stockPack;

import java.util.GregorianCalendar;
import static java.lang.System.out;
import java.util.Scanner;
public class Stocks {

	public static void main(String[] args){
		int startYear, startMonth, startDay;
		int endYear, endMonth, endDay;
		String ticker;
		Scanner key = new Scanner(System.in);
		
		/*out.println("Enter the stock you would like to look up (Ticker name)");
		ticker = key.nextLine();
		
		out.println("Enter the start date (Year, Month, Day)");
		startYear = key.nextInt();
		startMonth = key.nextInt();
		startDay = key.nextInt();
		
		out.println("Enter the end date (Year, Month, Day)");
		endYear = key.nextInt();
		endMonth = key.nextInt();
		endDay = key.nextInt();
		
		
			// month section is 0 based... January = 0, Feb = 1...etc
		GregorianCalendar start = new GregorianCalendar(startYear, startMonth, startDay);
		GregorianCalendar end = new GregorianCalendar(endYear, endMonth, endDay);
		StockDownloader test = new StockDownloader(ticker, end, start);
		*/
		
		GregorianCalendar start = new GregorianCalendar(2016, 11, 2);
		GregorianCalendar end = new GregorianCalendar(2016, 11, 2);
		StockDownloader test = new StockDownloader("PSIX", end, start);
		
		
		
		
		
		
		
	}
}
