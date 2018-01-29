package com.vivian.dao;

import com.vivian.sql.model.TypeBeanModel;
import org.springframework.stereotype.Repository;

@Repository
public interface BeansDaoI  {

    TypeBeanModel selectBeanId(int id);
}
