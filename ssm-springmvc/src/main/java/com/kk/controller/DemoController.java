package com.kk.controller;

import com.kk.enriry.Address;
import com.kk.enriry.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

//types = Person.class,将所有Person类型的对象放入session域中
//value = "person1",将参数名为person1的数据放入session域中
//@SessionAttributes(types = Person.class) //如果在request域中存放person,那么也同时放在session域中
@Controller
//@RequestMapping("/mapping")
public class DemoController {

    //value=请求映射,method:请求方式,params:必要参数
    @RequestMapping(value = "/success",method = RequestMethod.GET,
                params = {"name=zs","age!=23","!not"})
    public String success(){
        return "success"; //使用视图解析器的方式进行跳转
    }

    //headers:限制请求头
    @RequestMapping(value = "/demo",headers = {"Accept=text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3"
                                    ,"Accept-Encoding=gzip, deflate, br"})
    public String demo(){
        return "success";
    }

    //Ant风格:?(任意单个字符)
    @RequestMapping(value = "/demo2/a?b/test")
    public String demo2(){
        return "success";
    }

    //*(任意字符)
    @RequestMapping(value = "/demo3/*/test")
    public String demo3(){
        return "success";
    }

    //**(任意路径)
    @RequestMapping(value = "/demo4/**/test")
    public String demo4(){
        return "success";
    }

    @RequestMapping("/demo5/{param}")
    public String demo5(@PathVariable("param") String str){
        System.out.println("参数111:"+str);
        return "success";
    }

    /*
        @RequestParam:
            value="abc":获取前台name为abc的数据
            required=true:表示参数值必须要有
     */

    @RequestMapping(value = "/demo6")
    public String demo6(@RequestParam(value = "abc",required = true,defaultValue = "默认值123") String str){
        System.out.println("参数:"+str);
        return "success";
    }

    //@RequestHeader("Accept"):获取请求头中的Accept信息
    @RequestMapping("/demo7")
    public String demo7(@RequestHeader("Accept") String head){
        System.out.println("Accept:"+head);
        return "success";
    }

    @RequestMapping("/demo8")
    public @ResponseBody String demo8(@CookieValue("JSESSIONID") String jsessionid){
        return jsessionid;
    }

    @RequestMapping("/demo9")
    //person属性必须和form表单中的标签name属性一致(支持级联属性),才能赋值
    public @ResponseBody String demo9(Person person){
        return person.toString();
    }

    @RequestMapping("/demo10")
    //在映射方法参数上可以直接使用原生servlet
    public ModelAndView demo10(HttpServletRequest request){
        ModelAndView mav=new ModelAndView();
        //将数据放入request域中
        mav.addObject("mav","ModelAndView");
        mav.setViewName("success");

        return mav;
    }

    @RequestMapping("/demo11")
    public String demo11(Model model, ModelMap modelMap, Map map){
        model.addAttribute("model","model值");
        modelMap.addAttribute("modelmap","modelmap值");
        Person person=new Person();
        person.setId(0);
        person.setName("张三");
        map.put("person1",person);
        map.put("sp",new Person(4,"米斯达"));

        return "success";
    }

    @ModelAttribute //在任何一次请求前,都会先执行被此注解修饰的方法
    public void model(Map map){
        //约定:map的key就是方法参数类型的首字母小写
//        map.put("person",new Person(2,"小明"));

        //也可以使用@ModelAttribute("p123")来指定方法参数名
        map.put("p123",new Person(3,"张三丰"));
    }

    @RequestMapping("/demo12")
    public String demo12(@ModelAttribute("p123") Person person){
        System.out.println(person);
        person.setName("小刚");
        System.out.println(person);

        return "redirect:/success.jsp";
    }

    @RequestMapping("/i18n")
    public String i18n(){
        return "success";
    }

}
