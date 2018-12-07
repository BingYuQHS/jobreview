package com.flamingo.jruser.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.flamingo.jruser.dao.CompanyMapper;
import com.flamingo.jruser.enums.ResultEnum;
import com.flamingo.jruser.exception.UserException;
import com.flamingo.jruser.model.entity.CompanyInfo;
import com.flamingo.jruser.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper,CompanyInfo> implements CompanyService{
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    @Transactional
    public void saveCompany(CompanyInfo companyInfo) {
        int result = companyMapper.insertCompany(companyInfo);
        if(result != 1){
            log.error("【save company error】");
            throw new UserException(ResultEnum.SAVE_COMPANY_FAILD);
        }
    }
}
