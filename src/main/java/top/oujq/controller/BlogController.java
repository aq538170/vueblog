package top.oujq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.oujq.dto.BlogDTO;
import top.oujq.service.BlogService;
import top.oujq.utils.JsonUtil;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @RequestMapping("/list")
    public String list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                       @RequestParam(value = "size", defaultValue = "10") Integer size){
        PageRequest request = PageRequest.of(page -1, size);
        Page<BlogDTO> blogDTOPage = blogService.findAll(request);

        return JsonUtil.tojson(blogDTOPage);
    }

    @RequestMapping("/{blogId}")
    public String getOne(@PathVariable("blogId") Integer blogId){
        return JsonUtil.tojson(blogService.findOne(blogId));
    }
}
