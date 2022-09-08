package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//LiveReload https://shanepark.tistory.com/215

@Controller
public class HelloController {

    @GetMapping("hello") //웹 어플리케이션에서 /hello 라고 들어오면 이 메서드를 호출
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
     }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    //API (템플릿엔진은 view라는 템플릿을 조작하는 방식이지만, API는 html 없이 문자를 그대로 넘겨줌)
    @GetMapping("hello-string")
    @ResponseBody //http 프로토콜의 body 부에 이 내용을 직접 넣어주겠다는 의미
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}