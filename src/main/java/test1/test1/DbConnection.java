package test1.test1;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


//import com.mysql.jdbc.Connection;

import com.mysql.jdbc.ResultSetImpl;


public class DbConnection {
	public Connection conn;
	public  Properties properties;
	public String DATABASE_URL="jdbc:jtds:sqlserver://192.168.17.10:1433;DatabaseName=TRAVELGURU_QA";
	public String dbUserName="desiya";
	public String dbPassword="@desiya123";
	public String DATABASE_DRIVER ="net.sourceforge.jtds.jdbc.Driver";
	//private String DATABASE_DRIVER="com.mysql.jdbc.Connection";

	public Statement stmt;
	public ResultSet rs;
	
	
	public Connection setConn() {
		
		 
		
		if( conn==null)
		{
			try {
                Class.forName("net.sourceforge.jtds.jdbc.Driver");
                conn =   DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.17.10:1433;DatabaseName=TRAVELGURU_QA", "desiya","@desiya123");
                
                System.out.println("database connection established successfully");
              //  System.out.println("Network timeout is "+ conn.getNetworkTimeout());
                System.out.println("Is read only "+ conn.isReadOnly());
                System.out.println("Auto commit "+ conn.getAutoCommit());
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
			
		}
		
		return conn;
	}

	

	public Properties getProperties() {
		
		if(properties==null)
		{
			properties=new Properties();
			properties.setProperty("username",dbUserName );
			properties.setProperty("password",dbPassword );
			
		}
		
		return properties;
	}

	
	public void closeConnection()
	{
		if(conn!=null)
		{
			try {
				System.out.println("Closing db connection");
				conn.close();
				conn=null;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public void dbInit()
	{
		System.out.println("In db init");
		try {
			stmt=conn.createStatement();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ResultSet getDBResultSet(String sqlQuery)
	{
		
		try {
			
			System.out.println("In get DB resultset");
			System.out.println("SQL query is "+sqlQuery);
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sqlQuery);
			int count=1;
			System.out.println("Before while");
			if(rs!=null)
			{
				/*while(rs.next())
				{
					count++;
					System.out.println(rs.getString(1));
				}
				System.out.println("Total results in resultset "+count);*/
				return rs;
			}
			else
			{
				System.out.println("No resultset found ");
				return null;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

}
