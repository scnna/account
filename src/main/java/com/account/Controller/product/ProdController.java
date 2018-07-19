package com.account.Controller.product;

import com.account.Controller.BaseController;
import com.account.domain.Prod;
import com.account.domain.ProdCome;
import com.account.service.ProdService;
import com.account.util.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: scn
 * @Date: 2018/7/18 11:16
 * @Description:
 */
@Controller
@RequestMapping("/product/")
public class ProdController extends BaseController {

    @Autowired
    private ProdService prodService;

    @GetMapping("/toProduct")
    public String toProduct() {
        return "/html/product/product.html";
    }


    @PostMapping("/insert")
    @ResponseBody
    public ReturnResult insert(@RequestBody Prod prod, HttpSession session) {
        try {
//            if (getUserId(session) == null) {
//                return ReturnResult.error("请您先登录");
//            }
//            int userId = (int) getUserId(session);
            if (prod == null||StringUtils.isEmpty(prod.getName())) {
                return ReturnResult.error("产品名称不能为空");
            }
//            prod.setCreateUser(userId);
            prodService.insert(prod);
            return ReturnResult.success("插入成功");
        } catch (Exception e) {
            return ReturnResult.error("插入失败" + e);
        }
    }

}
