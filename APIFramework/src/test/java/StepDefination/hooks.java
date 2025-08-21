package StepDefination;

import io.cucumber.java.Before;

import java.io.IOException;

public class hooks {
    @Before("@deletePlace")
    public void beforeScenario() throws IOException {
        stepDefenations std = new stepDefenations();
        std.add_place_payload("roushan","english","patna Bihar");
        std.user_calls_with_post_http_request("AddPlaceAPI","POST");

        std.varify_place_id_created_mapped_to_using("roushan", "GetPlaceAPI");
    }
}
