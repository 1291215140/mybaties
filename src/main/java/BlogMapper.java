import myclass.albums;

import java.util.List;
import java.util.Map;

//定义mapper接口
public interface BlogMapper {

    public List<albums> selectallalbums(Map<String,String> params);
    public List<albums> selectallalbums(List<String> list);
}
