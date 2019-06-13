package com.jzl.center_web.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.jzl.v13.api.IProductService;
import com.jzl.v13.entity.TProduct;
import com.jzl.v13.pojo.ResultBean;
import com.jzl.v13.pojo.TProductVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目名：v13
 * HAPPY JAVA ！
 * Create by jiangzonglin on 2019-06-11 下午 8:33
 */
@Controller
@RequestMapping("product")
public class ProductController {

    @Reference
    private IProductService productService;

    @RequestMapping("get/{id}")
    @ResponseBody
    public TProduct getById(@PathVariable("id") Long id){
        return productService.selectByPrimaryKey(id);
    }

    @RequestMapping("list")
    public String list(Model model){
        List<TProduct> list = productService.list();
        model.addAttribute("list",list);
        return "product/list";
    }

    @RequestMapping("page/{currentPage}/{pageSize}")
    public String page(@PathVariable("currentPage") Integer currentPage,@PathVariable("pageSize") Integer pageSize,Model model){
        PageInfo<TProduct> page = productService.page(currentPage, pageSize);
        model.addAttribute("page",page);
        return "product/list";
    }

    @RequestMapping("save")
    public String save(TProductVo tProductVo){
        productService.save(tProductVo);

        return "redirect:/product/page/1/1";
    }

    @PostMapping("del/{id}")
    @ResponseBody
    public ResultBean deleteById(@PathVariable("id") Long id){
        int count = productService.deleteByPrimaryKey(id);
        if (count>0) {
            return new ResultBean("200","删除成功");
        }
        return new ResultBean("404","删除失败");
    }

    @PostMapping("batchDel")
    @ResponseBody
    public ResultBean batchDel(@RequestParam List<Long>ids){
        Long count = productService.betchDel(ids);
        if (count>0) {
            return new ResultBean("200","批量删除成功");
        }
        return new ResultBean("404","批量删除失败");
    }


}
