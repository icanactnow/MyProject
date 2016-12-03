package com.eric.action;

import java.sql.SQLException;
import java.util.List;

import com.eric.dao.studentDao;
import com.eric.model.StudentModel;

public class studentAction {
	private static studentDao dao = new studentDao();

	// ����ѧ������
	public void add(StudentModel s) throws SQLException {
		dao.addStudent(s);
	}

	// ɾ��ͨ��id
	public void del(int id) throws SQLException {
		dao.delStudent(id);
	}

	// ����ѧ������
	public void update(StudentModel s) throws SQLException {
		dao.updateStudent(s);
	}

	// ��װͨ��id��ȡ��Ϣ����
	public String get(Integer id) throws SQLException {
		return dao.get(id);
	}

	// ģ������
	public List<StudentModel> query(String name, String age) throws SQLException {

		return dao.query(name, age);
	}
}
