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
 * 测试类, 动态sql
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
		
		//1. 获取数据库会话
		SqlSession session = MyBatisUtil.createSqlSession();
		
		//2. 通过会话, 获取指定的数据接口, 再通过接口调用对应的方法
		List<User> list = session.getMapper(UserMapper.class)
				.select(new User());
		
		//3. 操作查询结果
		System.out.println("共有" + list.size() + "条数据:");
		for (User u : list) {
			System.out.println(u);
			System.out.println("共有发言" + u.getMessages().size() + "条");
			for (Message m : u.getMessages()) {
				System.out.println(m);
			}
			System.out.println("---------------------------");
		}
		
		//4. 关闭会话
		session.close();
	}
	
	private static void select() {
		
		//1. 获取数据库会话
		SqlSession session = MyBatisUtil.createSqlSession();
		
		//2. 通过会话, 获取指定的数据接口, 再通过接口调用对应的方法
		List<Message> list = session.getMapper(MessageMapper.class)
				.select(new Message());
		
		//3. 操作查询结果
		System.out.println("共有" + list.size() + "条数据:");
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
		
		//4. 关闭会话
		session.close();
	}
	
	/**
	 * 添加
	 */
	private static void insert() {
		
		//1. 获取数据库会话
		SqlSession session = MyBatisUtil.createSqlSession();
		
		//2. 循环, 添加测试数据
		for (int i = 1; i <= 50; i++) {
			
			/* 构建属性数据 */
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
			
			//添加
			session.getMapper(UserMapper.class).insert
				(new User(userName, password, gender, birthday, registeTime));
			
			//添加随机条数的发言
			int count = (int) (Math.random()*10 + 1); //发言数量
			//循环, 为当前用户添加发言
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
		
		//3. 提交事务
		session.commit();
		
		//4. 关闭会话
		session.close();
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
