import com.example.SpringLibrary.model.dto.request.EmployerRequest;
//import com.example.SpringLibrary.model.dto.response.EmployerResponse;
//import com.example.SpringLibrary.service.impl.EmployerImplService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.List;
//
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.when;
//import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//@WebMvcTest(controllers = EmployerControllerTest.class)
//@WithMockUser(username = "user",password = "pass")
//public class EmployerControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @Autowired
//    private ObjectMapper objectMapper;
//    @MockBean(name = "EmployerImplService")
//    private EmployerImplService employerService;
//    @Test
//    private void testGetAll_Success() throws Exception {
//        EmployerResponse employerResponse=new EmployerResponse();
//        employerResponse.setEmployerId(3L);
//        List<EmployerResponse> employerResponseList = List.of(employerResponse);
//
//        EmployerResponse.builder().employerId(2L).name("John")
//                .name("Doe").name("johndoe@example.com")
//                .status(1).build();
//
//
//        //given
//
//        //when
//        when(employerService.getAllEmployers()).thenReturn(employerResponseList);
//        ///then
//        mockMvc.perform(get("/employer/no-auth")
//                )
//                .andExpect(status().isOk());
//    }
//    @Test
//    private void testAddEmployer_Success() throws Exception {
//        EmployerRequest employerRequest=EmployerRequest.builder() .name("John")
//                .name("Doe").email("johndoe@example.com")
//                .status(1).build();
//        doNothing().when(employerService).addEmployer(employerRequest);
//        ///then
//        mockMvc.perform(post("/employer")
//                        .with(csrf())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .contentType(objectMapper.writeValueAsString(employerRequest))
//                )
//                .andExpect(status().isOk());
//    }
//}