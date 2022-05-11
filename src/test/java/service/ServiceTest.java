package service;

import domain.Grade;
import domain.Homework;
import domain.Student;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import repository.GradeXMLRepository;
import repository.HomeworkXMLRepository;
import repository.StudentXMLRepository;
import validation.GradeValidator;
import validation.HomeworkValidator;
import validation.StudentValidator;
import validation.Validator;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {

    static Service service;

    @BeforeAll
    static void setUp() {
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Homework> homeworkValidator = new HomeworkValidator();
        Validator<Grade> gradeValidator = new GradeValidator();
        StudentXMLRepository studentXMLRepository = new StudentXMLRepository(studentValidator, "students.xml");
        HomeworkXMLRepository homeworkXMLRepository = new HomeworkXMLRepository(homeworkValidator, "homework.xml");
        GradeXMLRepository gradeXMLRepository = new GradeXMLRepository(gradeValidator, "grades.xml");
        service = new Service(studentXMLRepository, homeworkXMLRepository, gradeXMLRepository);

        service.saveHomework("3", "description1", 3, 2);
        service.saveHomework("4", "description2", 5, 1);
    }

    @AfterAll
    static void tearDown() {
        service.deleteHomework("6");
        service.deleteHomework("3");
        service.deleteHomework("4");
    }

    @org.junit.jupiter.api.Test
    void findAllStudents() {
        assertNotNull(service.findAllStudents());
    }

    @org.junit.jupiter.api.Test
    void saveHomework() {
        assertNotEquals(0, service.saveHomework("6", "description", 5,2),
                "Save homework expected 1");
    }

    @org.junit.jupiter.api.Test
    void deleteHomework() {
        assertTrue(service.deleteHomework("4") == 1);
    }

    @org.junit.jupiter.api.Test
    void updateHomework() {
        assertEquals(1, service.updateHomework("3", "new description", 5, 2));
    }

    @Test
    void extendDeadline() {
        assertEquals(0, service.extendDeadline("3", 3));
    }
}