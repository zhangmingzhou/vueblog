package com.markerhub.controller;


import com.markerhub.common.lang.Result;
import com.markerhub.entity.Blog;
import com.markerhub.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2020-09-16
 */
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/{id}")
    public Result getBlogById(@PathVariable("id") Long id){
        Blog blog = blogService.getById(id);
        return Result.succ(blog);
    }

    @PostMapping("/edit")
    public Result insertBlog(@Validated @RequestBody Blog blog){
        blogService.insertOne(blog);
        return Result.succ(200,"添加成功",null);
    }

    @PostMapping("/delete")
    public Result deleteBlog(@Validated @RequestBody Blog blog){
        blogService.deleteOne(blog.getId());
        return Result.succ(200,"删除成功",null);
    }
}
