package com.kirinsoft.onlinestore.onlinestore.goods.repository;

import com.kirinsoft.onlinestore.onlinestore.goods.entity.GoodsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository<GoodsEntity, String> {

}
