package com.flamingo.jruser.service;

import com.baomidou.mybatisplus.service.IService;
import com.flamingo.jruser.model.entity.CompanyInfo;

/**
 * 企业service
 */
public interface CompanyService extends IService<CompanyInfo>{
    void saveCompany(CompanyInfo companyInfo);
}
