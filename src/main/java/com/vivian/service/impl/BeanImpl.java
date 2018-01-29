package com.vivian.service.impl;

import com.vivian.dao.BeansDaoI;
import com.vivian.service.IBeanService;
import com.vivian.sql.model.TypeBeanModel;

import javax.annotation.Resource;

public class BeanImpl implements IBeanService {
    @Resource
    public BeansDaoI beansDaoI;


    @Override
    public TypeBeanModel selectBeanId(int id) {
        return beansDaoI.selectBeanId(id);
    }
}
