package school.hei.haapi.endpoint.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import school.hei.haapi.endpoint.rest.mapper.CourseMapper;
import school.hei.haapi.endpoint.rest.model.Course;
import school.hei.haapi.model.BoundedPageSize;
import school.hei.haapi.model.PageFromOne;
import school.hei.haapi.service.CourseService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class CourseController {
    private final CourseService courseService;
    private final CourseMapper courseMapper;

    @GetMapping(value = "/courses")
    public List<Course> getAllCourses(
            @RequestParam("page") PageFromOne page,
            @RequestParam("page_size") BoundedPageSize pageSize){
        return courseService.getAll(page,pageSize).stream()
                .map(courseMapper::toRestCourse)
                .collect(Collectors.toUnmodifiableList());
    }
}
