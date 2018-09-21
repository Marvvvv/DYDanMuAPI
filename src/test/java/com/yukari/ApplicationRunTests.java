package com.yukari;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ApplicationRunTests {

	@Test
	public void contextLoads() {
	}


	@Test
	public void test () throws ParseException {

		List<String> onlineLength = new ArrayList<>();
		onlineLength.add("3小时55分钟");
		onlineLength.add("2小时25分钟");
		onlineLength.add("3小时48分钟");
		onlineLength.add("1小时58分钟");
		onlineLength.add("0小时56分钟");
		onlineLength.add("0小时4分钟");

		long totalLength = 0L;

		long oneHour = 1000 * 60 * 60;
		long oneMin = 1000 * 60;

		for (String time : onlineLength) {
			Pattern pa = Pattern.compile("[0-9]\\d*");
			Matcher ma = pa.matcher(time);
			List<Long> t = new ArrayList<>();
			while (ma.find()) {
				t.add(Long.parseLong(ma.group()));
			}

			totalLength += (t.get(0) * oneHour) + (t.get(1) * oneMin);
			System.out.println(1);
		}
		System.out.println(formatDuring(totalLength));


	}


	@Test
	public void test2 () {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.HOUR,-1);
		String startTime = sdf.format(calendar.getTime());
		System.out.println(startTime);
		calendar.add(Calendar.HOUR,+2);
		String endTime = sdf.format(calendar.getTime());
		System.out.println(endTime);

	}



	// 毫秒转换为XX小时XX分钟
	private String formatDuring (long mss){
		long hours = mss / (1000 * 60 * 60);
		long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
		return hours + "小时" + minutes +"分钟";
	}

}
