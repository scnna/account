package com.account.mapper;

import com.account.domain.DTO.ProdComeDTO;
import com.account.domain.ProdCome;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdComeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProdCome record);

    int insertSelective(ProdCome record);

    ProdCome selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProdCome record);

    int updateByPrimaryKey(ProdCome record);

    List<ProdComeDTO> findListByProdCome(ProdComeDTO prodComeDTO);
}