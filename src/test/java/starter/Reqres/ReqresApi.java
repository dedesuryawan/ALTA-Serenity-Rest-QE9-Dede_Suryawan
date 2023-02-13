package starter.Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Reqres.Constant;

import java.io.File;

public class ReqresApi {

    public static String GET_LIST_USERS = Constant.BASE_URL+"/api/users?page={page}";
    public static String POST_CREATE_USER = Constant.BASE_URL+"/api/users";
    public static String PUT_UPDATE_USER = Constant.BASE_URL + "/api/user/{id}";
    public static String DELETE_USER = Constant.BASE_URL + "/api/user/{id}";
    public static String LOGIN = Constant.BASE_URL + "/api/login";
    public static String REGISTER = Constant.BASE_URL + "/api/register";


    //Get List User
    @Step("Get List User")
    public void setGetListUsers(int page){

        SerenityRest.given()
                .pathParam("page", page)
                .get(GET_LIST_USERS);

    }

    //get List invalid users with string
    @Step("Get list user")
    public void getListUsers(String page) {
        SerenityRest.given()
                .pathParam("page", page)
                .get(GET_LIST_USERS);
    }

    //Create New User
    @Step("Post create new users")
    public void postCreateUsers(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Update User By ID
    @Step("Put update user by ID")
    public void putUpdateUser (int id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    //Delete user
    @Step("Delete user")
    public void deleteUser(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }

    @Step("Login user")
    public void loginUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Register user")
    public void registerUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }


}
