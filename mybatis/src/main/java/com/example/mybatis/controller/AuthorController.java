package com.example.mybatis.controller;

import com.example.mybatis.model.Author;
import com.example.mybatis.service.AuthorService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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
            log.info("[- 错误 -] 获取author资源 --- [- {} -]","查询为空");
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
                log.error("[- 异常 -] 添加作者 --- 异常类型 : [- {} -] --- 堆栈信息 : [- {} -]",e,e.getStackTrace());
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
               log.error("[- 异常 -] 更新 --- 异常类型 : [- {} -] --- 堆栈信息 : [- {} -]",e,e.getStackTrace());
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
            log.error("[- 异常 -] 删除 --- 异常类型 : [- {} -] --- 堆栈信息 : [- {} -]",e,e.getStackTrace());
        }
    }

}
