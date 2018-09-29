package adhoc.controllers;

import adhoc.models.Abogade;
import adhoc.repositories.AbogadesRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AbogadesController.class)
public class AbogadeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AbogadesRepository repository;

    @Test
    public void xXXX() throws Exception {
        List<Abogade> abogades = new ArrayList<>();
        Abogade abogade = new Abogade("foo", "bar");
        abogades.add(abogade);

        when(repository.findAll()).thenReturn(abogades);

        this.mockMvc.perform(get("/abogades/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[{\"firstName\":\"foo\",\"lastName\":\"bar\"}]"));
    }

    @Test
    public void xxxX() throws Exception {
        when(repository.findById(1L)).thenReturn(Optional.of(new Abogade("foo", "bar")));

        this.mockMvc.perform(get("/customers/get?id=1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"firstName\":\"foo\",\"lastName\":\"bar\"}"));
    }
}