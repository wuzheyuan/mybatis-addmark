import com.learn.dao.BlogMapper;
import com.learn.dao.BlogMapperExt;
import com.learn.pojo.Blog;
import com.learn.pojo.BlogAndAuthor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MybatisTest {

    @Test
    public void testSelectById(){
        try{
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = factory.openSession();
            SqlSession sqlSession2 = factory.openSession();
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
//            BlogMapper mapper2 = sqlSession2.getMapper(BlogMapper.class);
            Blog blog = (Blog) mapper.selectByPrimaryKey(2);
            sqlSession.commit();
//            Blog blog2 = (Blog) mapper2.selectByPrimaryKey(2);
            System.out.println(blog);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectBlogAndAuthor(){
        try{
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession sqlSession = factory.openSession();
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            BlogAndAuthor blog = (BlogAndAuthor) mapper.selectBlogAndAuthor(1);
            System.out.println(blog);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectBlogWithQueryMap(){
        try{
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession sqlSession = factory.openSession();
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            BlogAndAuthor blog = (BlogAndAuthor) mapper.selectBlogWithAuthorQuery(1);
            System.out.println(blog.getAuthor().getAuthorId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectByName(){
        try{
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession sqlSession = factory.openSession();
            BlogMapperExt mapper = sqlSession.getMapper(BlogMapperExt.class);
            List<Blog> blog = (List<Blog>) mapper.selectByName("哈哈1",10,0);
            System.out.println(blog);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testSave(){
        try{
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = factory.openSession();
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            Blog blog = new Blog();
            blog.setAuthorId(2);
            blog.setName("哈哈");
            List<Integer> flags = new ArrayList<>();
            flags.add(1);
            flags.add(3);
            blog.setFlags(flags);
            mapper.insert(blog);
            sqlSession.commit();
            System.out.println(blog);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete(){
        try{
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = factory.openSession();
            BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            mapper.deleteByPrimaryKey(1);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
