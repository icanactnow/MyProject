package com.eric.test;

import java.sql.SQLException;
import java.util.List;

import com.eric.action.studentAction;
import com.eric.dao.studentDao;
import com.eric.db.DBbulider;
import com.eric.model.StudentModel;

public class jdbcTest {

	public static void main(String[] args) throws SQLException {
		StudentModel student = new StudentModel();
		student.setAge(12);
		student.setName("honghong");
		student.setSex(1);
        student.setId(3);
		// new studentDao().delStudent(5);//…æ≥˝Õ®π˝id
		// ≤‚ ‘≤È’“
		 List<StudentModel> ls = new studentDao().query("e","2");
		 for (StudentModel s : ls) {
		 System.out.println(s.getId()+s.getName()+s.getSex()+s.getAge());
		 }
		// System.out.println(new studentDao().get(2).getId()+new
		// studentDao().get(1).getName()+new studentDao().get(2).getSex()+new
		// studentDao().get(2).getAge());
		// System.out.println(new studentAction().get(1));
//        new studentAction().add(student);
	}

}
