package com.lanou.mapper;

import com.lanou.domain.Fee;

import java.util.List;

/**
 * Created by dllo on 17/12/19.
 */
public interface FeeMapper {

    //    查询所有资费
    List<Fee> findAllfees(int sort);

    //    添加资费
    int addFee(Fee fee);

    //    修改资费回显
    List<Fee> findCostById(int costId);

    //    修改资费
    void updateFee(Fee fee);

    //    修改资费状态
    void updateStatus(Fee fee);

    //    查名字
    List<Fee> findFeeByName(String name);

    //    资费详情
    Fee findDetail(int costId);

    //    删除资费
    void deleteFee(int costId);

    Fee findStatusById(int costId);
}
