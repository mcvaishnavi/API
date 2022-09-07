package com.quinnox.ShoppingService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class fashionMockup {
	
	List<fashion> fash = new ArrayList<fashion>();
	
	// fetching from database
	public List<fashion> getfashion() throws SQLException{
		List<fashion> fash = new ArrayList<fashion>();
		ResultSet result = getConnection().createStatement().executeQuery("select * from fashion");
		while(result.next()) {
			fashion fa = new fashion(0, null, null, 0);
			fa.setId(result.getInt(1));
			fa.setType(result.getString(2));
			fa.setItem_name(result.getString(3));
			fa.setItem_price(result.getInt(4));
			fash.add(fa);
			
		}
		return fash;
	}
	
	//specific item
	public fashion getfashion(String item_name) {
		
		return fash.stream().filter( p -> p.getItem_name().equals(item_name)).findAny().orElse(null);
		 
	}
	
	//insert 
	public void createfashion(fashion fashion)throws Exception {
		PreparedStatement ps = getConnection().prepareStatement("insert into fashion(id,type,item_name,item_price)values(?,?,?,?)");
		ps.setInt(1, fashion.getId());
		ps.setString(2,fashion.getType());
		ps.setString(3,fashion.getItem_name());
		ps.setInt(4,fashion.getItem_price());
		ps.executeUpdate();
		
		
	}
	
	// update
	
	public void updatefashion(fashion fashion)throws Exception {
		PreparedStatement ps = getConnection().prepareStatement("update fashion set item_name = ? where type =? ");
		//ps.setInt(1, fashion.getId());
		ps.setString(1,fashion.getItem_name());
		ps.setString(2,fashion.getType());
		//ps.setInt(4,fashion.getItem_price());
		int count = ps.executeUpdate();
		System.out.println("updated count :"+count);
	}
	
	
	// delete from API
	
	public void dropFashion (String item_name)throws Exception {
		PreparedStatement ps = getConnection().prepareStatement("delete from fashion where item_name = ? ");
		//ps.setInt(1, id);
		ps.setString(1,item_name);
		//ps.setString(3,fashion.getType());
		//ps.setInt(4,fashion.getItem_price());
		int count = ps.executeUpdate();
		System.out.println("updated count :"+count);
	}
	
	
	//database connection
	
	public Connection getConnection() throws SQLException {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/items","root","Password@1");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return con;
	}
	
	
	
	
	

	
	


}
