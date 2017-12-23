package com.lanou.controller;

import com.lanou.domain.Fee;
import com.lanou.service.FeeService;
import com.lanou.utils.AjaxResult;
import org.springframework.asm.Type;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by dllo on 17/12/19.
 */
@Controller
public class FeeController {

    @Resource
    private FeeService feeService;

    //    转到fee_list
    @RequestMapping(value = "/fee_List")
    public String feeList() {

        return "fee/fee_list";

    }

    //    查询所有资费
    @RequestMapping("/findFees")
    @ResponseBody
    public AjaxResult findFees(int pageNum, String sort) {

        return new AjaxResult(feeService.findAllfees(pageNum, sort));
    }

    //    转到添加资费页面
    @RequestMapping("/fee_Add")
    public String feeAdd() {

        return "fee/fee_add";
    }

    //    添加资费
    @RequestMapping("/addFees")
    @ResponseBody
    public String addFee(Fee fee) {

        String s = feeService.addFee(fee);

        return s;
    }

    //    session存下costId,用于回显
    @RequestMapping("/fee_mod")
    @ResponseBody
    public String feeMod(HttpSession session, Fee fee) {

        Fee byId = feeService.findStatusById(fee.getCostId());

        if (byId.getStatus().equals("1")) {

            return "false";

        } else {

            session.setAttribute("costId", fee.getCostId());

        }

        return "success";
    }

    //    跳到修改资费页面
    @RequestMapping("/feeM")
    public String feeM() {

        return "fee/fee_mod";
    }

    //    回显资费
    @RequestMapping("/echoFee")
    @ResponseBody
    public List<Fee> echoFee(HttpSession session) {

        int costId = (int) session.getAttribute("costId");

        List<Fee> costById = feeService.findCostById(costId);

        return costById;
    }


    //    修改资费
    @RequestMapping("/updateFee")
    @ResponseBody
    public String updateFee(Fee fee) {

        String s = feeService.updateFee(fee);

        return s;
    }

    //    修改资费状态
    @RequestMapping("/updateStatus")
    @ResponseBody
    public String updateStatus(Fee fee) {

        feeService.updateStatus(fee);

        return "success";
    }


    //    转到详情页
    @RequestMapping("/fee_detail")
    @ResponseBody
    public String fee_detail(Fee fee, HttpSession session) {

        session.setAttribute("costId", fee.getCostId());

        return "success";
    }

    @RequestMapping("/feeD")
    public String feeDet() {

        return "fee/fee_detail";
    }

    //    回显详情
    @RequestMapping("/findDetail")
    @ResponseBody
    public Fee findDetail(HttpSession session) {

        int costId = (int) session.getAttribute("costId");

        Fee fee = feeService.findDetail(costId);

        return fee;
    }

    //    删除资费
    @RequestMapping("/delFee")
    @ResponseBody
    public String deleteFee(Fee fee) {
        String s = feeService.validateDel(fee.getCostId());
        return s;

    }


}
