package com.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.bean.User;
import com.util.HibernateUtil;

import oracle.net.aso.q;

/**
 * 测试类, 使用原生SQL操作hibernate
 * @author Administrator
 *
 */
public class Test4 {

	public static void main(String[] args) {
		
		bySQL();
//		byCriteria();
//		cache();
//		dirty();
	}
	
	/**
	 * 脏查询/脏检查
	 */
	private static void dirty() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
				
		User user = (User) session.get(User.class, 1001);
		System.out.println(user);
		
		user.setUserName("张三");
		System.out.println(user);
		
		/*Transaction tx = session.beginTransaction();
		tx.commit();*/
		session.clear();
		
		user = (User) session.get(User.class, 1001);
		System.out.println(user);
		
		session.close();
	}
	
	/**
	 * 缓存
	 */
	private static void cache() {
		
		//1. 获取会话
		Session session = HibernateUtil.getSessionFactory().openSession();
				
		User user = (User) session.get(User.class, 1001);
		System.out.println(user);
		
		//清除缓存中的数据
//		session.clear();
		
		user = (User) session.get(User.class, 1001);
		System.out.println(user);
		
		session.close();
	}
	
	private static void byCriteria() {
		
		//1. 获取会话
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		//2. 获取Criteria对象
		Criteria criteria = session.createCriteria(User.class);
		
		//3. 通过方法, 添加筛选条件和排序条件
		criteria.addOrder(Order.desc("id"));
		
		//4. 查询
		List<User> list = criteria.list();
		
		for(User u : list) {
			System.out.println(u);
		}
		
		session.close();
	}
	
	/**
	 * 使用原生SQL查询
	 */
	private static void bySQL() {
		
		//1. 获取会话
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		//2. sql字符串
		String sql = "select * from t_user";
		
		//3. 参数数组
		Object[] param = 
			{};
		
		//4. 创建查询对象 SQLQuery
		SQLQuery query = session.createSQLQuery(sql);
		
		//5. 添加占位符数据
		for(int i = 0; i < param.length; i++) {
			query.setParameter(i, param[i]);
		}
		
		//6. 添加其他筛选条件, 例如分页查询的条件
		
		//7. 为查询对象绑定实体类
		query.addEntity(User.class);
		
		//8. 查询. 3种方法 list(), iterate(), uniqueResult()
		List<User> list = query.list();
		
		//9. 操作结果
		for(User u : list) {
			System.out.println(u);
		}
		
		//10. 关闭资源
		session.close();
	}
	
}











