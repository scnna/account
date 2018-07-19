package com.account.mapper;

import com.account.domain.Prod;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Prod record);

    int insertSelective(Prod record);

    Prod selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Prod record);

    int updateByPrimaryKey(Prod record);

    List<Prod> findListByProd(Prod prod);

}