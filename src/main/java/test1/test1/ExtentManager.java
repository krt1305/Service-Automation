package test1.test1;

import java.util.Date;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import java.io.*;


public class ExtentManager {
	
	public static ExtentReports extent;

	public static ExtentReports getInstance() 
	{
		if (extent == null) 
		{
			Date d=new Date();
			String fileName=d.toString().replace(":", "_").replace(" ", "_")+".html";
		//	extent=new ExtentReports("/Users/rabia/Desktop/reports/"+fileName, true, DisplayOrder.NEWEST_FIRST);
			System.out.println("File name is "+fileName);
			extent = new ExtentReports(System.getProperty("user.dir")+"/REPORTS/"+fileName, true, DisplayOrder.NEWEST_FIRST);
			
		//	System.out.println("Config file is "+System.getProperty("user.dir")+);			
		//	extent.loadConfig(new File("C:/Users/rabia.tabassum/eclipse-workspace/test1/ReportsConfig.xml")));			
		//	extent.addSystemInfo("Selenium Version", "2.53.0").addSystemInfo(
		//			"Environment", "QA");
		}
		return extent;
		
	
	}

}
