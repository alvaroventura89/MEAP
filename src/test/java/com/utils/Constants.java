package com.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Constants {

    

                
	 // Create object of SimpleDateFormat class and decide the format
	 static DateFormat dateFormat = new SimpleDateFormat("MM.dd.yyyy");

	 //get current date time with Date()
	 static Date date = new Date();
	 
	 static // Now format the date
	 String date1= dateFormat.format(date);

	 static SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd' 'HH.mm.ss z");
		static Date date2 = new Date(System.currentTimeMillis());
		static String actualDate = formatter.format(date2);

        public static final String BASE_PROPERTIES_FILEPATH = "src/test/resources/configs/meap.base.properties";
        public static final String CREDENTIALS_FILEPATH="src/test/resources/configs/";
	public static final String CREDENTIALS_FILENAME=".credentials.properties";
	public static final String REPORT_FILENAME="Automated Test MEAP "+actualDate+".html";	
	public static final String OS_NAME= System.getProperty("os.name");
	public static final String TEST_DATA= "src/test/resources/testdata/testdata.properties";
	

	 
	
	

}
