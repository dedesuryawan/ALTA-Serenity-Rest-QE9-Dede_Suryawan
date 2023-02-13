package starter.Reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Utils.ReqresResponses;

import java.io.File;



import static org.hamcrest.Matchers.equalTo;

public class ReqresStepDefinitions {
    @Steps
    ReqresApi reqresApi;

    @Given("Get list users with valid parameter page {int}")
    public void getListUsersWithValidParameterPage(int page) {
        reqresApi.setGetListUsers(page);
    }

    @When("Send users request get list users")
    public void sendUsersRequestGetListUsers() {
        SerenityRest.when().get(ReqresApi.GET_LIST_USERS);
    }

    @Then("Status code should be {int} ok")
    public void statusCodeShouldBeOk(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Respone body page should be {int}")
    public void responeBodyPageShouldBe(int page) {
        SerenityRest.then().body(ReqresResponses.PAGE, equalTo(page));
    }

    @And("Validate get list user json schema")
    public void validateGetListUserJsonSchema() {
        File jsonSchemaGetListUser = new File(Constant.JSON_SCHEMA + "/ListUserJsonSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchemaGetListUser));
    }

    @Given("Get list user with invalid page {string}")
    public void getListUserWithInvalidPage(String page) {
        reqresApi.getListUsers(page);
    }
    @When("Send request get list user")
    public void sendRequestGetListUser() {

    }


    //Scenario 2 Create the file with valid json
//    @Given("Create new user with valid json")
//    public void createNewUserWithValidJson() {
//        File jsonReq = new File(ReqresApi.DIR+"/src/test/resources/JSON/ReqBody/UserReqBody.json");
//        reqresApi.postCreateUsers(jsonReq);
//    }
//
//    @When("Send request post create user")
//    public void sendRequestPostCreateUser() {
//        SerenityRest.when().post(ReqresApi.POST_CREATE_USER);
//    }
//
//    @Then("Status code should be {int} Created")
//    public void statusCodeShouldBeCreated(int created) {
//        SerenityRest.then().statusCode(created);
//    }
//
//    @And("Respone body name should be {string} and job is {string}")
//    public void responeBodyNameShouldBeAndJobIs(String name, String job) {
//        SerenityRest.then()
//                .body("name",equalTo(name))
//                .body("job",equalTo(job));
//    }


    // Scenario 3
//    @Given("Put update user with valid json with id {int}")
//    public void putUpdateUserWithValidJsonWithId(int id) {
//        File jsonReq = new File(ReqresApi.DIR+"/src/test/resources/JSON/ReqBody/UserReqBody.json");
//        reqresApi.postCreateUsers(jsonReq, id);
//
//    }
//
//    @When("Send request put update user")
//    public void sendRequestPutUpdateUser() {
//        SerenityRest.when().put(ReqresApi.PUT_UPDATE_USER);
//    }
//
//    @Then("Should return status code {int}")
//    public void shouldReturnStatusCode(int arg0) {
//    }
//
//    @And("Response body name should be {string} and job {string}")
//    public void responseBodyNameShouldBeAndJob(String arg0, String arg1) {
//    }

}
