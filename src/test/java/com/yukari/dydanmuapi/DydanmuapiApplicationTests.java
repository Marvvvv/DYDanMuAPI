package com.yukari.dydanmuapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class DydanmuapiApplicationTests {

	@Test
	public void contextLoads() {
	}


	@Test
	public void test () {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(new Date());
		int a = calendar.get(Calendar.MONTH);
		System.out.println(a);

	}


}
