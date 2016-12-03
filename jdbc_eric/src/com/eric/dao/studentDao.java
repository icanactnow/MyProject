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
 * �����������������ɾ�Ĳ�
 * 
 * @author Eric
 *
 */
public class studentDao {
	private static Connection conn = null;
	static {
		conn = DBbulider.getConnectuon();// Java.sql�е�Connection���ӡ�
	}

	// �����ݿ�������Ա����
	public void addStudent(StudentModel student) throws SQLException {
		// ����Ҫִ�е�sql���
		String sql = "insert into students (name,sex,age) values(?,?,?)";// ����һ�����𣿴��ǿ��Եġ�
		// ͨ�����Ӵ�������׼������
		// PreparedStatement ptmt = (PreparedStatement)
		// conn.prepareStatement(sql);
		PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
		// ͨ������Բ��������޸�
		ptmt.setString(1, student.getName());
		ptmt.setInt(2, student.getSex());
		ptmt.setInt(3, student.getAge());
		// ִ��sql���
		ptmt.execute();// һ�����ڲ����÷���ֵ�����ִ��
	}

	// ͨ�������µ�ѧ������ԾɵĽ��и���
	public void updateStudent(StudentModel student) throws SQLException {
		String str = "update students set name =?,sex =?,age =? where id =?";// ���ǵ�where id
																	// = ?��ʲô�á�
		PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(str);
		ptmt.setString(1, student.getName());
		ptmt.setInt(2, student.getSex());
		ptmt.setInt(3, student.getAge());
		ptmt.setInt(4, student.getId());
		ptmt.execute();
	}

	// ɾ��ѧ������,ͨ��id��
	public void delStudent(Integer id) throws SQLException {
		String sql = "delete from students where id = ?";
		PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
		ptmt.setInt(1, id);
		ptmt.execute();
	}

	// ���ң����ض����б�
	public List<StudentModel> query() throws SQLException {
		// �������ڷ��ص��б�
		List<StudentModel> result = new ArrayList<>();
		String sql = "select id , name ,sex ,age from students";
		PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();// ִ�в����ؽ��
		// ͨ��ѭ������������浽�б�����Ϊ����ֵ
		while (rs.next()) {
			// ����һ�����ڴ����ݵĶ���
			StudentModel st = new StudentModel();
			st.setAge(rs.getInt("age")); // ͨ��result�����get����������Ӧ��ֵ����������
			st.setSex(rs.getInt("sex"));
			st.setId(rs.getInt("id"));
			st.setName(rs.getString("name"));
			result.add(st);
		}
		return result;
	}

	// ģ������,��������""�����
	public List<StudentModel> query(String name, String age) throws SQLException {
		List<StudentModel> result = new ArrayList<>();
		String sql = "select * from students where name like ? and age like ?";
		PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
		ptmt.setString(1, "%" + name + "%"); // %����ģ��������
		ptmt.setString(2, "%" + age + "%");
		ResultSet rs = ptmt.executeQuery();// ִ�в����ؽ��
		// ͨ��ѭ������������浽�б�����Ϊ����ֵ
		while (rs.next()) {
			// ����һ�����ڴ����ݵĶ���
			StudentModel st = new StudentModel();
			st.setAge(rs.getInt("age")); // ͨ��result�����get����������Ӧ��ֵ����������
			st.setSex(rs.getInt("sex"));
			st.setId(rs.getInt("id"));
			st.setName(rs.getString("name"));
			result.add(st);
		}
		return result;
	}

	// ͨ��id ��ѯѧ������,���ƿ���ͨ��������������ר�����
	public String get(int id) throws SQLException {
		String sql = "select * from students where id = ?";
		PreparedStatement ptmt = (PreparedStatement) conn.prepareStatement(sql);
		ptmt.setInt(1, id);
		ResultSet rs = ptmt.executeQuery();
		StudentModel st =null;
		if(!rs.next()){//�ж�id�Ƿ����
			return "���������id��Ա";
		}
		while (rs.next()) {
			// ����һ�����ڴ����ݵĶ���
			 st = new StudentModel();
			st.setAge(rs.getInt("age")); // ͨ��result�����get����������Ӧ��ֵ����������
			st.setSex(rs.getInt("sex"));
			st.setId(rs.getInt("id"));
			st.setName(rs.getString("name"));
		}
  return st.getName()+st.getSex()+st.getAge();
	}
	//��������studentAction���Լ�view
}
