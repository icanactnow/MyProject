package com.eric.model;

public class StudentModel {
	private Integer id;
	private String name;
	private Integer sex;
	private Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	public String toString(){
		String str = "[学生：id="+id+"	姓名：name"+name+"	性别：sex"+sex+"	年龄：age"+age+"]";
		return str;
	}
}
