package com.base.wang.common;

import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright 2015-2019 Yunfucloud technology co., Ltd.
 * Created by fuxx on 15/11/2.
 */
public class PageList implements Serializable {
    private Paginator paginator;
    private List list;

    public PageList() {
    }

    public PageList(List list) {
        if(list instanceof  Page){
            paginator=new Paginator((Page)list);
            this.list=list;
        }
    }

    public Paginator getPaginator() {
        return paginator;
    }

    public void setPaginator(Paginator paginator) {
        this.paginator = paginator;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
    /**
     * 用于对list数据进行分页
     */
    public static PageList list(Object obj){
        if(obj instanceof List){
            List list=(ArrayList)obj;
            return list(list);
        }else{
            return null;
        }
    }
    public static PageList list(List list){
        Paginator p=Paginator.generatePagination(list,10,1);
        return handle(p,list);
    }
    public static PageList list(Object obj, Integer pageSize , Integer pageNum){
        if(obj instanceof List){
            List list=(ArrayList)obj;
            return list(list,pageSize,pageNum);
        }else{
            return null;
        }
    }
    public static PageList list(List list, Integer pageSize , Integer pageNum){
        Paginator p=Paginator.generatePagination(list,pageSize,pageNum);
        return handle(p,list);
    }
    private static PageList handle(Paginator p, List list){
        if(list==null || list.isEmpty()){
            return null;
        }
        PageList info=new PageList();
        info.setPaginator(p);
        List returnList=list.subList(p.getStartRow()-1,p.getEndRow());
        info.setList(returnList);
        return info;
    }
}
