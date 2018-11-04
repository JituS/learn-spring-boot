package com.thoughtworks.course.topic;

import com.thoughtworks.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

  private final CourseService courseService;

  @Autowired
  public CourseController(CourseService courseService) {
    this.courseService = courseService;
  }

  @RequestMapping("/topics/{topicId}/courses")
  public List<Course> getAllCourses(@PathVariable("topicId") String topicId) {
    return courseService.getAllCourses(topicId);
  }

  @RequestMapping("/topics/{topicId}/courses/{id}")
  public Course getCourseById(@PathVariable String id) {
    return courseService.getCoursesById(id);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
  public void addCourse(@RequestBody Course course, @PathVariable("topicId") String topicId) {
    course.setTopic(new Topic(topicId, "", ""));
    courseService.addCourse(course);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
  public void updateTopic(@RequestBody Course course, @PathVariable("topicId") String topicId, @PathVariable("id") String id) {
    course.setTopic(new Topic(topicId, "", ""));
    courseService.updateTopic(course, id);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
  public void deleteCourse(@PathVariable("id") String id) {
    courseService.deleteTopic(id);
  }
}
