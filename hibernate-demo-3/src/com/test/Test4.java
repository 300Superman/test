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
 * ������, ʹ��ԭ��SQL����hibernate
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
	 * ���ѯ/����
	 */
	private static void dirty() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
				
		User user = (User) session.get(User.class, 1001);
		System.out.println(user);
		
		user.setUserName("����");
		System.out.println(user);
		
		/*Transaction tx = session.beginTransaction();
		tx.commit();*/
		session.clear();
		
		user = (User) session.get(User.class, 1001);
		System.out.println(user);
		
		session.close();
	}
	
	/**
	 * ����
	 */
	private static void cache() {
		
		//1. ��ȡ�Ự
		Session session = HibernateUtil.getSessionFactory().openSession();
				
		User user = (User) session.get(User.class, 1001);
		System.out.println(user);
		
		//��������е�����
//		session.clear();
		
		user = (User) session.get(User.class, 1001);
		System.out.println(user);
		
		session.close();
	}
	
	private static void byCriteria() {
		
		//1. ��ȡ�Ự
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		//2. ��ȡCriteria����
		Criteria criteria = session.createCriteria(User.class);
		
		//3. ͨ������, ���ɸѡ��������������
		criteria.addOrder(Order.desc("id"));
		
		//4. ��ѯ
		List<User> list = criteria.list();
		
		for(User u : list) {
			System.out.println(u);
		}
		
		session.close();
	}
	
	/**
	 * ʹ��ԭ��SQL��ѯ
	 */
	private static void bySQL() {
		
		//1. ��ȡ�Ự
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		//2. sql�ַ���
		String sql = "select * from t_user";
		
		//3. ��������
		Object[] param = 
			{};
		
		//4. ������ѯ���� SQLQuery
		SQLQuery query = session.createSQLQuery(sql);
		
		//5. ���ռλ������
		for(int i = 0; i < param.length; i++) {
			query.setParameter(i, param[i]);
		}
		
		//6. �������ɸѡ����, �����ҳ��ѯ������
		
		//7. Ϊ��ѯ�����ʵ����
		query.addEntity(User.class);
		
		//8. ��ѯ. 3�ַ��� list(), iterate(), uniqueResult()
		List<User> list = query.list();
		
		//9. �������
		for(User u : list) {
			System.out.println(u);
		}
		
		//10. �ر���Դ
		session.close();
	}
	
}











