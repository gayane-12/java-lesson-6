package service;

import model.Student;

public class StudentService {

    public static Student createStudentByConvert(String data) {
        String[] convertedStudentData = data.split(",");
        Student newStudent = new Student();

        newStudent.setFirstName(convertedStudentData[0]);
        newStudent.setLastName(convertedStudentData[1]);
        newStudent.setYear(Integer.parseInt(convertedStudentData[2]));
        newStudent.setGender(convertedStudentData[3].charAt(0));
        newStudent.setMark(Double.parseDouble(convertedStudentData[4]));

        return newStudent;
    }

    public static void printStudentInfo(Student student) {
        System.out.println("First Name: " + student.getFirstName());
        System.out.println("Last Name: " + student.getLastName());
        System.out.println("Gender: " + (student.getGender() == 'm' ? "Male" : "Female"));
        System.out.println("Year: " + student.getYear());
        System.out.println("Mark: " + student.getMark());
    }

    public static void printStudentsInfo(Student[] students) {
        for (Student student :
                students) {
            printStudentInfo(student);
        }
    }

    public static Student[] getStudentsByGender(char gender, Student[] students) {
        int countOfStudents = 0;
        for (Student student :
                students) {
            if (student.getGender() == gender) {
                countOfStudents++;
            }
        }

        Student[] sortedStudents = new Student[countOfStudents];
        int index = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i].getGender() == gender) {
                sortedStudents[index] = students[i];
                index++;
            }
        }

        return sortedStudents;
    }

    public static void printFullNamesOfStudents(Student[] students) {
        for (Student student :
                students) {
            System.out.println(student.getFirstName());
        }
    }

    public static void printAllMaleStudents(Student[] students) {
        Student[] maleStudents = getStudentsByGender('m', students);
        printStudentsInfo(maleStudents);
    }

    public static void printAllFemaleStudentsWithMarkMoreThanHalf(Student[] students) {
        Student[] femaleStudents = getStudentsByGender('f', students);

        for (Student student :
                femaleStudents) {
            if (student.getMark() > 50.4) {
                printStudentInfo(student);
            }
        }
    }

    public static void printStudentWithMinimalMark(Student[] students) {
        Student studentWithMinimalMark = students[0];
        for (Student student :
                students) {
            if (student.getMark() < studentWithMinimalMark.getMark()) {
                studentWithMinimalMark = student;
            }
        }
        printStudentInfo(studentWithMinimalMark);
    }

    public static void printTheBiggestMaleStudent(Student[] students) {
        Student[] maleStudents = getStudentsByGender('m', students);

        Student biggestMaleStudent = maleStudents[0];
        for (Student student :
                maleStudents) {
            if (student.getYear() < biggestMaleStudent.getYear()) {
                biggestMaleStudent = student;
            }
        }

        printStudentInfo(biggestMaleStudent);
    }

    public static void printStudentsSortedByMark(Student[] students) {
        boolean isActive = true;
        int count = 0;
        while (isActive) {
            isActive = false;
            for (int i = 0; i < students.length - 1 - count; i++) {
                if (students[i].getMark() < students[i + 1].getMark()) {
                    Student temp = students[i];
                    students[i] = students[i + 1];
                    students[i + 1] = temp;
                    isActive = true;
                }
            }
            count++;
        }

        printStudentsInfo(students);
    }

    public static void printFemaleStudentsSortedByYear(Student[] students) {
        Student[] femaleStudents = getStudentsByGender('f', students);

        boolean isActive = true;
        int count = 0;
        while (isActive) {
            isActive = false;
            for (int i = 0; i < femaleStudents.length - 1 - count; i++) {
                if (femaleStudents[i].getYear() > femaleStudents[i + 1].getYear()) {
                    Student temp = femaleStudents[i];
                    femaleStudents[i] = femaleStudents[i + 1];
                    femaleStudents[i + 1] = temp;
                    isActive = true;
                }
            }
            count++;
        }
        printStudentsInfo(femaleStudents);
    }

}
