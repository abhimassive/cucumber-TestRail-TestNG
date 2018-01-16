package com.studentapp.studentinfo;

import com.studentapp.model.StudentClass;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.TestUtils;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentCRUDTest extends TestBase {

    static String firstName = "FirstSmoke" + TestUtils.getRandomValue();
    static String lastName = "LastSmoke" + TestUtils.getRandomValue();
    static String programme = "Computer Science";
    static String email = TestUtils.getRandomValue()
            + "_"
            + "email@gmail.com";


    @Title("This Test will Create a New Student")
    @Test
    public void test001_createStudent() {

        ArrayList courses = new ArrayList();
        courses.add("JAVA");
        courses.add("C++");

        StudentClass student = new StudentClass();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setProgramme(programme);
        student.setCourses(courses);

        SerenityRest.given()
                .contentType(ContentType.JSON)
                .log()
                .all()
                .when()
                .body(student)
                .post()
                .then()
                .log()
                .all()
                .statusCode(201);

    }

    @Title("Verify if the Student was Added")
    @Test
    public void test002_verifyStudent() {
        SerenityRest.given()
                .when()
                .get("/list")
                .then()
                .log()
                .all()
                .statusCode(200);

    }
}
