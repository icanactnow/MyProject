package com.eric.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.eric.action.studentAction;
import com.eric.model.StudentModel;

public class view {
	public static final String MAINMENU = "欢迎登陆学生管路系统\n"
			+ "作者：eric\n[ADD/A]增加元素\n[DEL/D]删除元素\n[UPDATE/U]修改元素\n[GET/G]通过ID查询\n[QUERY/Q]姓名模糊搜索"
			+ "\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=";
	private static final String ADD = "ADD";
	private static final String DEL = "DEL";
	private static final String UPDATE = "UPDATE";
	private static final String GET = "GET";
	private static final String QUERY = "QUERY";
	static StudentModel st = new StudentModel();

	public static void main(String[] args) throws SQLException {
		String name = new String();
		String id = new String();
		System.out.println(MAINMENU);
		Scanner sc = new Scanner(System.in);
		studentAction sa = new studentAction();
		int value = 0;
		int step = 1;
		while (sc.hasNext()) {
			String key = sc.next().toString();
			// if/else规避命名是调到其他方法中。
			if (value != 0) {
				if (value == 2) {

					value = 2;
					if (step == 1) {
						System.out.println("请输入姓名(字符串)：");
					}
					if (step == 2) {
						st.setName(key);
						System.out.println("输入性别（0/1）");
					}
					if (step == 3) {
						// st.setSex(Integer.valueOf(sc.next().toString()));
						st.setSex(Integer.valueOf(key));
						System.out.println("输入年龄（数字）");
						// st.setId(1);
					}
					if (step == 4) {
						st.setAge(Integer.valueOf(key));
						System.out.println("录入完成");
						step = 0;
						value = 0;
						sa.add(st);
					}
					step++;
				}
				if (value == 3) {// 删除元素
					int iddel = Integer.valueOf(key);
					new studentAction().del(iddel);
					System.out.println("删除完毕");
					value = 0;
				}
				if (value == 4) {
					if (step == 1) {
						System.out.println("请输入姓名(字符串)：");
					}
					if (step == 2) {
						st.setName(key);
						System.out.println("输入性别（0/1）");
					}
					if (step == 3) {
						// st.setSex(Integer.valueOf(sc.next().toString()));
						st.setSex(Integer.valueOf(key));
						System.out.println("输入年龄（数字）");
						// st.setId(1);
					}
					if (step == 4) {
						st.setAge(Integer.valueOf(key));
						System.out.println("请输入要修改的id号码");
					}
					if (step == 5) {
						st.setId(Integer.valueOf(key));
						System.out.println("修改完成");
						step = 0;
						value = 0;
						sa.update(st);
					}
					step++;
				}
				if (value == 5) {
					System.out.println(sa.get(Integer.valueOf(key)));
					value = 0;
				}
				if (value == 6) {
					if (step == 1) {
						name = key;
						System.out.println("请输入年龄");
					}
					if (step == 2) {
						List<StudentModel> list = new ArrayList<>();
						if (key.equals("null")) {
							list = sa.query(name, "");
							System.out.println("sfsfads");
						}
						if (name.equals("null")) {
							list = sa.query("", id);
						}
						if (!(key.equals("null")) && !(name.equals("null"))) {
							list = sa.query(name, id);
						}

						if (list.isEmpty()) {
							System.out.println("空的啊");
						}
						System.out.println("查询结果");
						for (StudentModel s : list) {
							System.out.println(s.getId() + s.getName() + s.getSex() + s.getAge());
						}
						step = 0;
						value = 0;
					}
					step++;
				}
			} else {
				// 增加学生
				if (key.equals(ADD) || key.equals(ADD.toLowerCase()) || key.substring(0, 1).equals("A")
						|| key.substring(0, 1).equals("a")) {
					value = 2;
					if (step == 1) {
						System.out.println("请输入姓名(字符串)：");
						step++;
					}
				}
				if (key.equals(DEL) || key.equals(DEL.toLowerCase()) || key.substring(0, 1).equals("D")
						|| key.substring(0, 1).equals("d")) {
					value = 3;
					System.out.println("请输入要删除的id号码");
				}
				if (key.equals(UPDATE) || key.equals(UPDATE.toLowerCase()) || key.substring(0, 1).equals("U")
						|| key.substring(0, 1).equals("u")) {
					value = 4;
					System.out.println("请输入要修改的对象");
					if (step == 1) {
						System.out.println("请输入姓名(字符串)：");
						step++;
					}
				}
				if (key.equals(GET) || key.equals(GET.toLowerCase()) || key.substring(0, 1).equals("G")
						|| key.substring(0, 1).equals("g")) {
					value = 5;
					System.out.println("输入要查询的id号");

				}
				if (key.equals(QUERY) || key.equals(QUERY.toLowerCase()) || key.substring(0, 1).equals("Q")
						|| key.substring(0, 1).equals("q")) {
					value = 6;
					System.out.println("模糊搜索，名字和年龄，逗号隔开，不进行匹配则空着");
					System.out.println("请输入姓名");

				}

			}
			// 主菜单
			if (key.equals(MAINMENU) || key.equals(MAINMENU.toLowerCase()) || key.substring(0, 1).equals("M")
					|| key.substring(0, 1).equals("m") || value == 1) {

				System.out.println(MAINMENU);
			}
		}
	}

}
