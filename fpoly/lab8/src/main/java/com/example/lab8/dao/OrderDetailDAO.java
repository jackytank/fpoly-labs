package com.example.lab8.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lab8.entity.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail,Long> {
}
