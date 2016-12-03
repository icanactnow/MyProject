package com.eric.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBbulider {
	/**
	 * 建立与数据库的链接
	 */
	// 定义几个链接加载要用到的常量。
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/eric?useUnicode=true&amp;characterEncoding=utf-8";// 数据库地址
	private static final String USER = "root";// 数据库用户名
	private static final String PASSWORD = "admin";//用户密码
	private static Connection conn = null;// 数据库链接

	// 通过静态快执行加载数据库驱动以及建立链接
	static{
		//通过反射机制加载数据库驱动，前提是将驱动添加到文件并添加到环境变量值中http://pan.baidu.com/s/1kUENkCv
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//获得数据库链接
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
  public static Connection getConnectuon(){
	  return conn;//通过方法返回建立的数据库链接
  }
}
