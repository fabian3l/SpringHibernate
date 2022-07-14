package pl.coderslab.student;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Table(name = Student.TABLE_NAME)
@NoArgsConstructor
@Data
public class Student {
    public static final String TABLE_NAME = "student";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    String firstName;
    String lastName;
    String gender;
    String country;
    String notes;
    boolean mailingList;
    List<String> programmingSkills;
    List<String> hobbies;
}
