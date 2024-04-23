package com.dimas.openapi.api;

import com.dimas.openapi.model.ApiDialogMessage;
import com.dimas.openapi.model.ApiDialogUserIdSendPostRequest;
import com.dimas.openapi.model.ApiLoginPost200Response;
import com.dimas.openapi.model.ApiLoginPost500Response;
import com.dimas.openapi.model.ApiLoginPostRequest;
import com.dimas.openapi.model.ApiPost;
import com.dimas.openapi.model.ApiPostCreatePostRequest;
import com.dimas.openapi.model.ApiPostUpdatePutRequest;
import com.dimas.openapi.model.ApiUser;
import com.dimas.openapi.model.ApiUserRegisterPost200Response;
import com.dimas.openapi.model.ApiUserRegisterPostRequest;
import java.math.BigDecimal;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import com.dimas.openapi.api.auth.CompositeAuthenticationProvider;
import com.dimas.openapi.api.auth.AuthenticationPropagationHeadersFactory;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import jakarta.enterprise.context.ApplicationScoped;

import io.quarkiverse.openapi.generator.annotations.GeneratedClass;
import io.quarkiverse.openapi.generator.annotations.GeneratedMethod;
import io.quarkiverse.openapi.generator.annotations.GeneratedParam;

/**
  * OTUS Highload Architect
  * <p>No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)</p>
  */
@Path("")
@RegisterRestClient( configKey="openapi_json")
@GeneratedClass(value="openapi.json", tag = "Default")
@RegisterProvider(CompositeAuthenticationProvider.class)
@RegisterClientHeaders(AuthenticationPropagationHeadersFactory.class)
@ApplicationScoped
public interface DefaultApi {

     /**
     * @param userId 
     */
    @GET
    @Path("/dialog/{user_id}/list")
    @Produces({"application/json"})
    @GeneratedMethod ("")
    public List<ApiDialogMessage> dialogUserIdListGet(
        @GeneratedParam("user_id") @PathParam("user_id") String userId
    );

     /**
     * @param userId 
     * @param apiDialogUserIdSendPostRequest 
     */
    @POST
    @Path("/dialog/{user_id}/send")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @GeneratedMethod ("")
    public jakarta.ws.rs.core.Response dialogUserIdSendPost(
        @GeneratedParam("user_id") @PathParam("user_id") String userId, 
        ApiDialogUserIdSendPostRequest apiDialogUserIdSendPostRequest
    );

     /**
     * @param userId 
     */
    @PUT
    @Path("/friend/delete/{user_id}")
    @Produces({"application/json"})
    @GeneratedMethod ("")
    public jakarta.ws.rs.core.Response friendDeleteUserIdPut(
        @GeneratedParam("user_id") @PathParam("user_id") String userId
    );

     /**
     * @param userId 
     */
    @PUT
    @Path("/friend/set/{user_id}")
    @Produces({"application/json"})
    @GeneratedMethod ("")
    public jakarta.ws.rs.core.Response friendSetUserIdPut(
        @GeneratedParam("user_id") @PathParam("user_id") String userId
    );

     /**
     * Упрощенный процесс аутентификации путем передачи идентификатор пользователя и получения токена для дальнейшего прохождения авторизации
     *
     * @param apiLoginPostRequest 
     */
    @POST
    @Path("/login")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @GeneratedMethod ("")
    public ApiLoginPost200Response loginPost(
        ApiLoginPostRequest apiLoginPostRequest
    );

     /**
     * @param apiPostCreatePostRequest 
     */
    @POST
    @Path("/post/create")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @GeneratedMethod ("")
    public String postCreatePost(
        ApiPostCreatePostRequest apiPostCreatePostRequest
    );

     /**
     * @param id 
     */
    @PUT
    @Path("/post/delete/{id}")
    @Produces({"application/json"})
    @GeneratedMethod ("")
    public jakarta.ws.rs.core.Response postDeleteIdPut(
        @GeneratedParam("id") @PathParam("id") String id
    );

     /**
     * @param offset 
     * @param limit 
     */
    @GET
    @Path("/post/feed")
    @Produces({"application/json"})
    @GeneratedMethod ("")
    public List<ApiPost> postFeedGet(
        @GeneratedParam("offset") @QueryParam("offset") BigDecimal offset, 
        @GeneratedParam("limit") @QueryParam("limit") BigDecimal limit
    );

     /**
     * @param id 
     */
    @GET
    @Path("/post/get/{id}")
    @Produces({"application/json"})
    @GeneratedMethod ("")
    public ApiPost postGetIdGet(
        @GeneratedParam("id") @PathParam("id") String id
    );

     /**
     * @param apiPostUpdatePutRequest 
     */
    @PUT
    @Path("/post/update")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @GeneratedMethod ("")
    public jakarta.ws.rs.core.Response postUpdatePut(
        ApiPostUpdatePutRequest apiPostUpdatePutRequest
    );

     /**
     * Получение анкеты пользователя
     *
     * @param id Идентификатор пользователя
     */
    @GET
    @Path("/user/get/{id}")
    @Produces({"application/json"})
    @GeneratedMethod ("")
    public ApiUser userGetIdGet(
        @GeneratedParam("id") @PathParam("id") String id
    );

     /**
     * Регистрация нового пользователя
     *
     * @param apiUserRegisterPostRequest 
     */
    @POST
    @Path("/user/register")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @GeneratedMethod ("")
    public ApiUserRegisterPost200Response userRegisterPost(
        ApiUserRegisterPostRequest apiUserRegisterPostRequest
    );

     /**
     * Поиск анкет
     *
     * @param firstName Условие поиска по имени
     * @param lastName Условие поиска по фамилии
     */
    @GET
    @Path("/user/search")
    @Produces({"application/json"})
    @GeneratedMethod ("")
    public List<ApiUser> userSearchGet(
        @GeneratedParam("first_name") @QueryParam("first_name") String firstName, 
        @GeneratedParam("last_name") @QueryParam("last_name") String lastName
    );

}