import myclass.albums;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//
public class test
{
    public static void main(String[] args) {
        try {
            // 读取配置文件mybatis-config.xml
            InputStream config = Resources.getResourceAsStream("mybaties-config.xml");
            // 根据配置文件构建SqlSessionFactory
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
            // 通过SqlSessionFactory创建SqlSession
            SqlSession ss = ssf.openSession();
            //建个字典
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
