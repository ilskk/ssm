package com.kk.controller;

import com.kk.enriry.Address;
import com.kk.enriry.Person;
import com.kk.exception.MyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
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
    @RequestMapping(value = "/head",headers = {"Accept=text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3"
                                    ,"Accept-Encoding=gzip, deflate, br"})
    public String head(){
        return "success";
    }

    //Ant风格:?(任意单个字符)
    @RequestMapping(value = "/ant1/a?b/test")
    public String ant1(){
        return "success";
    }

    //*(任意字符)
    @RequestMapping(value = "/ant2/*/test")
    public String ant2(){
        return "success";
    }

    //**(任意路径)
    @RequestMapping(value = "/ant3/**/test")
    public String ant3(){
        return "success";
    }

    @RequestMapping("/result/{param}")
    public String result(@PathVariable("param") String str){
        System.out.println("参数111:"+str);
        return "success";
    }

    /*
        @RequestParam:
            value="abc":获取前台name为abc的数据
            required=true:表示参数值必须要有
     */

    @RequestMapping(value = "/params")
    public String params(@RequestParam(value = "abc",required = true,defaultValue = "默认值123") String str){
        System.out.println("参数:"+str);
        return "success";
    }

    //@RequestHeader("Accept"):获取请求头中的Accept信息
    @RequestMapping("/accept")
    public String accept(@RequestHeader("Accept") String head){
        System.out.println("Accept:"+head);
        return "success";
    }

    @RequestMapping("/jsessionid")
    public @ResponseBody String jsessionid(@CookieValue("JSESSIONID") String jsessionid){
        return jsessionid;
    }

    @RequestMapping(value = "/json",produces = "application/json; charset=utf-8")
    //person属性必须和form表单中的标签name属性一致(支持级联属性)`,才能赋值
    public @ResponseBody String json(Person person){
        return person.toString();
    }

    @RequestMapping("/modelAndView")
    //在映射方法参数上可以直接使用原生servlet
    public ModelAndView modelAndView(HttpServletRequest request){
        ModelAndView mav=new ModelAndView();
        //将数据放入request域中
        mav.addObject("mav","ModelAndView");
        mav.setViewName("success");

        return mav;
    }

    @RequestMapping("/mmm")
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

    @RequestMapping("/modify")
    public String modify(@ModelAttribute("p123") Person person){
        System.out.println(person);
        person.setName("小刚");
        System.out.println(person);

        return "redirect:/success.jsp";
    }

    @RequestMapping("/i18n")
    public String i18n(){
        return "success";
    }

    @RequestMapping("/converter")
    public String converter(@RequestParam("personInfo") Person person){
        System.out.println(person);
        return "success";
    }

    @RequestMapping("/formatting")//如果Person格式化出错,会将出错信息传入BindingResult(只能放在错误参数后一位)
    public String formatting(@Valid Person person, BindingResult result, Map<String,List<FieldError>> map){
        System.out.println(person);

        if(result.getErrorCount()>0){
            for (FieldError error:result.getFieldErrors()) {
                System.out.println(error.getDefaultMessage());
                map.put("errors",result.getFieldErrors());
            }
        }

        return "success";
    }

    @RequestMapping(value = "/ajax",produces = "application/json; charset=utf-8")
    public @ResponseBody List<Address> ajax(){

        List<Address> list=new ArrayList<>();
        list.add(new Address("湖南"));
        list.add(new Address("北京"));
        list.add(new Address("广州"));

        return list;
    }

    @RequestMapping("/upload")
    public String upload(@RequestParam("desc") String desc,@RequestParam("fileName") MultipartFile file,Model model){
        System.out.println("文件描述信息:"+desc);

        InputStream in=null;
        OutputStream out=null;
        try {
           in= file.getInputStream();
            //将要上传到服务器的文件保存到硬盘中
           out=new FileOutputStream("C:\\Users\\Administrator\\Desktop\\material\\"+file.getOriginalFilename());

           byte[] buf=new byte[1024*1024*10];
           int len=0;
           while ((len=in.read(buf))!=-1){
               out.write(buf,0,len);
           }

           model.addAttribute("status","上传成功!");

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "index";
    }

    @RequestMapping("/interceptor")
    public String interceptor(){
        System.out.println("调用控制器方法");
        return "success";
    }

    @RequestMapping("/eh")
    public String exceptionHandler(){
//        try {
            System.out.println(1/0);
//        } catch (ArithmeticException e) {
//            e.printStackTrace();
//        }
        return "success";
    }

    //可以捕获ArithmeticException异常
    @ExceptionHandler({ArithmeticException.class})
    public ModelAndView handleArithmeticException(Exception ex){
        System.out.println(ex);
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception", ex);
        return mv;
    }

    @RequestMapping("/me")
    public String me(@RequestParam("i") Integer i)throws MyException{
        if(i==3){
            throw new MyException();
        }
        return "success";
    }

    @RequestMapping("/ms")
    public String demo19(@RequestParam("i") Integer i)throws MyException{
        if(i==3){
            return "forward:/status";
        }
        return "success";
    }

    @ResponseStatus(value = HttpStatus.CONFLICT,reason = "测试")
    @RequestMapping("/status")
    public String myStatus(){
        return "success";
    }

}

