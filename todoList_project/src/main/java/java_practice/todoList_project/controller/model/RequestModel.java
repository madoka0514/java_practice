package java_practice.todoList_project.controller.model;

import lombok.Data;

import java.util.List;

@Data
public class RequestModel {
    private List<TaskModel> taskModelList;
}
