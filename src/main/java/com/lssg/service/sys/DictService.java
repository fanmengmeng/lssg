package com.lssg.service.sys;

import com.lssg.model.sys.Dict;
import com.lssg.pojo.QueryRequest;
import com.lssg.service.iservice.IService;

import java.util.List;

public interface DictService extends IService<Dict> {

    List<Dict> findAllDicts(Dict dict, QueryRequest request);


    Dict findById(Long dictId);

    void addDict(Dict dict);

    void updateDict(Dict dicdt);
}
