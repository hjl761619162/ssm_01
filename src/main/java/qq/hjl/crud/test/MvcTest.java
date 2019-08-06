package qq.hjl.crud.test;

import com.github.pagehelper.PageInfo;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import qq.hjl.crud.bean.Employee;

import java.util.List;

/**
 * ClassName: MvcTest <br/>
 * Description: <br/>
 * date: 2019/8/2 20:44<br/>
 *使用spring测试模块提供的测试请求功能，测试crud请求的正确性
 * @author Li<br />
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration   //获取IOC容器中的对象
@ContextConfiguration(locations = {"classpath:applitionContext.xml","file:src/main/webapp/WEB-INF/springmvc.xml"})
public class MvcTest {

    @Autowired
    WebApplicationContext context;
    //虚拟化mvc请求，获取处理结果
    MockMvc mockMvc;

    @Before
    public void initMokcMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    @Test
    public void testPage() throws Exception {
        //模拟请求拿到返回值
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").
                param("pn", "5")).andReturn();

        //请求成功后，请求域中会用pageInfo;我们可以去除pageInfo进行校验
        MockHttpServletRequest request = result.getRequest();
        PageInfo pi = (PageInfo) request.getAttribute("pageInfo");
        System.out.println("当前页码：" + pi.getPageNum());
        System.out.println("总页码：" +pi.getPages());
        System.out.println("总记录数：" +pi.getTotal());
        System.out.println("在页面需要连续显示的页码：");
        int[] nums = pi.getNavigatepageNums();
        for(int i : nums){
            System.out.print(" " +i);
        }
        System.out.println();
        //获取员工数据
        List<Employee> list = pi.getList();
        for(Employee employee : list){
            System.out.println("员工ID:"+employee.getEmpId()+" ，姓名："+employee.getEmpName());
        }

    }
}