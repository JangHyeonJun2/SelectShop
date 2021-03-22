package com.sparta.week01;

import com.sparta.week01.domain.Course;
import com.sparta.week01.domain.CourseRepository;
import com.sparta.week01.models.CourseRequestDto;
import com.sparta.week01.service.CourseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class Week01Application {

    public static void main(String[] args) {
        SpringApplication.run(Week01Application.class, args);
        // Week02Application.java 의 main 함수 아래에 붙여주세요.


    }

//    @Bean
//    public CommandLineRunner demo(CourseRepository courseRepository, CourseService courseService) {
//        return (args) -> {
//            courseRepository.save(new Course("프론트엔드의 꽃, 리액트", "임민영"));
//
//            System.out.println("데이터 인쇄");
//            List<Course> courseList = courseRepository.findAll();
//            for (int i=0; i<courseList.size(); i++) {
//                Course course = courseList.get(i);
//                System.out.println(course.getId());
//                System.out.println(course.getTitle());
//                System.out.println(course.getTutor());
//            }
//
////            Course new_course = new Course("웹개발의 봄, Spring", "임민영");
//            CourseRequestDto new_course = new CourseRequestDto("웹개발의 봄, Spring", "임민영");
//            courseService.update(1L, new_course);
//            courseList = courseRepository.findAll();
//            for (int i=0; i<courseList.size(); i++) {
//                Course course = courseList.get(i);
//                System.out.println(course.getId());
//                System.out.println(course.getTitle());
//                System.out.println(course.getTutor());
//            }
//        };
//
//    }

}
