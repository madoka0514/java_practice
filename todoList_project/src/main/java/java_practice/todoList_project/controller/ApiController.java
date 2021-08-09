package java_practice.todoList_project.controller;

import java_practice.todoList_project.controller.model.RequestModel;
import java_practice.todoList_project.controller.model.ResponseModel;
import java_practice.todoList_project.domain.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/todoList")
public class ApiController{
    @Autowired
    ApiService apiSvc;

    @GetMapping(value = "/showList")
    // 全タスク一覧を表示する
    public ResponseEntity<Object> returnName(){
        ResponseModel resModel = apiSvc.getAllTask();
        return new ResponseEntity<Object>(resModel,HttpStatus.OK);
    }
}
