package com.account.service;

import com.account.Controller.BaseController;
import com.account.domain.Prod;
import com.account.domain.ProdCome;
import com.account.domain.ProdOut;
import com.account.mapper.ProdComeMapper;
import com.account.mapper.ProdMapper;
import com.account.mapper.ProdOutMapper;
import com.account.util.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: scn
 * @Date: 2018/7/18 11:16
 * @Description:
 */
@Service
public class ProdService extends BaseController {

    @Autowired
    private ProdMapper prodMapper;
    @Autowired
    private ProdComeMapper prodComeMapper;

    public ReturnResult insert(Prod prod) {
        try {
            if (prod == null) {
                return ReturnResult.error("产品名称不能为空");
            }
            if (StringUtils.isEmpty(prod.getId())) {
                prod.setCreateTime(new Date());
                prodMapper.insert(prod);
                //保存进货信息
                ProdCome come = new ProdCome();
                come.setProdId(prod.getId());
                Date date = new Date();
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
                come.setBatch(format.format(date));
                come.setComeTime(new SimpleDateFormat("yyyy-MM-dd hh:hh:mm").format(date));
                come.setComeCount(prod.getCurrentCount());
                come.setCreateTime(date);
                come.setPrice(prod.getPrice());
                come.setCurrentCount(prod.getCurrentCount());
                come.setCreateUser(1);
                prodComeMapper.insert(come);
            } else {
                Prod prodOld = prodMapper.selectByPrimaryKey(prod.getId());
                prodOld.setName(prod.getName());
                prodOld.setRemark(prod.getRemark());
                prodOld.setUpdateTime(new Date());
                prodMapper.updateByPrimaryKey(prodOld);
            }

            return ReturnResult.success("插入成功");
        } catch (Exception e) {
            return ReturnResult.error("插入失败" + e);
        }
    }

}
