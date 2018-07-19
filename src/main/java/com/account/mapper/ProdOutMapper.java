package com.account.mapper;


import com.account.domain.ProdOut;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdOutMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProdOut record);

    int insertSelective(ProdOut record);

    ProdOut selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProdOut record);

    int updateByPrimaryKey(ProdOut record);

//    List findListByProdOut(ProdOutDTO record);
}