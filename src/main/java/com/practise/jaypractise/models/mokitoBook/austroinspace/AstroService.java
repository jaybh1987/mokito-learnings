package com.practise.jaypractise.models.mokitoBook.austroinspace;

import java.util.Map;
import java.util.stream.Collectors;

// converts the records returned by gateway into a java Map.
// uses gateway to access the remote web service.
// gateway retrive remote data and turns it into either a success instance containing AstroResponse
// or failure instance containing any thrown execption if not.
public class AstroService {

    private final Gateway<AstroResponse> gateway;

    public AstroService(Gateway<AstroResponse> gateway) {
        this.gateway = gateway;
    }

    public Map<String, Long> getAstroData() {
        AstroResponse response = gateway.getResponse();
        return groupByCraft(response);
    }

    private Map<String, Long> groupByCraft(AstroResponse data) {
        return data.getPeople().stream()
                .collect(Collectors.groupingBy(Assignment::getCraft, Collectors.counting()));
    }
}

