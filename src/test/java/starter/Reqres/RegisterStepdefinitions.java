package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.io.File;

public class RegisterStepdefinitions {

    @Steps
    ReqresApi reqresApi;

    @Given("Register user with valid json")
    public void registerUserWithValidJson() {
        File json = new File(Constant.JSON_REQUEST + "/RequestRegister.json");
        reqresApi.registerUser(json);
    }

    @When("Send request register user")
    public void sendRequestRegisterUser() {
        SerenityRest.when().post(ReqresApi.REGISTER);
    }

    @And("Validate json schema success register user")
    public void validateJsonSchemaSuccessRegisterUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/RegisterSuccessfulSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Register user with invalid json")
    public void registerUserWithInvalidJson() {
        File json = new File(Constant.JSON_REQUEST + "/InvalidRequestRegister.json");
        reqresApi.registerUser(json);
    }

    @And("Validate json schema failed register user")
    public void validateJsonSchemaFailedRegisterUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/RegisterUnsuccessfulSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
