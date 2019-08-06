package qq.hjl.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qq.hjl.crud.bean.Department;
import qq.hjl.crud.dao.DepartmentMapper;

import java.util.List;

/**
 * ClassName: DepartmentService <br/>
 * Description: <br/>
 * date: 2019/8/4 21:40<br/>
 *
 * @author Li<br />
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> getDepts() {
        List<Department> list = departmentMapper.selectByExample(null);
        return list;
    }
}