package com.base.wang.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_token")
public class SysToken {
    /**
     * uuid值
     */
    private String id;

    /**
     * 有效时间
     */
    @Column(name = "expire_time")
    private Date expireTime;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "change_time")
    private Date changeTime;

    /**
     * 值
     */
    private String value;

    /**
     * 获取uuid值
     *
     * @return id - uuid值
     */
    public String getId() {
        return id;
    }

    /**
     * 设置uuid值
     *
     * @param id uuid值
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取有效时间
     *
     * @return expire_time - 有效时间
     */
    public Date getExpireTime() {
        return expireTime;
    }

    /**
     * 设置有效时间
     *
     * @param expireTime 有效时间
     */
    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取值
     *
     * @return value - 值
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置值
     *
     * @param value 值
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }
}