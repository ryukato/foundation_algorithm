package hacker.rank.problems;

import static org.junit.Assert.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class TimeConversion {
	@Test
	public void test_(){
		String inputDate = "12:05:45PM";
		assertEquals("00:05:45", TwentyfourHourFormatter.convert(inputDate));
		
		inputDate = "02:05:45AM";
		assertEquals("02:05:45", TwentyfourHourFormatter.convert(inputDate));
		
		inputDate = "10:05:45AM";
		assertEquals("10:05:45", TwentyfourHourFormatter.convert(inputDate));
		
		inputDate = "12:00:00AM";
		assertEquals("00:00:00", TwentyfourHourFormatter.convert(inputDate));
	}

	enum MERIDIAN{
		AM,PM;
	}
	
	private static class TwentyfourHourFormatter{
		private static final String format = "([0-9]{2}):([0-9]{2}):([0-9]{2})(PM|AM)";
		private final static Pattern pattern  = Pattern.compile(format);
		
		public static String convert(String inputDate) {
			Matcher matcher = pattern.matcher(inputDate);
			if(matcher.matches()){
				String minute = matcher.group(2);
				String second = matcher.group(3);
				String amPm = matcher.group(4);
				
				String convertedHour = getConvertedHour(matcher.group(1), amPm);
				return format(convertedHour, minute, second);
				
			}
			return inputDate;
		}


		private static String format(String hour, String minute, String second) {
			hour = hour.length() == 1?"0".concat(hour):hour;
			return String.format("%s:%s:%s", hour, minute, second);
		}
		
		
		private static String getConvertedHour(String hour, String amPm) {
			int hourValue = Integer.parseInt( hour);
			if(hourValue > 12){
				throw new IllegalArgumentException("Not allowed input hour greater than 12 : "+ hour);
			}
			String convertedHour = String.valueOf((hourValue + 12) % 24);
			if(MERIDIAN.AM.name().equals(amPm) && (hourValue < 12)){
				convertedHour = String.valueOf(hourValue % 24);
			}
			return convertedHour;
		}
	}
}
