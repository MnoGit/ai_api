package com.example.springsecurity.repository;

import com.example.springsecurity.model.entity.Student;
import com.example.springsecurity.model.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface UserRepository {
    @Result(
            property = "roleName", column = "role_name"
    )
    @Select("""
                        select u.*, r.name role_name from users u
                                    inner join role r on u.role_id = r.id
                                    where u.name = #{name}
            """)
    UserInfo getUserByUserName(@Param("name") String name);

//    @Select("INSERT INTO users (name, password, email, role) VALUES (#{info.name}, #{info.password}, #{info.email}, #{info.role}) RETURNING *")
//    Integer saveUser(@Param("info") UserRequest userRequest);

//    @Select("""
//            SELECT * FROM users WHERE #{name}
//            """)
//    UserInfo findByName(@Param("name") String name);

    @Select("""
            select * from student
            """)
    List<Student> test();
}
