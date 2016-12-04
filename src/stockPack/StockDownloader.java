package stockPack;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class StockDownloader {
	// hello
	public static final int DATE = 0;
	public static final int OPEN = 1;
	public static final int HIGH = 2;
	public static final int LOW = 3;
	public static final int CLOSE = 4;
	public static final int VOLUME = 5;
	public static final int ADJCLOSE = 6;
	
	private ArrayList<GregorianCalendar> dates;
	private ArrayList<Double> opens;
	private ArrayList<Double> highs;
	private ArrayList<Double> lows;
	private ArrayList<Double> closes;
	private ArrayList<Integer> volumes;
	private ArrayList<Double> adjCloses;

	
	
	
	public StockDownloader(String symbol, GregorianCalendar start, GregorianCalendar end) {
		dates = new ArrayList<GregorianCalendar>();
		opens = new ArrayList<Double>();
		highs = new ArrayList<Double>();
		lows = new ArrayList<Double>();
		closes = new ArrayList<Double>();
		volumes = new ArrayList<Integer>();
		adjCloses = new ArrayList<Double>();
		
			// Gives the yahoo finanace url, + any symbol you give based on past 3 years. Also inputs your dates that you want
		String url = "http://chart.finance.yahoo.com/table.csv?s=" + symbol + 
				"&a=" + start.get(Calendar.MONTH) +
				"&b=" + start.get(Calendar.DAY_OF_MONTH)+ 
				"&c=" + start.get(Calendar.YEAR) + 
				"&d=" + end.get(Calendar.MONTH)+ 
				"&e=" + end.get(Calendar.DAY_OF_MONTH)+ 
				"&f=" + end.get(Calendar.YEAR)+ 
				"&g=d&ignore=.csv";					// Will be consistent among different stocks
		
		try {
			URL yhoofin = new  URL(url);
			URLConnection data = yhoofin.openConnection();
			Scanner input = new Scanner(data.getInputStream());
			if ( input.hasNext()){        // this skips the line because it just the header
				input.nextLine();
			}
			// start reading the data
			while ( input.hasNextLine()){
				String line = input.nextLine();
				String[] holder = line.split(",");
				
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				Date date = df.parse(holder[0]);
				GregorianCalendar cal = new GregorianCalendar();
				cal.setTime(date);
				
				dates.add(cal);
				opens.add(Double.parseDouble(holder[1]));
				highs.add(Double.parseDouble(holder[2]));
				lows.add(Double.parseDouble(holder[3]));
				closes.add(Double.parseDouble(holder[4]));
				volumes.add(Integer.parseInt(holder[5]));
				adjCloses.add(Double.parseDouble(holder[6]));
				
				System.out.println(getAdjCloses());
			}
		}
		catch ( Exception e){
			System.err.println(e);
		}
	}
	
	public ArrayList<GregorianCalendar> getDates(){
		return dates;
	}
	public ArrayList<Double> getOpens(){
		return opens;
	}
	public ArrayList<Double> getHighs(){
		return highs;
	}
	public ArrayList<Double> getLows(){
		return lows;
	}
	public ArrayList<Double> getCloses(){
		return closes;
	}
	public ArrayList<Integer> getVolumes(){
		return volumes;
	}
	public ArrayList<Double> getAdjCloses(){
		return adjCloses;
	}
}
