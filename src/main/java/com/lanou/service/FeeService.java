package com.lanou.service;

import com.lanou.domain.Fee;
import com.lanou.utils.PageBean;

import java.util.List;

/**
 * Created by dllo on 17/12/19.
 */
public interface FeeService {

    //    查询所有资费
    PageBean findAllfees(int pageNum, String sort);

    //    添加资费
    String addFee(Fee fee);

    //    修改资费回显
    List<Fee> findCostById(int costId);

    //    修改资费
    String updateFee(Fee fee);

    //    资费详情
    Fee findDetail(int costId);

    //    修改资费状态
    void updateStatus(Fee fee);

    //    验证删除
    String validateDel(int costId);

    //    删除资费
    void deleteFee(int costId);

    //    查找资费状态
    Fee findStatusById(int costId);
}
