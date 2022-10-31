<<<<<<< HEAD
package com.school;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "hello world";
    }
}
=======
package com.school;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return "hello world";
    }
}
>>>>>>> a23d072 (add WinXin)
