package com.khunboo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 基础dao
 * @param <T>
 */
public interface BaseDao<T> extends BaseMapper<T> {
}
