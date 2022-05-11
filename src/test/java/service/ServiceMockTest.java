package service;

import org.junit.Test;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import repository.GradeXMLRepository;
import repository.HomeworkXMLRepository;
import repository.StudentXMLRepository;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class ServiceMockTest {
    @Mock
    private  StudentXMLRepository studentXmlRepositryMock;

    @Mock
    private  HomeworkXMLRepository homeworkXMLRepositoryMock;

    @Mock
    private  GradeXMLRepository gradeXmlRepositryMock;

    @Mock
    private Service service;

    @BeforeEach
    public void init() {
        //MockitoAnnotations.initMocks(this);
        studentXmlRepositryMock = mock(StudentXMLRepository.class);
        //System.out.println("itt");

        homeworkXMLRepositoryMock = mock(HomeworkXMLRepository.class);

        service = new Service(studentXmlRepositryMock, homeworkXMLRepositoryMock, gradeXmlRepositryMock);
        MockitoAnnotations.initMocks(this);

    }

    @Test
    void findAllStudents() {
    }

    @Test
    void saveHomework() {
    }

    @Test
    void deleteHomework() {
    }

    @Test
    void updateHomework() {
    }

    @Test
    void extendDeadline() {
    }
}