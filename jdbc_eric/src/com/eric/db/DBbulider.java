package com.eric.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBbulider {
	/**
	 * ���������ݿ������
	 */
	// ���弸�����Ӽ���Ҫ�õ��ĳ�����
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/eric?useUnicode=true&amp;characterEncoding=utf-8";// ���ݿ��ַ
	private static final String USER = "root";// ���ݿ��û���
	private static final String PASSWORD = "admin";//�û�����
	private static Connection conn = null;// ���ݿ�����

	// ͨ����̬��ִ�м������ݿ������Լ���������
	static{
		//ͨ��������Ƽ������ݿ�������ǰ���ǽ�������ӵ��ļ�����ӵ���������ֵ��http://pan.baidu.com/s/1kUENkCv
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//������ݿ�����
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
  public static Connection getConnectuon(){
	  return conn;//ͨ���������ؽ��������ݿ�����
  }
}
