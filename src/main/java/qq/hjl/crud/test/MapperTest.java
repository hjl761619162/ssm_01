package qq.hjl.crud.test;


import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import qq.hjl.crud.bean.Department;
import qq.hjl.crud.bean.Employee;
import qq.hjl.crud.bean.EmployeeExample;
import qq.hjl.crud.dao.DepartmentMapper;
import qq.hjl.crud.dao.EmployeeMapper;

import java.util.List;
import java.util.UUID;

/**
 * ClassName: MapperTest <br/>
 * Description: <br/>
 * date: 2019/8/1 22:45<br/>
 *测试DAO层的工作
 * 推荐Spring的项目可以使用Spring的单元测试，可以自动注入我们需要的组件
 * 1.导入SpringTest模块
 * 2.@ContextConfiguration 指定spring配置文件的位置
 * 3.直接autowired要用的组件即可
 * @author Li<br />
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applitionContext.xml"})
public class MapperTest {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;
    /**
     * 测试Dept的mapper
     */
    @Test
    public void testCRUD(){
        System.out.println(departmentMapper);
        //测试插入部门
//        departmentMapper.insertSelective(new Department(null,"开发部"));
//        departmentMapper.insertSelective(new Department(null,"测试部"));

        //测试插入单个员工
        employeeMapper.insertSelective(new Employee(null,"Tommmmm","M","Tommmmm@qq.com",1));

        //批量插入若个员工
//        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//        for (int i = 0; i <1000 ; i++) {
//            String uid = UUID.randomUUID().toString().substring(0, 5) + i;
//            mapper.insertSelective(new Employee(null,uid,"M",uid+"@qq.com",1));
//
//        }
//        System.out.println("批量插入完成~");
////        List<Employee> emps = employeeMapper.selectByExampleWithDept(null);
//        List<Department> list = departmentMapper.selectByExample(null);
//        for(Department dept : list){
//            System.out.println(dept.getDeptName());
//        }
        }
    }
