package main;

import model.Student;
import service.FileService;
import service.StudentService;

public class Test {
    public static void main(String[] args) {

        String[] studentsData = FileService.readLines("files\\students");
        Student[] createdStudents = new Student[3];
        for (int i = 0; i < studentsData.length; i++) {
            createdStudents[i] = StudentService.createStudentByConvert(studentsData[i]);
        }

//        StudentService.printFullNamesOfStudents(createdStudents);
//        StudentService.printAllMaleStudents(createdStudents);
//        StudentService.printAllFemaleStudentsWithMarkMoreThanHalf(createdStudents);
//        StudentService.printStudentWithMinimalMark(createdStudents);
//        StudentService.printTheBiggestMaleStudent(createdStudents);
//        StudentService.printStudentsSortedByMark(createdStudents);
        StudentService.printFemaleStudentsSortedByYear(createdStudents);


    }
}
