package com.lanou.service.impl;

import com.lanou.domain.Fee;
import com.lanou.mapper.FeeMapper;
import com.lanou.service.FeeService;
import com.lanou.utils.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dllo on 17/12/19.
 */
@Service
public class FeeServiceImpl implements FeeService {
    @Resource
    private FeeMapper feeMapper;

    @Override
    public PageBean findAllfees(int pageNum, String sort) {

//        初始的默认值
        int sortStatus = 0;

        if (sort.equals("feeDESC")) {

            sortStatus = 4;

        } else if (sort.equals("feeASC")) {

            sortStatus = 3;

        } else if (sort.equals("timeDESC")) {

            sortStatus = 2;

        } else if (sort.equals("timeASC")) {

            sortStatus = 1;
        }

        List<Fee> allfees = feeMapper.findAllfees(sortStatus);

        PageBean<Fee> pageBean = new PageBean<Fee>(pageNum, 5, allfees.size());

        List<Fee> list = new ArrayList<>();

        int end = pageBean.getStartIndex() + 5;

        if (end >= pageBean.getTotalRecord()) {

            end = pageBean.getTotalRecord();
        }

        int start = pageBean.getStartIndex();

        if (start > pageBean.getTotalRecord()) {

            start = start - 5;
        }
        for (int i = start; i < end; i++) {

            list.add(allfees.get(i));
        }
        pageBean.setData(list);

        return pageBean;
    }

    //    添加资费
    @Override
    public String addFee(Fee fee) {

        if (fee.getName().equals("") || fee.getName() == null) {

            return "nameNull";

        } else if (feeMapper.findFeeByName(fee.getName()).size() != 0) {

            return "nameExist";

        } else if (fee.getDescr() == null && fee.getDescr().equals("")) {

            return "descrNull";

        } else {

            fee.setStatus("0");

            fee.setCreatime(new Date());


            feeMapper.addFee(fee);

            return "add";
        }
    }

    //    回显资费
    @Override
    public List<Fee> findCostById(int costId) {

        return feeMapper.findCostById(costId);
    }


    //    修改资费
    @Override
    public String updateFee(Fee fee) {

        if (fee.getName() == null && fee.getName().equals("")) {

            return "nameNull";

        } else if (fee.getBaseDuration() == 0) {

            return "baseDNull";

        } else if (fee.getBaseCost() == 0) {

            return "baseCNull";

        } else if (fee.getUnitCost() == 0) {

            return "unitNull";

        } else {

            feeMapper.updateFee(fee);
        }
        return "upd";
    }

    @Override
    public Fee findDetail(int costId) {

        return feeMapper.findDetail(costId);

    }

    //    修改资费状态
    @Override
    public void updateStatus(Fee fee) {

        fee.setStartime(new Date());

        feeMapper.updateStatus(fee);
    }

    //    验证删除
    @Override
    public String validateDel(int costId) {
        if (feeMapper.findDetail(costId).getStatus().equals("0")) {
            deleteFee(costId);
            return "success";
        } else {
            return "false";
        }
    }

    //    删除资费
    @Override
    public void deleteFee(int costId) {

        feeMapper.deleteFee(costId);
    }

    //    查找此资费的状态
    @Override
    public Fee findStatusById(int costId) {

        return feeMapper.findStatusById(costId);
    }

}
