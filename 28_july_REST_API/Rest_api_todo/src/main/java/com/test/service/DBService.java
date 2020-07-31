package com.test.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jvnet.hk2.annotations.Service;


@Service
public class DBService {

	Connection con;
	public DBService()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");

			createDb();
			createtable();
			System.out.println("Database connected");
		} catch (ClassNotFoundException e) {
			System.out.println("class not found");
			e.printStackTrace();
		} catch (Exception e) {

			System.out.println("Exception");
			e.printStackTrace();
		}	
	}
	
	public JSONArray getList()
	{
		try {
			Statement cmd = con.createStatement();
			String sql = "Select * from todo";
			ResultSet table = cmd.executeQuery(sql);
			JSONArray data = new JSONArray();
			while (table.next()) {
				JSONObject row = new JSONObject();
				row.put(table.getInt(1), table.getString(2));
				data.add(row);
			}
			return data;
		}catch(Exception err)
		{
			return null;
		}
	}
	
	public boolean insert(String todoItem)
	{
		try {
			String sql = " insert into todo(name) values(?)";
			PreparedStatement cmd = con.prepareStatement(sql);
			cmd.setString(1, todoItem);
			if(cmd.executeUpdate()>0)
				return true;
			return false;
		}catch(Exception err)
		{
			System.out.println("DBService.insert()"+err.getMessage());
			return false;
		}
		
	}
	
	public boolean delete(int index)
	{
		try {
			String sql = " delete from todo where id = ?";
			PreparedStatement cmd = con.prepareStatement(sql);
			cmd.setInt(1, index);
			if(cmd.executeUpdate()>0)
				return true;
			return false;
		}catch(Exception err)
		{
			System.out.println(err.getMessage());
			return false;
		}
	}
	
	
	public void createDb() throws Exception
	{
		Statement cmd = con.createStatement();

		try {
			String sql = "create database mydb";
			cmd.execute(sql);
				
		}catch(Exception e)
		{
			System.out.println("database already present");
		}
		finally {
			String sql = "use mydb";
			cmd.execute(sql);
			cmd.close();
		}
	}
	
	public void createtable() 
	{
		Statement cmd;

		try {
			cmd = con.createStatement();
			String sql = "create table todo(id int AUTO_INCREMENT PRIMARY KEY,name varchar(50))";
			cmd.execute(sql);
				
		}catch(Exception e)
		{
			System.out.println("database already present");
		}
		finally {
		}
	}
}
