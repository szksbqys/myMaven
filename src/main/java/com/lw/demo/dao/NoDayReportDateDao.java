package com.lw.demo.dao;

import com.lw.demo.entity.NoDayReportDateEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoDayReportDateDao {

    List<NoDayReportDateEntity> queryAllEntity();
}
