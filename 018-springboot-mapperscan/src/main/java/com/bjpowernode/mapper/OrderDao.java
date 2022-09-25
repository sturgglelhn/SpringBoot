package com.bjpowernode.mapper;

import com.bjpowernode.model.Student;
import org.apache.ibatis.annotations.Param;


public interface OrderDao {
    Student selectById(@Param("stuId") Integer id);
}
