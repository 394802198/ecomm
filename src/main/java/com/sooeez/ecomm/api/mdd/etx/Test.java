package com.sooeez.ecomm.api.mdd.etx;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

	public Test() {
	}

	public static void main(String[] args) {
//		String json = EcommHttp.postRequest("http://www.mdd.co.nz/mddAPI/OrderList.php?account=Ecomm&key=f12535b111713d1fced74e08994c1882&storage=1&status=1");
//		System.out.println(json);
//		
//		ObjectMapper mapper = new ObjectMapper();
//		try {
//			OrderList orderList = mapper.readValue(json, OrderList.class);
//			System.out.println(orderList.toString());
//			orderList.getData().forEach(sub -> {
//				System.out.println(sub.toString());
//			});
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		ZonedDateTime.of(localDateTime, zone)
//		ZonedDateTime.from(temporal)
//		DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
//		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		
		SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date date = null;
		try {
			date = isoFormat.parse("1450779854");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		// 
		System.out.println(isoFormat.format(date));

	}

}
