package test1.test1;

public class Config {
	
	String sqlURL="jdbc:jtds:sqlserver://192.168.17.10:1433;DatabaseName=TRAVELGURU_QA";
	String dbUserName="desiya";
	String dbPassword="@desiya123";

	
	
	public String getSqlURL() {
		return sqlURL;
	}
	public void setSqlURL(String sqlURL) {
		this.sqlURL = sqlURL;
	}
	public String getDbUserName() {
		return dbUserName;
	}
	public void setDbUserName(String dbUserName) {
		this.dbUserName = dbUserName;
	}
	public String getDbPassword() {
		return dbPassword;
	}
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}
	
	
	

}
