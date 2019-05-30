package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bean.Message;
import com.bean.User;
import com.dao.MessageMapper;
import com.dao.UserMapper;
import com.util.MyBatisUtil;

/**
 * ������, ��̬sql
 * @author Administrator
 *
 */
public class Test {

	public static void main(String[] args) {
		
//		insert();
		select();
//		select2();
	}
	
	private static void select2() {
		
		//1. ��ȡ���ݿ�Ự
		SqlSession session = MyBatisUtil.createSqlSession();
		
		//2. ͨ���Ự, ��ȡָ�������ݽӿ�, ��ͨ���ӿڵ��ö�Ӧ�ķ���
		List<User> list = session.getMapper(UserMapper.class)
				.select(new User());
		
		//3. ������ѯ���
		System.out.println("����" + list.size() + "������:");
		for (User u : list) {
			System.out.println(u);
			System.out.println("���з���" + u.getMessages().size() + "��");
			for (Message m : u.getMessages()) {
				System.out.println(m);
			}
			System.out.println("---------------------------");
		}
		
		//4. �رջỰ
		session.close();
	}
	
	private static void select() {
		
		//1. ��ȡ���ݿ�Ự
		SqlSession session = MyBatisUtil.createSqlSession();
		
		//2. ͨ���Ự, ��ȡָ�������ݽӿ�, ��ͨ���ӿڵ��ö�Ӧ�ķ���
		List<Message> list = session.getMapper(MessageMapper.class)
				.select(new Message());
		
		//3. ������ѯ���
		System.out.println("����" + list.size() + "������:");
		for (Message m : list) {
			System.out.println(m.getUser());
			System.out.println(m);
			System.out.println("---------------------------");
		}
		
		
		/*for (Message m : list) {
			System.out.println(
				m.getUserName() + " : " + m
			);
		}*/
		
		//4. �رջỰ
		session.close();
	}
	
	/**
	 * ���
	 */
	private static void insert() {
		
		//1. ��ȡ���ݿ�Ự
		SqlSession session = MyBatisUtil.createSqlSession();
		
		//2. ѭ��, ��Ӳ�������
		for (int i = 1; i <= 50; i++) {
			
			/* ������������ */
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
			
			//���
			session.getMapper(UserMapper.class).insert
				(new User(userName, password, gender, birthday, registeTime));
			
			//�����������ķ���
			int count = (int) (Math.random()*10 + 1); //��������
			//ѭ��, Ϊ��ǰ�û���ӷ���
			for (int j = 0; j < count; j++) {
				
				String content = randomString((int) (Math.random()*50) + 10);
				int userId = 1000 + i;
				String time = 
						2000 + (int) (Math.random()*21) + "-" +
						(int) (Math.random()*12 + 1) + "-" +
						(int) (Math.random()*30 + 1) + " " +
						(int) (Math.random()*24) + ":" +
						(int) (Math.random()*60) + ":" +
						(int) (Math.random()*60);
				
				session.getMapper(MessageMapper.class).insert
					(new Message(content, userId, time));
			}
		}
		
		//3. �ύ����
		session.commit();
		
		//4. �رջỰ
		session.close();
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
