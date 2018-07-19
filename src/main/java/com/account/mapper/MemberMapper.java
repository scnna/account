package com.account.mapper;

import com.account.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);

    List findListByMember(Member member);

}