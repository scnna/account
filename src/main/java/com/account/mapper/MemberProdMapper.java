package com.account.mapper;

import com.account.domain.DTO.WorkRordDTO;
import com.account.domain.MemberProd;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberProdMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberProd record);

    int insertSelective(MemberProd record);

    MemberProd selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberProd record);

    int updateByPrimaryKey(MemberProd record);

    List findListByWorkRecord(WorkRordDTO record);

    List getList(WorkRordDTO record);
}