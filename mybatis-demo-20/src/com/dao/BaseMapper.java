package com.dao;

import java.util.List;
import java.util.Map;

/**
 * 基础数据接口
 * @author Administrator
 *
 */
public interface BaseMapper<T> {
	/** 添加 */
	void insert(T t);
	/** 删除 */
	void delete(T t);
	/** 修改 */
	void update(T t);
	/** 查询 */
	List<T> select(T t);
	/** 查询总记录数 */
	int count(Map<String, Object> map);
	/** 分页和组合条件查询 */
	List<T> selectByPage(Map<String, Object> map);
}










