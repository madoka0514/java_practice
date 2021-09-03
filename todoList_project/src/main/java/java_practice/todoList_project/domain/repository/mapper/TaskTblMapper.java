package java_practice.todoList_project.domain.repository.mapper;

import java.util.List;
import java_practice.todoList_project.domain.repository.entity.Tasktbl;
import java_practice.todoList_project.domain.repository.entity.TasktblExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface TaskTblMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(TasktblExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(TasktblExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String taskname);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Tasktbl row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(Tasktbl row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Tasktbl> selectByExample(TasktblExample example);

    List<Tasktbl> selectAll();
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Tasktbl selectByPrimaryKey(String taskname);

    List<Tasktbl> selectPriflgTask(String primaryflag);
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("row") Tasktbl row, @Param("example") TasktblExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("row") Tasktbl row, @Param("example") TasktblExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(Tasktbl row);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Tasktbl row);
}
