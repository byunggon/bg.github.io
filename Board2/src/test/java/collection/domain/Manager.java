package collection.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Manager {
	List<People> peopleList = new ArrayList<People>();

	public Manager() {
		init();
	}
	
	public void init() {
		People student1 = new Student("김장철", 15, "남자", "1학년", "1반");
		People student2 = new Student("강병곤", 35, "남자", "2학년", "2반");
		People student3 = new Student("박종혁", 35, "남자", "3학년", "3반");
		People student4 = new Student("최윤수", 25, "남자", "4학년", "4반");
		People student5 = new Student("임영수", 45, "남자", "5학년", "5반");
		
		People teacher1 = new Teacher("임영수", 45, "남자", "정교사", "담임교사");
		People teacher2 = new Teacher("이종석", 45, "남자", "정교사", "일반교사");
		People teacher3 = new Teacher("남준우", 45, "남자", "기간제교사", "담임교사");
		
		peopleList.add(student1);
		peopleList.add(student2);
		peopleList.add(student3);
		peopleList.add(student4);
		peopleList.add(student5);
		
		peopleList.add(teacher1);
		peopleList.add(teacher2);
		peopleList.add(teacher3);

	}
	// 모든 인원 출력
	public void printAllPeople() {
		for(People people:this.peopleList) {
			System.out.println(people);
			}		
	}
	// 학생만 출력
	public void printAllStudent() {
		System.out.println("## 학생 목록만 출력 시작 ##");

		for(People people:this.peopleList) {
			if(people instanceof Student) {
				System.out.println(people);
			}		
		}
		
		System.out.println("## 학생 목록만 출력 종료##");
	}
	// 선생님만 출력
	public void printAllTeacher() {
		System.out.println("## 교사 목록만 출력 시작 ##");

		for(People people:this.peopleList) {
			if(people instanceof Teacher) {
				System.out.println(people);
			}
		}		
		System.out.println("## 교사 목록만 출력 종료 ##");	
	}	
	
	// 람다와 스트림을 활용하여 구현
	public List<People> getStudentList() {
		List<People> resultList = new ArrayList<People>();
		for(People people:this.peopleList) {
			if(people instanceof Student) {
				resultList.add(people);
			}
		}	
		return resultList;
	}
	
	// 등록 기능을 만들어 테스트
	public void create(People people) {
		this.peopleList.add(people);
	}
	
	
	//이름을 pk로 가정, 해당 이름으로 검색 기능 구현
	public People retrieve(People people) {
		People result = null;
		for(People listPeople:this.peopleList) {
			if(listPeople.getName().equals(people.getName())) {
				result = listPeople;
		}			
	}		
		return result;
	}
	
	//1건 업데이트 (조건 이름이 pk)
	public int update(People people) {
		int cnt = 0;
		
		for(People listPeople:this.peopleList) {			
	
		if(listPeople.getName().equals(people.getName())) {
			cnt++;
		
			listPeople.setAge(people.getAge());
			listPeople.setSex(people.getSex());
			//선생님인지 학생인지 어떻게 알까?
			if(listPeople instanceof Student) {
				((Student)listPeople).setGradeNo(((Student)people).getGradeNo());
				((Student)listPeople).setClassNo(((Student)people).getClassNo());
			}
			else {	
				((Teacher)listPeople).setManagerType(((Teacher)people).getManagerType());
				((Teacher)listPeople).setOperateType(((Teacher)people).getOperateType());
			}
		}
	}
			return cnt;			
	}
	//1건 삭제 기능	
	public int delete(People people) {
		int cnt = 0;
		People findPeople = null;
		
		for(People listPeople:this.peopleList) {					
			if(listPeople.getName().equals(people.getName())) {
				findPeople = listPeople;
				cnt++;
			}
		}
		
		if(findPeople!=null) {
			this.peopleList.remove(findPeople);
		}			
		return cnt;				
	}		
	
	public static void main(String[] args) {
		
		//System.out.println("## 모든 인원 출력");
		Manager manager = new Manager();		
		//manager.printAllPeople();
		
		People student = new Student("최전학", 14, "2", "4", "10");
		People teacher = new Teacher("신역사", 30, "남자", "정교사", "담임교사");
		manager.create(student);
		manager.create(teacher);
		
		//manager.printAllPeople();
		
		student = new Student();
		student.setName("임영수");
		
		People retrivePeople = manager.retrieve(student);
		System.out.println("1건 조회 결과 " + retrivePeople);

		manager.printAllStudent();
//		List<People> studentList = manager.getStudentList();
		System.out.println();
		
		student = new Student("최전학", 18, "남자", "3", "14");	

		int updateCnt = manager.update(student);
		System.out.println("업데이트 결과 = " + updateCnt + "건, " + "변경 결과 = " + student);
		System.out.println("## 업데이트 후 학생목록만 출력");
		manager.printAllStudent();		
		
		student = new Student();
		student.setName("최전학");
		
		int deleteCnt = manager.delete(student);
		System.out.println("삭제 결과 = "+deleteCnt + "건, " + "삭제 학생 = " + student.getName());
		
		System.out.println("## 삭제 후 학생목록만 출력");
		manager.printAllStudent(); 
	
	}

		
		
		
		
		
		
		
		
		
		
		
		
		
		/*People student1 = new Student();
		student1.setName("김장철");
		student1.setSex("남자");
		student1.setAge(15);
		((Student)student1).setGradeNo("3학년");
		((Student)student1).setClassNo("4반");
		
		People teacher1 = new Teacher();
		teacher1.setName("이수학");
		teacher1.setSex("여자");
		teacher1.setAge(35);
		((Teacher)teacher1).setManagerType("정교사");
		((Teacher)teacher1).setOperateType("정교사");	
		*/

	@Override
	public String toString() {
		return super.toString()+ "Manager [PeopleList=" + peopleList + "]";
	}
}
