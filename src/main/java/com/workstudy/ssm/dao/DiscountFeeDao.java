package com.workstudy.ssm.dao;

import com.workstudy.ssm.model.DiscountFee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Alander on 2017/8/4.
 */
@Repository
public interface DiscountFeeDao {
    DiscountFee getTable(@Param("discountfee") DiscountFee discountFee);
    Integer createTable(@Param("discountfee") DiscountFee discountFee);
    List<DiscountFee> getTableByStId(@Param("studentId") String studentId);
    Integer deleteTable(@Param("discountfee") DiscountFee discountFee);
    Integer changeTable(@Param("studentId") String studentId, @Param("tableYear") String tableYear, @Param("result") Integer result);

    List<DiscountFee> getAllTables();

    Integer changeAdminRes(@Param("studentId") String studentId, @Param("tableYear") String tableYear, @Param("result") Integer result);

    Integer deleteTableByInfo(@Param("studentId") String studentId, @Param("tableYear") String tableYear);
    List<DiscountFee> getTablesByYear(@Param("createdYear") String createdYear);
}
