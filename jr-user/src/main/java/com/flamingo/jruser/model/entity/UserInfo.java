package com.flamingo.jruser.model.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 用户表
 */
@Data
@TableName("user_info")
public class UserInfo {

    /** 用户ID. */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /** 企业ID. */
    @TableField("company_id")
    private Integer companyId;

    /** 用户类型. */
    @TableField("user_type")
    private Integer userType;

    /** 用户状态. */
    @TableField("status")
    private Integer status;

    /** 用户真实姓名. */
    @TableField("exact_name")
    private String exactName;

    /** 密码. */
    @TableField("password")
    private String password;

    /** 用户性别. */
    @TableField("sex")
    private Integer sex;

    /** 用户手机. */
    @TableField("phone")
    private String phone;

    /** 用户邮箱. */
    @TableField("email")
    private String email;

    /** 用户身份证号. */
    @TableField("id_card")
    private String idCard;

    /** 身份证正面. */
    @TableField("license_url_f")
    private String licenseUrlF;

    /** 身份证反面. */
    @TableField("license_url_b")
    private String licenseUrlB;

    /** 用户昵称. */
    @TableField("nick_name")
    private String nickName;

    /** 用户生日. */
    @JsonFormat(pattern="yyyy-MM-dd")
    @TableField("birthday")
    private Date birthday;

    /** 创建时间. */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("create_time")
    private Date createTime;

    /** 更新时间. */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField("update_time")
    private Date updateTime;

}
