package com.pisces.sell.repository;

import com.pisces.sell.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>Title: OrderMasterRepository </p>
 * <p>Description:  </p>
 *
 * @author christopher
 * @version 1.0
 * @date 2019-3-4 22:02
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
