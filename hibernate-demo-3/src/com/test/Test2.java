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
			
			//用户名
			String userName = randomString((int) (Math.random()*5) + 4);
			//密码
			String password = randomString((int) (Math.random()*7) + 6);
			//性别
			int gender = (int) (Math.random()*3);
			//生日
			String birthday = 
					1970 + (int) (Math.random()*21) + "-" +
						(int) (Math.random()*12 + 1) + "-" +
						(int) (Math.random()*30 + 1);
			//注册日期
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
			
			//用户编号
			Integer userId = 1001+i;
			
			//添加用户对应信息
			for (int j = 0; j < i*2; j++) {
				
				//标题
				String title = "用户"+userId+":"+
						randomString((int) (Math.random()*5) + 2);
				//内容
				String content = randomString((int) (Math.random()*20) + 31);
				
				//添加
				session.save(new Message(title, content, userId));
			}
			
			tx.commit();
		}
		
		
		
	}
	
	/**
	 * 构建指定长度的随机字符串
	 * @param amount
	 * @return
	 */
	private static String randomString(int amount) {
		
		//创建缓冲字符串
		StringBuffer sb = new StringBuffer();
		
		//循环, 构建字符串
		for (int i = 0; i < amount; i++) {
			
			//随机需要的字符下标
			int index = (int) (Math.random()*characters.size());
			
			//添加下标对应的字符到字符串
			sb.append(characters.get(index));
		}
		
		return sb.toString();
	}
	
	/** 可以使用的字符集合 */
	private static List<String> characters = new ArrayList<>();
	//为集合添加数据
	static {
		//循环添加数字
		for (int i = 0; i < 10; i++) {
			characters.add(i+"");
		}
		//循环添加小写字母
		for (int i = 97; i < 123; i++) {
			characters.add((char)i+"");
		}
		//循环添加大写字母
		for (int i = 65; i < 91; i++) {
			characters.add((char)i+"");
		}
	}
}

