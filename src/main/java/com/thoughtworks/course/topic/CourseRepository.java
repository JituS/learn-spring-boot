package com.thoughtworks.course.topic;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String>{
  public List<Course> findCoursesByTopicId(String topicId);
}
