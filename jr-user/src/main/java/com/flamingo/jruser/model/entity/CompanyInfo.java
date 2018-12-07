package com.flamingo.jruser.model.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

/**
 * 企业表
 */
@Data
@TableName("company_info")
public class CompanyInfo {

    /** 企业ID. */
    @TableId(value = "company_id", type = IdType.INPUT)
    private Integer companyId;

    /** 企业名称. */
    @TableField("company_name")
    private String companyName;

    /** 营业执照注册号. */
    @TableField("company_no")
    private String companyNo;

    /** 营业执照. */
    @TableField("license_path")
    private String licensePath;

    /** 审核状态. */
    @TableField("check_type")
    private Integer checkType;
}
