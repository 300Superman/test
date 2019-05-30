package com.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bean.Message;
import com.bean.User;
import com.util.HibernateUtil;

public class Test2 {

	public static void main(String[] args) {
		
//		manyToOne();
		oneToMany();
//		data();
	}
	
	private static void oneToMany() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = "from User";
		
		Query query = session.createQuery(hql);
		
		List<User> list = query.list();
		
		for (User u : list) {
			System.out.println(u);
			for (Message m : u.getMessages()) {
				System.out.println(m);
			}
			System.out.println("*************************");
		}
		
		session.close();
	}
	
	private static void manyToOne() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = "from Message";
		
		Query query = session.createQuery(hql);
		
		List<Message> list = query.list();
		
		for (Message m : list) {
			System.out.println(m);
			System.out.println(m.getUser());
			System.out.println("--------------------------");
		}
		
		session.close();
	}
	
	private static void data() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		for(int i = 1; i <= 10; i++) {
			
			//�û���
			String userName = randomString((int) (Math.random()*5) + 4);
			//����
			String password = randomString((int) (Math.random()*7) + 6);
			//�Ա�
			int gender = (int) (Math.random()*3);
			//����
			String birthday = 
					1970 + (int) (Math.random()*21) + "-" +
						(int) (Math.random()*12 + 1) + "-" +
						(int) (Math.random()*30 + 1);
			//ע������
			String registeTime = 
					1990 + (int) (Math.random()*21) + "-" +
					(int) (Math.random()*12 + 1) + "-" +
					(int) (Math.random()*30 + 1) + " " +
					(int) (Math.random()*24) + ":" +
					(int) (Math.random()*60) + ":" +
					(int) (Math.random()*60);
			
			Transaction tx = session.beginTransaction();
			
			session.save(new User(userName, password, gender, birthday, registeTime));
			
			tx.commit();
			
			tx = session.beginTransaction();
			
			//�û����
			Integer userId = 1001+i;
			
			//����û���Ӧ��Ϣ
			for (int j = 0; j < i*2; j++) {
				
				//����
				String title = "�û�"+userId+":"+
						randomString((int) (Math.random()*5) + 2);
				//����
				String content = randomString((int) (Math.random()*20) + 31);
				
				//���
				session.save(new Message(title, content, userId));
			}
			
			tx.commit();
		}
		
		
		
	}
	
	/**
	 * ����ָ�����ȵ�����ַ���
	 * @param amount
	 * @return
	 */
	private static String randomString(int amount) {
		
		//���������ַ���
		StringBuffer sb = new StringBuffer();
		
		//ѭ��, �����ַ���
		for (int i = 0; i < amount; i++) {
			
			//�����Ҫ���ַ��±�
			int index = (int) (Math.random()*characters.size());
			
			//����±��Ӧ���ַ����ַ���
			sb.append(characters.get(index));
		}
		
		return sb.toString();
	}
	
	/** ����ʹ�õ��ַ����� */
	private static List<String> characters = new ArrayList<>();
	//Ϊ�����������
	static {
		//ѭ���������
		for (int i = 0; i < 10; i++) {
			characters.add(i+"");
		}
		//ѭ�����Сд��ĸ
		for (int i = 97; i < 123; i++) {
			characters.add((char)i+"");
		}
		//ѭ����Ӵ�д��ĸ
		for (int i = 65; i < 91; i++) {
			characters.add((char)i+"");
		}
	}
}

