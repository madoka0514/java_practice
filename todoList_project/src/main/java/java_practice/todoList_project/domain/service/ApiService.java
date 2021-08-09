package java_practice.todoList_project.domain.service;

import java_practice.todoList_project.controller.model.ResponseModel;
import java_practice.todoList_project.controller.model.TaskModel;
import java_practice.todoList_project.domain.repository.ApiRepository;
import model.Tasktbl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiService {
    @Autowired
    ApiRepository apiRep;
    public ResponseModel getAllTask(){
        TaskModel taskModel = new TaskModel();
        ResponseModel resModel = new ResponseModel();
        Tasktbl tasktbl =apiRep.getTaskName();

        taskModel.setTaskname(tasktbl.getTaskname());

        List<TaskModel> taskModelList = new ArrayList<TaskModel>();

        taskModelList.add(taskModel);
        resModel.setTaskModelList(taskModelList);

        return  resModel;
    }
}
