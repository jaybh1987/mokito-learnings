package com.practise.jaypractise.models.austroinspace;

import com.practise.jaypractise.models.mokitoBook.austroinspace.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AstroServiceTest {

    private final AstroResponse mockAstroResponse =
            new AstroResponse(7, "Success", Arrays.asList(
                    new Assignment("John Sheridan", "Babylon 5"),
                    new Assignment("Susan Ivanova", "Babylon 5"),
                    new Assignment("Beckett Mariner", "USS Cerritos"),
                    new Assignment("Brad Boimler", "USS Cerritos"),
                    new Assignment("Sam Rutherford", "USS Cerritos"),
                    new Assignment("D'Vana Tendi", "USS Cerritos"),
                    new Assignment("Ellen Ripley", "Nostromo")
            ));

    @Mock
    private Gateway<AstroResponse> gateway; //mockito doing job of creating mock for us

    @InjectMocks
    private AstroService astroService; // mockito doing job for injecting the mock into the service for us. we are not doing it now.




//    @Test
//    void testAstroData_usingInjectedMockGateway() {
//
//        // Mock gateway created and injected into astroservice using @mock and @injectMock annotations
//
//        //set the expectations on the mock
//        when(gateway.getResponse())
//                .thenReturn(mockAstroResponse);
//        // call the method under test
//        Map<String, Long> astroData = astroService.getAstroData();
//
//        //check the results from the method under the test
//
//        verify(gateway).getResponse();
//
//    }

    @Test
    void testAstroData_usingOwnMockGateway() {
        // create service using mock gateway
        AstroService service = new AstroService(new FakeGateway());

        // Call the method under test
        Map<String, Long> astroData =  service.getAstroData();

        //check the results from the method under test
        astroData.forEach(
                (craft, number) -> {
                    System.out.println(number + "astronts aboard " + craft);
                    assertNotNull(craft);
                    assertNotNull(number);
                }
        );

    }

}