package com.example.jdbctemplate.controller;

import com.example.jdbctemplate.model.Author;
import com.example.jdbctemplate.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author api
 *
 * @author zhouqiang
 */
@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    /**
     * 查询用户列表
     */
    @RequestMapping(method = RequestMethod.GET)
    public Map<String, Object> getAuthorList(HttpServletRequest request) {
        List<Author> authorList = this.authorService.findAuthorList();
        Map<String,Object> param = new HashMap<>(2);
        param.put("total", authorList.size());
        param.put("rows", authorList);
        return param;
    }

    /**
     * 查询用户信息
     * */
    @RequestMapping(value = "/{userId:\\d+}",method = RequestMethod.GET)
    public Author getAuthor(@PathVariable Long userId,HttpServletRequest request){

        Author author = this.authorService.findAuthor(userId);
        if (author == null) {
            throw new RuntimeException("查询错误");
        }
        return author;
    }

    /**
     * 新增方法
     */
    @RequestMapping(method = RequestMethod.POST)
    public int add(@RequestBody Author author){
        int effectRow = 0;

        if (author != null) {
            try {
                effectRow = this.authorService.add(author);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("新增错误");
            }
        }
        return effectRow;
    }

    /**
     * 更新方法
     */
    @RequestMapping(value = "/{userId:\\d+}",method = RequestMethod.PUT)
    public int update (@PathVariable Long userId,@RequestBody Author author){
        int effectRow = 0;
        if (author != null) {
            author.setId(userId);
            try {
                effectRow = this.authorService.update(author);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("更新错误");
            }
        }
        return effectRow;
    }

    /**
     * 删除方法
     */
    @RequestMapping(value = "/{userId:\\d+}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long userId) {
        try{
            this.authorService.delete(userId);
        }catch(Exception e){
            throw new RuntimeException("删除错误");
        }
    }
}
