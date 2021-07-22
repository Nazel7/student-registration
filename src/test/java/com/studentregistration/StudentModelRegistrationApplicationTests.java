package com.studentregistration;

import com.studentregistration.Mappers.StudentMapper;
import com.studentregistration.controllers.StudentRegController;
import com.studentregistration.entities.StudentModel;
import com.studentregistration.exceptions.advices.ErrorGlobalException;
import com.studentregistration.respositories.StudentRegistrationRepo;
import com.studentregistration.services.StudentRegistrationService;
import com.studentregistration.usercases.domain.Student;
import com.studentregistration.usercases.dtos.request.StudentDto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

@SpringBootTest
class StudentModelRegistrationApplicationTests {

    @Mock
    private StudentRegistrationRepo mStudentRegistrationRepo;

    private StudentRegistrationService mStudentRegistrationService;

    private StudentRegController mStudentRegController;

    private MockMvc mMvc;

    @BeforeEach
    public void setUp() {
        // Initiate mocked variables for test cases.
        MockitoAnnotations.initMocks(this);

        mStudentRegistrationService = new StudentRegistrationService(mStudentRegistrationRepo);
        mStudentRegController = new StudentRegController(mStudentRegistrationService);

        mMvc = MockMvcBuilders.standaloneSetup(mStudentRegController)
                              .setControllerAdvice(new ErrorGlobalException())
                              .build();
    }

    @Test
    public void validate_register_student_returns_201_for_valid_resquestBody()
            throws Exception {

        // Given
        String URL = "/registration";

        StudentDto studentDto = StudentRegControllerTestUtil.studentDto;
        String studentDtoString = new TestUtil().objectStringConverter(studentDto);
        StudentModel studentModel = StudentMapper.mapToModel(studentDto);

        // When
        Mockito.when(mStudentRegistrationRepo.save(studentModel))
               .thenReturn(studentModel);

        Mockito.when(mStudentRegistrationRepo.findById(Mockito.anyLong()))
               .thenReturn(Optional.of(studentModel));

        // Then
        mMvc.perform(MockMvcRequestBuilders.post(URL).contentType(
                MediaType.APPLICATION_JSON).content(studentDtoString))
            .andExpect(MockMvcResultMatchers.status().isCreated());

    }

    @Test
    public void validate_register_student_returns_400_for_unKnown_resquestBody()
            throws Exception {

        // Given
        String URL = "/registration";

        StudentDto studentDto = StudentRegControllerTestUtil.studentDto;
        String studentDtoString = new TestUtil().objectStringConverter(studentDto);
        StudentModel studentModel = StudentMapper.mapToModel(studentDto);

        // When
        Mockito.when(mStudentRegistrationRepo.save(studentModel))
               .thenReturn(studentModel);

        // Then
        mMvc.perform(MockMvcRequestBuilders.post(URL).contentType(
                MediaType.APPLICATION_JSON).content(""))
            .andExpect(MockMvcResultMatchers.status().isBadRequest());

    }

}
