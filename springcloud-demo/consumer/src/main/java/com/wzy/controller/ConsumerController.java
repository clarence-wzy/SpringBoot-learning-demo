package com.wzy.controller;

import com.wzy.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

/**
 * @author Clarence1
 */
@RestController
@RequestMapping(value = "/consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findAll")
    public Collection<Student> findAll() {
        //  getForEntity返回的不是Collection类型，需使用getBody转成Collection类型
//        return restTemplate.getForEntity("http://localhost:8010/student/findAll", Collection.class).getBody();

        //  也可以直接使用getForObject返回Object类型
        //  其中三个参数，第一个是请求地址，第二个是请求类型，第三个是响应类型
        return restTemplate.getForObject("http://localhost:8010/student/findAll", Collection.class);
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") long id) {
        //  getForEntity也可以
        return restTemplate.getForObject("http://localhost:8010/student/findById/{id}", Student.class, id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student) {
        //  三个参数：第一个是请求地址，第二个是请求的消息体，第三个是响应类型
        restTemplate.postForObject("http://localhost:8010/student/save", student, null);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student) {
        //  两个参数：第一个是请求地址，第二个是请求体，这里是更新的学生集合
        restTemplate.put("http://localhost:8010/student/update", student);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") long id) {
        restTemplate.delete("http:/localhost:8010/student/delete/{id}", id);
    }

}
