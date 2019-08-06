package qq.hjl.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import qq.hjl.crud.bean.Department;
import qq.hjl.crud.bean.Msg;
import qq.hjl.crud.service.DepartmentService;

import java.util.List;

/**
 * ClassName: DepartmentController <br/>
 * Description: <br/>
 * date: 2019/8/4 21:38<br/>
 *处理和部门有关的请求
 * @author Li<br />
 */
@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    /**
     * 查询所有的部门信息
     * @return Msg.success().add("depts",list)
     */
    @RequestMapping(value = "/depts")
    @ResponseBody
    public Msg getDepts(){
        List<Department> list = departmentService.getDepts();
        return  Msg.success().add("depts",list);
    }
}
