package com.app.threetier.mapper;

import com.app.threetier.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    public void insert(MemberVO memberVO);
}
