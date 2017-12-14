/* Copyright 2016 Yatra.com */
package test1.test1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;



public class ComLib {


  static ArrayList<Integer> countDetailsList = new ArrayList<>();

  public static String getDate(int noOfDays) {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Calendar cal = Calendar.getInstance();
    cal.setTime(new Date());
    cal.add(Calendar.DATE, noOfDays);
    String dateString = dateFormat.format(cal.getTime());
    return dateString;
  }

  public static void print(Object object) {

    try {

      StringWriter stringWriter = new StringWriter();
      JAXBContext contextObj = JAXBContext.newInstance(object.getClass());
      Marshaller marshallerObj = contextObj.createMarshaller();
      marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      marshallerObj.marshal(object, stringWriter);
      System.out.println(stringWriter.toString());

    } catch (Exception e) {
    
    }

  }

  public static String strTrim(String str) {
    String trimedStr = "";
    if (str != null) {
      trimedStr = str.trim();
    }
    return trimedStr;
  }

  public static String strTrim(boolean str) {
    String trimedStr = "true";
    if (str==false) {
      trimedStr = "false";
    }
    return trimedStr;
  }

  public static String booleanToYN(boolean str) {
    String trimedStr = "Y";
    if (str==false) {
      trimedStr = "N";
    }
    return trimedStr;
  }

  public static String strTrim(Integer intValue) {
    String trimedStr = "";
    if (intValue != null) {
      trimedStr = intValue.toString().trim();
    }
    return trimedStr;
  }

  public static String strTrim(Double aDouble) {
    String trimedStr = "";
    if (aDouble != null) {
      trimedStr = aDouble.toString().trim();
    }
    return trimedStr;
  }

  public static File downloadImageFile() {
    File file = new File("downloaded.jpg");
    if (!file.exists()) {
      try {
        URL url = new URL(
                "https://res.cloudinary.com/ytimages/image/upload/c_fill,w_930,h_550/v1489845566/Hotel/Bangalore/00082215/IMG_20170131_101708_w1137xh640-q90.jpg_lnWiMX.jpg");
        BufferedImage img = ImageIO.read(url);
        ImageIO.write(img, "jpg", file);
     
      } catch (IOException e) {
        
      }
    }
    
    return file;
  }

}
