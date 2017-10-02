package driver_software_eng.eng_assignment_driver;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import software_eng.assignment.Course;
import software_eng.assignment.Module;
import software_eng.assignment.Student;



public class Driver {
	private static List<Student> allStudents;
	private static List<Course> courseList;

	public static void main(String args[]) {

		Course course1 = new Course();
		Course course2 = new Course();
		courseList = new LinkedList<Course>();
		List<Module> moduleList1 = new LinkedList<Module>();
		List<Module> moduleList2 = new LinkedList<Module>();
		allStudents = new LinkedList<Student>();
		List<Student> studentList1 = new LinkedList<Student>();
		List<Student> studentList2 = new LinkedList<Student>();
		List<Student> studentList3 = new LinkedList<Student>();
		List<Student> studentList4 = new LinkedList<Student>();
		DateTimeFormatter dtf = DateTimeFormat.forPattern("MM/dd/yyyy");
		
		Student student1 = new Student("Bronagh Deane", "21", dtf.parseDateTime("05/26/1996"), "14407778");
		Student student2 = new Student("Niamh Fitzgerald", "22", dtf.parseDateTime("06/25/1995"), "14308016");
		Student student3 = new Student("Enda Barrett", "22", dtf.parseDateTime("08/23/1995"), "14400234");
		Student student4 = new Student("Olivia Flanagan", "22", dtf.parseDateTime("08/24/1995"), "14400019");
		Student student5 = new Student("Conor Healy", "22", dtf.parseDateTime("06/23/1995"), "12222222");
		Student student6 = new Student("Katie Kennedy", "21", dtf.parseDateTime("04/16/1996"), "14409999");

		allStudents.add(student1);
		allStudents.add(student2);
		allStudents.add(student3);
		allStudents.add(student4);
		allStudents.add(student5);
		allStudents.add(student6);

		studentList1.add(student1);
		studentList1.add(student2);
		studentList1.add(student3);

		studentList2.add(student1);
		studentList2.add(student2);
		studentList2.add(student3);
		studentList2.add(student4);

		studentList3.add(student3);
		studentList3.add(student4);

		studentList4.add(student5);
		studentList4.add(student6);

		Module module1 = new Module("Sotware Engineering III", "CT417", studentList1);
		Module module2 = new Module("System On Chip Design", "EE451", studentList3);
		Module module3 = new Module("Final Year Project", "EE343", studentList2);
		Module module4 = new Module("Final Year Project", "CT343", studentList4);
		Module module5 = new Module("Machine Learning", "CT333", studentList4);

		moduleList1.add(module1);
		moduleList1.add(module2);
		moduleList1.add(module3);

		moduleList2.add(module4);
		moduleList2.add(module5);

		
		String date = "09/01/2017";
		DateTime startdate = dtf.parseDateTime(date);
		date = "05/26/2018";
		DateTime enddate = dtf.parseDateTime(date);

		course1 = new Course("Electronic & Computer Engineering", moduleList1, startdate, enddate);
		course2 = new Course("CS&IT", moduleList2, startdate, enddate);
		courseList.add(course1);
		courseList.add(course2);

		list();
	}

	public static void list() {
		String studentInfo = "";
		for (Iterator<Student> studentIt = allStudents.iterator(); studentIt.hasNext();) {
			Student student = studentIt.next();
			studentInfo = "Student: " + student.getName() + " is registered for courses ";
			for (Iterator<Course> courseIt = courseList.iterator(); courseIt.hasNext();) {
				Course course = courseIt.next();
				List<Module> modules = course.getModules();
				String modulesInfo = "";
				for (Iterator<Module> modulesIt = modules.iterator(); modulesIt.hasNext();) {
					Module module = modulesIt.next();
					List<Student> students = module.getStudentList();
					for (Iterator<Student> studIt = students.iterator(); studIt.hasNext();) {
						Student stud = studIt.next();
						//usernames are 'unique'
						if (student.getUsername().equals(stud.getUsername())) {
							modulesInfo += module.getModuleName();
							if (modulesIt.hasNext()) {
								modulesInfo += ", ";
							}
						}
					}
				}
				if (!modulesInfo.isEmpty()) {
					studentInfo += modulesInfo + " for the course " + course.getCourseName();
					System.out.println(studentInfo);
				}
			}

		}
	}


}
