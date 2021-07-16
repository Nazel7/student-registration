package com.studentregistration.services;

import com.studentregistration.Mappers.StudentMapper;
import com.studentregistration.entities.StudentModel;
import com.studentregistration.exceptions.StudentNotFoundException;
import com.studentregistration.interfaces.IStudentRegistationService;
import com.studentregistration.respositories.StudentRegistrationRepo;
import com.studentregistration.usercases.domain.Student;
import com.studentregistration.usercases.dtos.request.StudentDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.NotActiveException;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class StudentRegistrationService implements IStudentRegistationService {

    private final StudentRegistrationRepo mStudentRegistrationRepo;

    @Override
    public Student saveStudent(StudentDto studentDto) {

        final StudentModel studentModel= StudentMapper.mapToModel(studentDto);
        final StudentModel saveStudentModel = mStudentRegistrationRepo.save(studentModel);
        log.info("::: registered student with regNo: [{}] store to DB :::", saveStudentModel
                .getRegistrationNo());

        return StudentMapper.mapToDomain(saveStudentModel);
    }

    @Override
    public Student getById(long id) throws NotActiveException, StudentNotFoundException {
        Optional<StudentModel> optionalStudent= mStudentRegistrationRepo.findById(id);

        if (!optionalStudent.isPresent()){

            String emptyStudent= String.format("::: Student with id: %s not found :::", id);
            log.info(emptyStudent);
            throw new StudentNotFoundException(emptyStudent);
        }

        Student studentDomain= StudentMapper.mapToDomain(optionalStudent.get());
        log.info("::: Student retrieved has regNo: [{}] :::", studentDomain.getRegistrationNo());
        return  studentDomain;
    }

    @Override
    public void deleteByID(StudentModel studentModel) {

        mStudentRegistrationRepo.delete(studentModel);
        log.info("::: Student with regNo: [{}] deleted from DB :::", studentModel.getRegistrationNo());

    }

    @Override
    public List<Student> fetchAllStudents() throws StudentNotFoundException {
        List<StudentModel> model= mStudentRegistrationRepo.findAll();

       if (model.isEmpty()){
           log.error("::: No registered student found :::");
           throw new StudentNotFoundException("No registered student(s) found");
       }

        return StudentMapper.mapToListDomain(model);
    }

}
