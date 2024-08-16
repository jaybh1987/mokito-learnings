package com.practise.jaypractise.models.mokitoBook.austroinspace;

import java.util.List;

public class FakeGateway implements Gateway<AstroResponse> {

    @Override
    public AstroResponse getResponse() {
        return new AstroResponse(
                7, "Success",
                List.of(
                        new Assignment("jay", "ssi"),
                        new Assignment("pinak", "ssi"),
                        new Assignment("vihan", "iis"),
                        new Assignment("jay", "iis")
                )
        );
    }
}
