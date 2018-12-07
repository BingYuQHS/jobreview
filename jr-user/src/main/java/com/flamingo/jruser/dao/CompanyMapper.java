package com.flamingo.jruser.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.flamingo.jruser.model.entity.CompanyInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * company mapper|dao
 */
@Component
public interface CompanyMapper extends BaseMapper<CompanyInfo>{

    int insertCompany(@Param("companyInfo") CompanyInfo companyInfo);
}
