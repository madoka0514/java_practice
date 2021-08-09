package java_practice.todoList_project.controller.model;

import lombok.Data;

import java.util.List;

@Data
public class ResponseModel {
    private List<TaskModel> taskModelList;
}
