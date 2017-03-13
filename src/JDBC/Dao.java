package JDBC;

import java.util.ArrayList;

public interface Dao {

	public ArrayList query(String UserName)throws Exception;
	public boolean chechEmail(String Email) throws Exception;
	public void addUser(User user) throws Exception;
}
