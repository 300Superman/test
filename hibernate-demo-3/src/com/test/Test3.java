package com.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.Course;
import com.bean.Student;
import com.bean.StudentAndCourse;
import com.util.HibernateUtil;

public class Test3 {

	public static void main(String[] args) {
		
//		data();
		manyToMany();
	}
	
	private static void manyToMany() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		/*String hql = "from Student";
		
		Query query = session.createQuery(hql);
		
		List<Student> list = query.list();
		
		for (Student s : list) {
			System.out.println(s);
			for(Course c : s.getCourses()) {
				System.out.println(c);
			}
			System.out.println("---------------------------");
		}*/
		String hql = "from Course";
		
		Query query = session.createQuery(hql);
		
		List<Course> list = query.list();
		
		for (Course c : list) {
			System.out.println(c);
			for(Student s : c.getStudents()) {
				System.out.println(s);
			}
			System.out.println("---------------------------");
		}
		session.close();
	}
	
	private static void data() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		
		for (int i = 1; i < 6; i++) {
			session.save(new Student("学生"+i));
			session.save(new Course("课程"+i));
		}
		
		tx.commit();
		
		tx = session.beginTransaction();
		
		for (int i = 1; i < 6; i++) {
			
			//学生编号
			Integer studentId = 1000+i;
			
			for (int j = 1; j <= i ; j++) {
				
				//课程编号
				Integer courseId = 1000+j;
				
				//添加
				session.save(new StudentAndCourse(studentId, courseId));
			}
			
		}
		tx.commit();
		
		session.close();
	}
}










