package org.example.myapp.Vo;

import lombok.Data;
import org.example.myapp.bean.Student;

import java.util.Objects;
import java.util.StringJoiner;

@Data
public class StudentVo {

    private int id;

    private String name;

    public StudentVo(Student student) {
        this.id = student.getId();
        this.name = student.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentVo studentVo = (StudentVo) o;
        return id == studentVo.id && Objects.equals(name, studentVo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", getClass().getSimpleName() + "[", "]")
                .add("id=" + getId())
                .add("name='" + getName() + "'")
                .toString();
    }
}
