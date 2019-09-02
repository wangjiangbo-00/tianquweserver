package com.ziyoushenghuo.repository;



import com.ziyoushenghuo.entry.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by RXJ on 2017/4/5.
 */
@Repository
public interface GoodsSkuRepository extends JpaRepository<GoodsSku,Long> {


    GoodsSku findById(int  id);


    List<GoodsSku> findAllByGoodsid(int goodsid);

}