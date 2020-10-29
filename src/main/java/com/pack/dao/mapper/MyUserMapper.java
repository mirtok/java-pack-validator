package com.pack.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pack.entity.MyUser;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MyUserMapper extends BaseMapper<MyUser> {
    int insertMultipleData(List list);
}
