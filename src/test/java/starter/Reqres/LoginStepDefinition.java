package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.hamcrest.CoreMatchers;

import java.io.File;

public class LoginStepDefinition {

    @Steps
    ReqresApi reqresApi;

    @Given("Login user with valid json")
    public void loginUserWithValidJson() {
        File ReqLoginJson = new File(Constant.JSON_REQUEST + "/RequestLogin.json");
        reqresApi.loginUser(ReqLoginJson);
    }

    @When("Send request login user")
    public void sendRequestLoginUser() {
        SerenityRest.when().post(ReqresApi.LOGIN);
    }

    @And("Validate json schema success login user")
    public void validateJsonSchemaSuccessLoginUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/LoginSuccessfulSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Login user with invalid json")
    public void loginUserWithInvalidJson() {
        File ReqJson = new File(Constant.JSON_REQUEST + "/InvalidRequestLogin.json");
        reqresApi.loginUser(ReqJson);
    }

    @And("Response body error should be {string}")
    public void responseBodyErrorShouldBe(String errorMessage) {
        SerenityRest.then()
                .body(Constant.ERROR, CoreMatchers.equalTo(errorMessage));
    }

    @And("Validate json schema failed login user")
    public void validateJsonSchemaFailedLoginUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/LoginUnsuccessfulSchema.json");
        SerenityRest.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
