package collection.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student extends People{
	private String gradeNo;
	private String classNo;
	private String no;
	
	public Student() {
		
	}
	
	public Student (String name, int age, String sex, String gradeNo, String classNo)
	{
		this.setName(name);
		this.setSex(sex);
		this.setAge(age);
		this.gradeNo = gradeNo;
		this.classNo = classNo;		
	}

	@Override
	public String toString() {
		return super.toString() + "Student [gradeNo=" + gradeNo + ", classNo=" + classNo + "]";
	}
}
