package com.thoughtworks.course.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
  private final CourseRepository courseRepository;

  @Autowired
  public CourseService(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }

  public List<Course> getAllCourses(String topicId) {
    return courseRepository.findCoursesByTopicId(topicId);
  }

  public Course getCoursesById(String id) {
    return courseRepository.findOne(id);
  }

  public void addCourse(Course course) {
    courseRepository.save(course);
  }

  public void updateTopic(Course course, String id) {
    if (courseRepository.exists(id)) courseRepository.save(course);
  }

  public void deleteTopic(String id) {
    courseRepository.delete(id);
  }
}
