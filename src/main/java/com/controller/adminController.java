package com.controller;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.config.AlipayConfig;
import com.entity.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.weitaoService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static java.lang.System.out;

@Controller
@RequestMapping("/admin")
public class adminController {

    @Autowired
    private user user;
    @Autowired
    @Qualifier("administrators")
    private com.entity.administrators administrators;
    @Autowired
    private weitaoService weitaoService;

    private int i;
    private int p=0;

    @RequestMapping("/userList")
    public String userList(Model model,HttpSession session,@RequestParam(value = "page", defaultValue = "1") Integer page,
                           @RequestParam(name = "size", defaultValue = "4") int size){
 //         model.addAttribute("userList", weitaoService.userList());
        PageHelper.startPage(page,size);
        List<user> userList=weitaoService.userList();
        session.setAttribute("userList", userList);
        PageInfo<user> hh = new PageInfo<user>(userList);
        model.addAttribute("list", hh);
        return "/admin/yongHuGuanLi";
    }

    @RequestMapping("/selectByTian")
    public String selectByTian(HttpServletRequest request, HttpSession session,Model model,@RequestParam(value = "page", defaultValue = "1") Integer page,
                               @RequestParam(name = "size", defaultValue = "4") int size){
        PageHelper.startPage(page,size);
        Map map=request.getParameterMap();
        out.println(map);
        try{
            BeanUtils.populate(user,map);
            List<user> user1=weitaoService.userList2(user);
            PageInfo<user> hh = new PageInfo<user>(user1);
            session.setAttribute("you",user1);
            model.addAttribute("list", hh);
            session.setAttribute("chazhi",user1);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "/admin/yongHuGuanLi";
    }

    @RequestMapping(value = "/xiugai1/{uId}",method = RequestMethod.POST)
    public String xiugai1(@PathVariable("uId") Integer id,HttpServletRequest request,Model model){
        model.addAttribute("name","xiugai");
        Map map=request.getParameterMap();
        user.setuId(id);
        try{
            BeanUtils.populate(user,map);
            i=weitaoService.xiugai1(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (i==1){
            return "/admin/xiuGaiCG";
        }else {
            return "/admin/xiuGaiSB";
        }
    }

    @RequestMapping("/chakan2/{uId}")
    public String chakan2(@PathVariable("uId") Integer uid,Model model){
        user user1=weitaoService.chankan2(uid);
        model.addAttribute("chakan2",user1);
//        session.setAttribute("chakan2",user1);
        return "/admin/updataUser";
    }

    @RequestMapping("/shanChu1/{uId}")
    public String shanChu1(@PathVariable("uId") Integer uId,Model model){
        model.addAttribute("name","shanchu");
        i=weitaoService.shanChu1(uId);
        if (i==1){
            return "/admin/xiuGaiCG";
        }else {
            return "/admin/xiuGaiSB";
        }
    }

    @RequestMapping("/userAdd")
    public String userAdd(HttpServletRequest request,Model model){
        model.addAttribute("name","add");
        Map map=request.getParameterMap();
        try{
            BeanUtils.populate(user,map);
            i=weitaoService.userAdd(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (i==1){
            return "/admin/xiuGaiCG";
        }else {
            return "/admin/xiuGaiSB";
        }
    }

    @RequestMapping("delete1")
    public String delete1(@RequestParam("uid") List<Integer> idList,Model model){
        model.addAttribute("name","piliangshanchu");
       for (int n=0;n<idList.size();n++){
           int m=idList.get(n);
           p=weitaoService.shanChu1(m);
       }
        if (p>0){
            return "/admin/xiuGaiCG";
        }else {
            return "/admin/xiuGaiSB";
        }
    }

    @RequestMapping("/showAllBuys")
    public String showAllBuys(Model model , @RequestParam(value = "page",defaultValue = "1") Integer page,@RequestParam(name = "size",defaultValue = "4") Integer size)
    {
        PageHelper.startPage(page,size);
        List<appraise> appraises=weitaoService.showAllBuys();
        PageInfo<appraise> p=new PageInfo<>(appraises);
        model.addAttribute("pageInfo",p);
        return "/liuYan/appraise";
    }
    @RequestMapping("/delBuysById")
    public String delBuysById(HttpServletRequest request,@RequestParam("id") List<Integer> aId)
    {
        for(int i=0;i<aId.size();i++)
        {
            int id=aId.get(i);
            weitaoService.delBuysById(id);
        }

        return "redirect:/admin/showAllBuys";
    }
    @RequestMapping("/search")
    public String search(Model model,HttpSession session,
                         @RequestParam(value = "page",defaultValue = "1") int page,
                         @RequestParam(name = "size",defaultValue = "4") int size,@RequestParam("uNiCheng") String uNiCheng,
                         @RequestParam("gName") String gName)
    {
        PageHelper.startPage(page,size);

        //System.out.println(uNiCheng+" "+gName);
        try
        {
            appraise appraise=new appraise();
            appraise.setuNiCheng(uNiCheng);
            appraise.setgName(gName);
            List<appraise> appraises=weitaoService.search(appraise);
            out.println(appraises);
            PageInfo<appraise> list=new PageInfo<>(appraises);
            session.setAttribute("search",appraises);
            model.addAttribute("pageInfo",list);
            session.setAttribute("chazhao",appraises);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return "/liuYan/appraise";
    }

    @RequestMapping("/addGoods")
    public String addGoods(HttpServletRequest request, Model model, @RequestParam("gImage")MultipartFile img) {
        try {
            goods goods = new goods();
            Map<String, String[]> map = request.getParameterMap();
            BeanUtils.populate(goods, map);
            //设置编码
            request.setCharacterEncoding("utf-8");
            //获取参数
            String path=request.getServletContext().getRealPath("/")+"goodsImage\\";
            out.println(path);
            String uuid= UUID.randomUUID().toString();
            uuid=uuid.replace("-","");
            String goodsImageName=img.getOriginalFilename();
            goodsImageName=uuid+goodsImageName;
            String savePath=request.getScheme()+"://"
                    +request.getServerName()+":"
                    +request.getServerPort()+request.getContextPath()+"/goodsImage/"+goodsImageName;
            goods.setgImage(savePath);
            File target=new File(path,goodsImageName);
            img.transferTo(target);
            out.println(goods);
            weitaoService.addGoods(goods);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/admin/showAllGoods";
    }

    @RequestMapping("showAllGoods")
    public String showAllGoods(Model model){
       List<goods> goods= weitaoService.goods();
       model.addAttribute("ggg",goods);
        return "/admin/showAllGoods";
    }
    @RequestMapping("buy")
    public String buy(@RequestParam("gid") Integer gid,Model model)throws Exception{
        goods goods=weitaoService.buy1(gid);
        Date vNow = new Date();
        String sNow = "";
        sNow += vNow.getYear();
        sNow += vNow.getMonth()+1;
        sNow += vNow.getDate();
        sNow += vNow.getHours();
        sNow += vNow.getMinutes();
        sNow += vNow.getSeconds();
        sNow += vNow.getDate();
        UUID uuid=UUID.randomUUID();
        String uuidd=uuid.toString().replaceAll("-","");
        sNow=sNow+uuidd;
        model.addAttribute("dingdanhao",sNow);
        model.addAttribute("goods",goods);
        return "/alipay/index";
    }

//    @RequestMapping(value = "/insert1",method = RequestMethod.POST)
//       public String insert1(@RequestParam("WIDout_trade_no") String dDingdanhao,@RequestParam("WIDsubject")String gName,
//                        @RequestParam("WIDtotal_amount") Double gPrice, @RequestParam("WIDbody") Integer dGid,
//                          @RequestParam("uid") Integer uid, HttpServletResponse response,
//                          HttpServletRequest request) throws Exception{
//        dingdan dingdan=new dingdan();
//        dingdan.setdDingdanhao(dDingdanhao);
//        dingdan.setdGid(dGid);
//        dingdan.setdUid(uid);
//         weitaoService.insert1(dingdan);
//         return "/alipay/alipay.trade.page.pay";
//    }

//    @ResponseBody
//    @RequestMapping(value = "hh",method = RequestMethod.POST)
//    public void hh(HttpServletResponse response) throws Exception{
//        response.getWriter().print("ww");
//    }

    @RequestMapping("/home")
    public String toAdminHome(){
        return "/admin/guanLiYuanShouYe";
    }

    @RequestMapping("/top")
    public String top(){ return "/admin/top"; }

    @RequestMapping("/left")
    public String left(){ return "/admin/left"; }

    @RequestMapping("/exit")
    public String exit(HttpServletRequest request){
        request.getSession().removeAttribute("admin");
        return "/admin/adminLogin";
    }

    @RequestMapping("/oneGood")
    public String oneGood(@RequestParam Integer gId, Model model){
        goods good = weitaoService.buy1(gId);
        out.println(good);
        model.addAttribute("good", good);
        return "/admin/good";
    }

    @RequestMapping("/deleteGoods")
    public String deleteGood(@RequestParam Integer gId) {
        weitaoService.delGoodById(gId);
        return "redirect:showAllGoods";
    }

    @RequestMapping("/findGood")
    public String findGood(@RequestParam Integer gId, Model model) {
        goods good = weitaoService.buy1(gId);
        model.addAttribute("good", good);
        return "/admin/updateGood";
    }

    @RequestMapping("/updateGood")
    public String updateGood(@RequestParam("gImage") MultipartFile img, HttpServletRequest request, Model model){
        try {
            out.println(img);
            goods goods = new goods();
            Map<String, String[]> map = request.getParameterMap();
            BeanUtils.populate(goods, map);
            //设置编码
            request.setCharacterEncoding("utf-8");
            //获取参数
            String path=request.getServletContext().getRealPath("/")+"goodsImage\\";
            String uuid= UUID.randomUUID().toString();
            uuid=uuid.replace("-","");
            String goodsImageName=img.getOriginalFilename();
            goodsImageName=uuid+goodsImageName;
            String savePath=request.getScheme()+"://"
                    +request.getServerName()+":"
                    +request.getServerPort()+request.getContextPath()+"/goodsImage/"+goodsImageName;
            goods.setgImage(savePath);
            File target=new File(path,goodsImageName);//拼接，path为父目录，goodsImageName为子目录
            img.transferTo(target);
            weitaoService.updateGoods(goods);
            model.addAttribute("good", goods);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/admin/good";
    }
}
