package com.eric.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eric.db.DBbulider;
import com.eric.model.StudentModel;
import com.mysql.jdbc.PreparedStatement;

/**
 * 创建数据最基本的怎删改查
 * 
 * @author Eric
 *
 */
public class studentDao {
	private static Connection conn = null;
	static {
		conn = DBbulider.getConnectuon();// Java.sql中的Connection连接。
	}

	// 向数据库增加人员函数
	public void addStudent(StudentModel student) throws SQLException {
		// 创建要执行的sql语句
		String sql = "insert into students (name,sex,age) values(?,?,?)";// 放在一起不行吗？答案是可以的。
		// 通过连接创建缓冲准备对象
		// PreparedStatement ptmt = (PreparedStatement)
		// conn.prepareStatement(sql);
		PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
		// 通过缓冲对参数进行修改
		ptmt.setString(1, student.getName());
		ptmt.setInt(2, student.getSex());
		ptmt.setInt(3, student.getAge());
		// 执行sql语句
		ptmt.execute();// 一般用于不需用返回值的语句执行
	}

	// 通过传入新的学生对象对旧的进行更新
	public void updateStudent(StudentModel student) throws SQLException {
		String str = "update students set name =?,sex =?,age =? where id =?";// 不是到where id
																	// = ?有什么用。
		PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(str);
		ptmt.setString(1, student.getName());
		ptmt.setInt(2, student.getSex());
		ptmt.setInt(3, student.getAge());
		ptmt.setInt(4, student.getId());
		ptmt.execute();
	}

	// 删除学生方法,通过id号
	public void delStudent(Integer id) throws SQLException {
		String sql = "delete from students where id = ?";
		PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
		ptmt.setInt(1, id);
		ptmt.execute();
	}

	// 查找，返回对象列表
	public List<StudentModel> query() throws SQLException {
		// 创建用于返回的列表
		List<StudentModel> result = new ArrayList<>();
		String sql = "select id , name ,sex ,age from students";
		PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();// 执行并返回结果
		// 通过循环遍历将结果存到列表中作为返回值
		while (rs.next()) {
			// 创建一个用于存数据的对象
			StudentModel st = new StudentModel();
			st.setAge(rs.getInt("age")); // 通过result对象的get方法返回相应的值，进行设置
			st.setSex(rs.getInt("sex"));
			st.setId(rs.getInt("id"));
			st.setName(rs.getString("name"));
			result.add(st);
		}
		return result;
	}

	// 模糊查找,不搜则用""替代。
	public List<StudentModel> query(String name, String age) throws SQLException {
		List<StudentModel> result = new ArrayList<>();
		String sql = "select * from students where name like ? and age like ?";
		PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
		ptmt.setString(1, "%" + name + "%"); // %号起到模糊的作用
		ptmt.setString(2, "%" + age + "%");
		ResultSet rs = ptmt.executeQuery();// 执行并返回结果
		// 通过循环遍历将结果存到列表中作为返回值
		while (rs.next()) {
			// 创建一个用于存数据的对象
			StudentModel st = new StudentModel();
			st.setAge(rs.getInt("age")); // 通过result对象的get方法返回相应的值，进行设置
			st.setSex(rs.getInt("sex"));
			st.setId(rs.getInt("id"));
			st.setName(rs.getString("name"));
			result.add(st);
		}
		return result;
	}

	// 通过id 查询学生对象,类似可以通过各个参数进行专项查找
	public String get(int id) throws SQLException {
		String sql = "select * from students where id = ?";
		PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
		ptmt.setInt(1, id);
		ResultSet rs = ptmt.executeQuery();
		StudentModel st =null;
		if(!rs.next()){//判断id是否存在
			return "不存在这个id成员";
		}
		while (rs.next()) {
			// 创建一个用于存数据的对象
			 st = new StudentModel();
			st.setAge(rs.getInt("age")); // 通过result对象的get方法返回相应的值，进行设置
			st.setSex(rs.getInt("sex"));
			st.setId(rs.getInt("id"));
			st.setName(rs.getString("name"));
		}
  return st.getName()+st.getSex()+st.getAge();
	}
	//继续完善studentAction类以及view
}
