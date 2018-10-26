package com.example.mybatis.dao;

import com.example.mybatis.model.Author;
import com.example.mybatis.provider.AuthorSqlProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;


// @Mapper注解：
// @Component注解：是为了解决在注入该bena时不报红，不写也不影响系统运行

/**
 * AuthorDAO.
 * author 数据持久接口
 *
 * @author zhouqiang
 */
@Mapper
@Component
public interface AuthorDAO {
    /*
     * 延伸：对于不是实体类中的单个属性，引用数据类型，或者多个入参的情况下，必须加上@Param注解,否则无法使用EL表达式获取参数。
     *
     * 如果不加，会报ReflectionException
     * 对于单个实体类中的属性参数则可以省略。
     */

    /*
     * 方式一：使用注解编写SQL.
     *
     * */

    /**
     * add.
     *
     * @param author 作者
     * @return 影响行数     int
     * @author zhouqiang
     * @date 2018/7/5 10:51
     */
    @Insert("insert into t_author(real_name,nick_name) values (#{author.nickName},#{author.realName})")
    int add(@Param("author") Author author);

    /**
     * add.
     *
     * @param author 作者
     * @return 影响行数     int
     * @author zhouqiang
     * @date 2018/7/5 10:51
     */
    @Update("update t_author set real_name = #{author.realName},nick_name = #{author.nickName}  where id  = #{author.id}")
    int update(@Param("author") Author author);

    /**
     * add.
     *
     * @param id 作者编号
     * @return 影响行数     int
     * @author zhouqiang
     * @date 2018/7/5 10:51
     */
    @Delete("delete from t_author where id = #{id}")
    int delete(@Param("id") Long id);

    /**
     * add.
     *
     * @param id 作者编号
     * @return author     Author
     * @author zhouqiang
     * @date 2018/7/5 10:51
     */
    @Select("select * from t_author where id = #{id}")
    Author findAuthor(long id);




    /*
     * 延伸：使用mybatis的高级注解，实现动态sql
     * @SelectProvider
     * @InsertProvider
     * @DeleteProvider
     * @UpdateProvider
     *
     * */

    /*
     * 方式2：使用注解指定某个工具类的方法来动态编写SQL.
     *
     * */

    /**
     * listByRealName.
     *
     * @author       zhouqiang
     * @param        realName   真实姓名
     * @return       author     list
     * @date   2018/7/12 17:20
     * */
    @SelectProvider(type = AuthorSqlProvider.class, method = "listByRealName")
    List<Author> listByRealName(String realName);


    /**
     * selectAuthor.
     *
     * <p>根据真实姓名和昵称模糊查找Author</p>
     * @author       zhouqiang
     * @param        realName   真实姓名
     * @param        nickName   昵称
     * @return       Author
     * @date   2018/7/12 17:24
     * */
    @SelectProvider(type = AuthorSqlProvider.class, method = "selectAuthor")
    Author selectAuthor(@Param("realName") String realName, @Param("nickName") String nickName);

    /*
     * 延伸：上述两种方式都可以附加@Results注解来指定结果集的映射关系.如下：
     *
     * 使用GenerateMybatisAnnotation类生成结果集映射。
     *
     * PS：如果符合下划线转驼峰的匹配项可以直接省略不写。
     * 因为在application.yml配置了mybatis自动下划线驼峰的互转
     */

    /**
     * add.
     *
     * @return author     List
     * @author zhouqiang
     * @date 2018/7/5 10:51
     */
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "realName", column = "real_name"),
            @Result(property = "nickName", column = "nick_name")
    })
    @Select("select * from t_author")
    List<Author> findAuthorList();

}
