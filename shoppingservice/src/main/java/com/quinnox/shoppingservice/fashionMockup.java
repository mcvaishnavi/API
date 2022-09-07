package com.quinnox.shoppingservice;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import com.mysql.jdbc.PreparedStatement;





public class fashionMockup {
ArrayList<fashion> fash = new ArrayList<fashion>();

	// fetching from database
	public List<fashion> getfashion() throws SQLException{
		List<fashion> fash = new ArrayList<fashion>();
		Connection conn = ConnectionFactory.getConnection();
		
       String selectQuery ="select * from fashion";
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(selectQuery);
		
		
		while(rs.next()) {
			fashion fa = new fashion();
			fa.setId(rs.getInt(1));
			fa.setType(rs.getString(2));
			fa.setItem_name(rs.getString(3));
			fa.setItem_price(rs.getInt(4));
			fash.add(fa);
			
		}
		return fash;
	}
	
	
	//specific item (GET)
		public fashion getfashion(String item_name) {
			
			return fash.stream().filter( p -> p.getItem_name().equals(item_name)).findAny().orElse(null);
			 
		}
		
		
		//insert 
		public void createfashion(fashion fashion)throws Exception {
			Connection conn = ConnectionFactory.getConnection();
			
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement("insert into fashion(id,type,item_name,item_price)values(?,?,?,?)");
			ps.setInt(1, fashion.getId());
			ps.setString(2,fashion.getType());
			ps.setString(3,fashion.getItem_name());
			ps.setInt(4,fashion.getItem_price());
			ps.executeUpdate();
		
		}
		
		// update
		
		public void updatefashion(fashion fashion)throws Exception {
			Connection conn = ConnectionFactory.getConnection();
			java.sql.PreparedStatement ps = conn.prepareStatement("update fashion set item_name = ? where type =? ");
			//ps.setInt(1, fashion.getId());
			ps.setString(1,fashion.getItem_name());
			ps.setString(2,fashion.getType());
			//ps.setInt(4,fashion.getItem_price());
			int count = ps.executeUpdate();
			System.out.println("updated count :"+count);
		}
		
		// delete from API
		
		public void dropFashion (String item_name)throws Exception {
			Connection conn = ConnectionFactory.getConnection();
			java.sql.PreparedStatement ps = conn.prepareStatement("delete from fashion where item_name = ? ");
			//ps.setInt(1, id);
			ps.setString(1,item_name);
			//ps.setString(3,fashion.getType());
			//ps.setInt(4,fashion.getItem_price());
			int count = ps.executeUpdate();
			System.out.println("updated count :"+count);
		}
	

	
	
	
		
		
		
}

