package java_practice.todoList_project.controller;

import java_practice.todoList_project.controller.model.RequestModel;
import java_practice.todoList_project.controller.model.ResponseModel;
import java_practice.todoList_project.domain.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

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

    @PostMapping(value="/insertTask")
    //新規タスクを登録する
    //TaskModel配列としてパラメータを受け取る
    public void insertTask(@RequestBody RequestModel reqModel){
        try {
            apiSvc.insertTask(reqModel);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // タスクを削除する
    @PostMapping(value="/deleteTask")
    public void deleteTask(@RequestBody RequestModel reqModel){
        apiSvc.deleteTask(reqModel);
    }

    // タスクを更新する
    @PostMapping(value="/updateTask")
    public void updateTask(@RequestBody RequestModel reqModel){
        try {
            apiSvc.updateTask(reqModel);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }

    // 完了済みのタスクのみ取得する
    @GetMapping(value="/finishTaskList")
    public ResponseEntity<Object> getFinishTaskList(){
        ResponseModel resModel = apiSvc.getFinishTaskList();
        return new ResponseEntity<Object>(resModel,HttpStatus.OK);
    }

}
