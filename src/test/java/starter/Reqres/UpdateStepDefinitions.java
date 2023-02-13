package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import io.restassured.module.jsv.JsonSchemaValidator;
import starter.Utils.ReqresResponses;

import static org.hamcrest.Matchers.equalTo;

import java.io.File;

public class UpdateStepDefinitions {

    @Steps
    ReqresApi reqresApi;

    @Given("Put update user with valid json with id {int}")
    public void putUpdateUserWithValidJson(int id) {
        File jsonReq = new File(Constant.JSON_REQUEST + "/UserReqBody.json");
        reqresApi.putUpdateUser(id, jsonReq);
    }

    @Given("Put update user with invalid json with id {int}")
    public void putUpdateUserWithInvalidJsonWithId(int id) {
        File jsonReq = new File(Constant.JSON_REQUEST + "/InvalidReqUser.json");
        reqresApi.putUpdateUser(id, jsonReq);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUser() {
        SerenityRest.when().put(ReqresApi.PUT_UPDATE_USER);
    }

    @And("Response body name should be {string} and job {string}")
    public void responseBodyNameShouldBeAndJob(String name, String job) {
        SerenityRest.then()
                .body(ReqresResponses.NAME,equalTo(name))
                .body(ReqresResponses.JOB,equalTo(job));
    }

    @And("Validate json schema update user")
    public void validateJsonSchemaUpdateUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/UpdateUserSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

}
