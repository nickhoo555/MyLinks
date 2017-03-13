package JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Servlet.Update;

public class DaoClass implements Dao 
{

	@Override
	//==查询测试===================================================
	public ArrayList query(String Age) throws Exception 
	{
		// TODO Auto-generated method stub

		Connection conn = new DB_Conn().getConn();
		String sql = "select * from users where age = ?";
		
		PreparedStatement ppst = conn.prepareStatement(sql);
		
		ppst.setString(1, Age);
		ResultSet rs = ppst.executeQuery();//执行查询Query，如有返回值，存入ResultSet
		
		//结果转存 到 ArrayList 容器
		/*
		 * 				          打包封装					 存入
		 * 查询结果（多组信息） =========> 不同的 user对象  ========>容器
		 * 
		 * 
		 */
	
		ArrayList aList = new ArrayList();
		
		while(rs.next())
		{
			//结果封装 到 user 对象
			User user = new User();
			user.setUserName(rs.getString(1));
			user.setPassWord(rs.getString(2));

			
			//将user存入容器
			aList.add(user);
			
			
		}
		
		//先开后关
		rs.close();
		ppst.close();
		conn.close();
		
		return aList;
	}

//==检查Email是否重复==================================================
	public boolean chechEmail(String Email) throws Exception 
	{
		boolean flag = true;
		Connection conn = new DB_Conn().getConn();
		String sql = "select email from users where email = ?";
		PreparedStatement ppst = conn.prepareStatement(sql);
		ppst.setString(1, Email);
		ResultSet rs = ppst.executeQuery();//执行查询Query，如有返回值，存入ResultSet
		
		if (rs.next()) {
			flag = false;
		}
		
		//先开后关
		rs.close();
		ppst.close();
		conn.close();
		
		return flag;
	}
//==添加新用户==========================================================
	public void addUser( User user) throws Exception
	{
		Connection conn = new DB_Conn().getConn();
		String sql = "insert into users(email,username,password) values(?,?,?)";
		PreparedStatement ppst = conn.prepareStatement(sql);
		ppst.setString(1, user.getEmail());
		ppst.setString(2, user.getUserName());
		ppst.setString(3, user.getPassWord());
		
		ppst.executeUpdate();
		
		ppst.close();
		conn.close();
	}
	
//==用户表查询===================================================
	public String queryUser(User user) throws Exception 
	{
		//拼接sql法
//		boolean flag = false;
//		Connection conn = new DB_Conn().getConn();
//		String sql = "select * from users where 1=1 ";
//	if (user.getEmail()!="") {
//		sql+="and email='"+user.getEmail()+"' ";
//	}
//	if (user.getPassWord()!="") {
//		sql+="and password='"+user.getPassWord()+"' ";
//	}
//		//PreparedStatement ppst = conn.prepareStatement(sql);
//		Statement st = conn.createStatement();
//		//ppst.setString(1, Age);
//		//ResultSet rs = ppst.executeQuery();//执行查询Query，如有返回值，存入ResultSet
//		ResultSet rs =st.executeQuery(sql);
//		System.out.println(rs);
//		
//		if(rs.next())
//		{
//
//			flag=true;
//		}
//		
//		//先开后关
//		rs.close();
//		//ppst.close();
//		st.close();
//		conn.close();
//		
//		return flag;
		
		
		// ？ 传参
		String flag = "";
		Connection conn = new DB_Conn().getConn();
		String sql = "select * from users where email=? and password=?";
		PreparedStatement ppst = conn.prepareStatement(sql);
		ppst.setString(1, user.getEmail());
		ppst.setString(2, user.getPassWord());
		ResultSet rs = ppst.executeQuery();//执行查询Query，如有返回值，存入ResultSet
		
		if(rs.next())
		{

			flag=rs.getString(2);
		}
		
		//先开后关
		rs.close();
		ppst.close();
		conn.close();
		
		return flag;
	}
	
	
	//查询links
	public ArrayList<Links> linksQuery(String email) throws Exception {
		
		Connection conn = new DB_Conn().getConn();
		String sql = "select linkname,linka,linkid from links where useremail =? order by linkid";
		
		PreparedStatement ppst = conn.prepareStatement(sql);
		
		ppst.setString(1, email);
		ResultSet rs = ppst.executeQuery();//执行查询Query，如有返回值，存入ResultSet
		
		//结果转存 到 ArrayList 容器
		/*
		 * 				          打包封装					 存入
		 * 查询结果（多组信息） =========> 不同的 user对象  ========>容器
		 * 
		 * 
		 */
	
		ArrayList<Links> aList = new ArrayList<Links>();
		
		while(rs.next())
		{
			//结果封装 到 user 对象
			Links links = new Links();
			links.setLinkname(rs.getString(1));
			links.setLinka(rs.getString(2));
			links.setLinkid(rs.getString(3));
			
			//将links存入容器
			aList.add(links);
			System.out.println("ookkk");
			
			
		}
		
		//先开后关
		rs.close();
		ppst.close();
		conn.close();
		
		return aList;
		
	}
	
//==添加links
	public void addLinks(String name ,String a ,String email) throws Exception {
		Connection conn = new DB_Conn().getConn();
		String sql = "insert into links(linkid,linkname,linka,useremail) values(seqlinkid.nextval,?,?,?)";
		
		PreparedStatement ppst = conn.prepareStatement(sql);
		
		ppst.setString(1, name);
		ppst.setString(2, a);
		ppst.setString(3, email);
		ppst.executeUpdate();//执行查询Query，如有返回值，存入ResultSet
		
		
		//先开后关
		
		ppst.close();
		conn.close();

	}
	//更新links
	public void updateLinks(String id ,String name ,String a) throws Exception {
		System.out.println("Update");
		Connection conn = new DB_Conn().getConn();
		String sql = "update links  set linkname=?,linka=? where linkid=?";
		
		PreparedStatement ppst = conn.prepareStatement(sql);
		
		ppst.setString(1, name);
		ppst.setString(2, a);
		ppst.setString(3, id);
		ppst.executeUpdate();//执行查询Query，如有返回值，存入ResultSet
		
		
		//先开后关
		
		ppst.close();
		conn.close();

	}
	//删除links
	//更新links
		public void deleteLinks(String id) throws Exception {
			System.out.println("delete");
			Connection conn = new DB_Conn().getConn();
			String sql = "delete from links  where linkid=?";
			
			PreparedStatement ppst = conn.prepareStatement(sql);
			ppst.setString(1, id);
			ppst.executeUpdate();//执行查询Query，如有返回值，存入ResultSet
			//先开后关
			
			ppst.close();
			conn.close();

		}
}
