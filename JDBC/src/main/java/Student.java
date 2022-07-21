import java.util.Objects;

public class Student {
    private String name;
    private int schoolId;

    public Student(String name, int schoolId) {
        this.name = name;
        this.schoolId = schoolId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + "\'" +
                ", school='" + schoolId + "\'" +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSchool(int schoolId) {
        this.schoolId = schoolId;
    }
}
