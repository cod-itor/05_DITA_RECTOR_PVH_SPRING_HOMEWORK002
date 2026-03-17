package com.HRD.DitaRector.PVH.Spring.repository;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface CourseRepository {
    @Results(id = "courseMapper", value = {
            @Result(property = "courseId" , column = "course_id"),
            @Result(property = "courseName" , column = "course_name")
//            @Result(property = "description" , column = "description")
    })
    @Select(
    "SELECT *  FROM courses OFFSET #{offset} LIMIT #{size}")
    List<Course> getAllCourse(Integer offset, Integer size);


}
