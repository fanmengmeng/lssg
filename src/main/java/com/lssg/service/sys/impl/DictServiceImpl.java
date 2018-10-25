package com.lssg.service.sys.impl;


import com.lssg.model.sys.Dict;
import com.lssg.pojo.QueryRequest;
import com.lssg.service.iservice.impl.BaseService;
import com.lssg.service.sys.DictService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("dictService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DictServiceImpl extends BaseService<Dict> implements DictService {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<Dict> findAllDicts(Dict dict, QueryRequest request) {
		try {
			Example example = new Example(Dict.class);
			Criteria criteria = example.createCriteria();
			if (StringUtils.isNotBlank(dict.getKey())) {
				criteria.andCondition("keyy=", Long.valueOf(dict.getKey()));
			}
			if (StringUtils.isNotBlank(dict.getValue())) {
				criteria.andCondition("valuee=", dict.getValue());
			}
			if (StringUtils.isNotBlank(dict.getTablename())) {
				criteria.andCondition("table_name=", dict.getTablename());
			}
			if (StringUtils.isNotBlank(dict.getFieledname())) {
				criteria.andCondition("field_name=", dict.getFieledname());
			}
			example.setOrderByClause("dict_id");
			return this.selectByExample(example);
		} catch (Exception e) {
			log.error("获取字典信息失败", e);
			return new ArrayList<>();
		}
	}

	@Override
	@Transactional
	public void addDict(Dict dict) {
		this.save(dict);
	}

	@Override
	@Transactional
	public void updateDict(Dict dict) {
		this.updateNotNull(dict);
	}

	@Override
	public Dict findById(Long dictId) {
		return this.selectByKey(dictId);
	}

}
