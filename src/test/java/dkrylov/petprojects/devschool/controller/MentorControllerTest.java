package dkrylov.petprojects.devschool.controller;

import dkrylov.petprojects.devschool.api.MentorApi;
import dkrylov.petprojects.devschool.model.MentorDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource(locations = {"classpath:application-test.properties"})
public class MentorControllerTest {

    @Autowired
    private MentorApi mentorApi;

    @Test
    public void shouldCreateAndFindMentor() {
        MentorDto createdMentor = mentorApi.createMentor(new MentorDto().firstName("Foo"));
        MentorDto foundMentor = mentorApi.getMentor(createdMentor.getId());
        Assert.assertEquals(createdMentor, foundMentor);
    }

    @Test
    public void shouldGetAllMentors() {
        MentorDto createdMentor = mentorApi.createMentor(new MentorDto().firstName("Bar"));
        List<MentorDto> allMentors = mentorApi.getAllMentors();

        Assert.assertTrue(allMentors.contains(createdMentor));
    }
}
