package com.HRD.DitaRector.PVH.Spring.repository;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Course;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface CourseRepository {
    @Results(id = "courseMapper", value = {
            @Result(property = "courseId" , column = "course_id"),
            @Result(property = "courseName" , column = "course_name"),
            @Result(property = "instructorList" ,column = "course_id",one =  @One(select = "com.HRD.DitaRector.PVH.Spring.repository.InstructorRepository.getInstructorById")),
    })
@Select(
"SELECT *  FROM courses OFFSET #{offset} LIMIT #{size}")
    List<Course> getAllCourse(Integer offset, Integer size);
@ResultMap("courseMapper")
@Select("SELECT * FROM courses WHERE course_id = #{courseId}")
    List<Course> getCourseById(Long courseId);


    @ResultMap("courseMapper")
    @Select("SELECT * FROM courses WHERE course_id IN (SELECT course_id FROM student_course WHERE student_id = #{studentId})")
    List<Course> getCoursesByStudentId(Long studentId);
}

