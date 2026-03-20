package com.HRD.DitaRector.PVH.Spring.repository;

import com.HRD.DitaRector.PVH.Spring.model.Entity.Student;
import com.HRD.DitaRector.PVH.Spring.model.Request.StudentsRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentRepository {
    @Results(id = "studentMapper", value = {
            @Result(property = "studentId",   column = "student_id"),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "email",       column = "email"),
            @Result(property = "courseList",  column = "student_id",
                    many = @Many(select = "com.HRD.DitaRector.PVH.Spring.repository.CourseRepository.getCoursesByStudentId"))
    })

@Select("SELECT * FROM students OFFSET #{offset} LIMIT #{size}")
    List<Student> getAllStudent(Integer offset, Integer size);

@ResultMap("studentMapper")
@Select("SELECT * FROM students WHERE student_Id = #{studentId}")
    Student getStudentById(Long studentId);
    @Select("INSERT INTO students (student_name, email, phone_number) " +
            "VALUES (#{req.studentName}, #{req.email}, #{req.phoneNumber}) " +
            "RETURNING student_id")
    Long insertStudent(@Param("req") StudentsRequest studentsRequest);

    @ResultMap("studentMapper")
    @Select("SELECT * FROM students WHERE student_id = #{studentId}")
    Student getStudentWithCoursesById(Long studentId);
    @Insert("INSERT INTO student_course (student_id, course_id) VALUES (#{studentId}, #{courseId})")
    int insertStudentCourse(@Param("studentId") Long studentId, @Param("courseId") Integer courseId);
@ResultMap("studentMapper")
@Delete("DELETE FROM student_course WHERE student_id = #{id}")
int deleteStudentRelated(Long studentId);

    @Delete("DELETE FROM students WHERE student_id = #{id}")
    int deleteStudentById(Long studentId);
    @Update("UPDATE students SET student_name = #{req.studentName}, " +
            "email = #{req.email}, phone_number = #{req.phoneNumber} " +
            "WHERE student_id = #{studentId}")
    int updateStudentById(@Param("studentId") Long studentId, @Param("req") StudentsRequest studentsRequest);

}
