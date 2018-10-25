package com.lssg.service.iservice;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IService<T> {

	List<T> selectAll();

	T selectByKey(Object key);

	int save(T entity);

	int delete(Object key);

	int batchDelete(List<Integer> list,Class<T> clazz);

	int updateAll(T entity);

	int updateNotNull(T entity);

	List<T> selectByExample(Object example);
}