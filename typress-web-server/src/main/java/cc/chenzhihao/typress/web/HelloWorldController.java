package cc.chenzhihao.typress.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Hello World
 *
 * @author chenzhihao
 * @date 2023-12-22 17:16
 */
@Controller
@RequestMapping("/")
public class HelloWorldController {

    @RequestMapping
    @ResponseBody
    public String index() {
        return "Hello World";
    }
}
