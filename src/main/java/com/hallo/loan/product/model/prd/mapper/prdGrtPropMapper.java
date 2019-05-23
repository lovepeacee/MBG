package com.hallo.loan.product.model.prd.mapper;


import com.hallo.loan.product.model.prd.prdGrtProp;

public interface prdGrtPropMapper {
    int deleteByPrimaryKey(String id);

    int insert(prdGrtProp record);

    int insertSelective(prdGrtProp record);

    prdGrtProp selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(prdGrtProp record);

    int updateByPrimaryKey(prdGrtProp record);
}