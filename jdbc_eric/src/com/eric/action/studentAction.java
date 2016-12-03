package com.eric.action;

import java.sql.SQLException;
import java.util.List;

import com.eric.dao.studentDao;
import com.eric.model.StudentModel;

public class studentAction {
	private static studentDao dao = new studentDao();

	// 增加学生方法
	public void add(StudentModel s) throws SQLException {
		dao.addStudent(s);
	}

	// 删除通过id
	public void del(int id) throws SQLException {
		dao.delStudent(id);
	}

	// 更改学生属性
	public void update(StudentModel s) throws SQLException {
		dao.updateStudent(s);
	}

	// 包装通过id获取信息方法
	public String get(Integer id) throws SQLException {
		return dao.get(id);
	}

	// 模糊搜索
	public List<StudentModel> query(String name, String age) throws SQLException {

		return dao.query(name, age);
	}
}
