package com.example.redisdemo.dao;

import com.example.redisdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author TangZongHua
 * @date 2020/10/22
 * @description:
 */
public interface UserDao extends JpaRepository<User, Long> {
}
