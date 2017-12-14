package test1.test1;

import java.sql.SQLException;

public class Test {
	
	public static void main(String args[])
	{
		DbConnection db=new DbConnection();
		ImportEndPoint imp=new ImportEndPoint();
		db.setConn();
		
	}

}
