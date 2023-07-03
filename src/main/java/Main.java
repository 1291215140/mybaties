import myclass.albums;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main
{
    pom pom = new pom();
    SqlSession ss = pom.getsqlSession();
    public  void test1() {
        // SqlSession执行文件中定义的SQL，并返回映射结果
        //返回多条数据
        //通过指定id来执行sql语句
        try
        {

            List<albums> listceshi = ss.selectList("selectbums");
        }
        finally
        {
            ss.commit();
            ss.close();
        }

    }
    public   void test2()
    {
        Map<String,String> map = new HashMap<>();

        // 通过 SqlSession 获取 Mapper 接口，通过 Mapper 接口发送 SQL(主流玩法)
        BlogMapper mapper = ss.getMapper(BlogMapper.class);
        try
        {
            map.put("a","a%");
            map.put("b","20");
            List<albums> albumss = mapper.selectallalbums(map);
        }
        finally
        {
            //无论是否执行成功都要关闭
            ss.commit();
            ss.close();
        }
    }

    public static void main(String[] args) {
       Main m =  new Main();
       if(m.ss!=null) m.test2();
    }
}
