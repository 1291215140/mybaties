import myclass.albums;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test1
{
    public static void main(String[] args) {
        try {
            // 读取配置文件mybatis-config.xml
            InputStream config = Resources.getResourceAsStream("mybaties-config.xml");
            // 根据配置文件构建SqlSessionFactory
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
            // 通过SqlSessionFactory创建SqlSession
            SqlSession ss = ssf.openSession();
            // SqlSession执行文件中定义的SQL，并返回映射结果
            //返回多条数据
            //通过指定id来执行sql语句
            List<albums> listceshi = ss.selectList("BlogMapper.tiaojian");
            for(albums l:listceshi)
            {
                System.out.println(l.getTitle());
            }
            ss.commit();
            ss.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
