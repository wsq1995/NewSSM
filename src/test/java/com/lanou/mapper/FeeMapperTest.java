package com.lanou.mapper;

import com.lanou.domain.Fee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/12/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:SSM-mybatis.xml")
public class FeeMapperTest {

    @Resource
    private FeeMapper feeMapper;

//    @Test
//    public void findAllfees() throws Exception {
//        feeMapper.findAllfees().forEach(System.out::println);
//    }

    @Test
    public void addFee() throws Exception {
        Fee fee = new Fee("15元", '中', 6, 2, 1, "哈哈哈");
        feeMapper.addFee(fee);
    }

    @Test
    public void findCostyId() throws Exception {
        feeMapper.findCostById(2).forEach(System.out::println);
    }

    @Test
    public void updateFee() throws Exception {
        Fee fee = new Fee();
        fee.setCostId(1);
        fee.setName("koko");
        fee.setBaseDuration(2);
        fee.setBaseCost(2);
        fee.setUnitCost(1);
        feeMapper.updateFee(fee);
    }

    @Test
    public void findDetail() throws Exception {
//        feeMapper.findDetail(4).forEach(System.out::println);
    }

    @Test
    public void updateStatus() throws Exception {
        Fee fee = new Fee();
        fee.setCostId(1);
        fee.setStatus("1");
        feeMapper.updateStatus(fee);
    }


    @Test
    public void deleteFee() throws Exception {
        feeMapper.deleteFee(21);
    }
}