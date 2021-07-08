package com.edts.tdlib.service.uam.auth;

import com.edts.tdlib.bean.uam.LoginRequest;
import com.edts.tdlib.bean.uam.RefreshTokenRequest;
import com.edts.tdlib.model.uam.AccessRightType;
import com.edts.tdlib.model.uam.Role;
import com.edts.tdlib.model.uam.User;
import org.keycloak.representations.idm.UserRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.security.auth.login.LoginException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class AuthService {

    private final Logger log = LoggerFactory.getLogger(AuthService.class);

    @Value("${keycloak.resource}")
    private String clientId;
    @Value("${keycloak.credentials.secret}")
    private String clientSecret;
    @Value("${keycloak.auth-server-url}")
    private String authUrl;
    @Value("${keycloak.realm}")
    private String realm;
    @Value("${application.keycloak.admin-cli.name}")
    private String adminCLi;
    @Value("${application.keycloak.admin-cli.secret}")
    private String adminCliSecret;
    @Value("${application.keycloak.resource.uuid}")
    private String clientUuid;
    @Value(("${application.keycloak.client-scope.uuid}"))
    private String clientScopeUUID;
    private String adminToken = "";

    private HttpHeaders keycloakTokenHeader;
    private final RestTemplate httpClient;

    public AuthService(RestTemplate httpClient) {
        this.httpClient = httpClient;
    }

    public boolean createRole(String roleName) throws URISyntaxException {
        URI adminAPIUrl = new URI(authUrl + "/admin/realms/" + realm + "/clients/" + clientId + "/roles");
        HttpHeaders adminAPIHeaders = getAdminAPIHeaders();
        Map<String, Object> createRoleBody = new HashMap<>();
        createRoleBody.put("name", roleName);
        HttpEntity<Object> postReq = new HttpEntity<>(createRoleBody, adminAPIHeaders);
        ResponseEntity<Object> resp = httpClient.exchange(adminAPIUrl, HttpMethod.POST, postReq, Object.class);
        if (resp.getStatusCode() == HttpStatus.CREATED) {
            return mapRoleToScope(roleName, adminAPIHeaders);
        }
        return false;
    }

    public ResponseEntity<Object> login(LoginRequest request) throws URISyntaxException, LoginException {
        MultiValueMap<String, String> mapForm = new LinkedMultiValueMap<>();
        mapForm.add("grant_type", "password");
        mapForm.add("client_id", clientId);
        mapForm.add("username", request.getUsername());
        mapForm.add("password", request.getPassword());
        mapForm.add("scope", "openid permissions");
        return getObjectResponseEntity(mapForm);
    }

    public void createOrUpdate(String method, User request, String secret) throws URISyntaxException {
        URI adminAPIUrl;
        Map<String, Object> createUserBody = new HashMap<>();
        HttpMethod httpMethod;
        switch (method) {
            case "create":
                adminAPIUrl = new URI(authUrl + "/admin/realms/" + realm + "/users");
                httpMethod = HttpMethod.POST;
                break;
            case "update":
                String userId = getUserIdByUsername(request.getUsername());
                createUserBody.put("id", userId);
                adminAPIUrl = new URI(authUrl + "/admin/realms/" + realm + "/users/" + userId);
                httpMethod = HttpMethod.PUT;
                break;
            default:
                return;
        }
        List<String> permissions = getPermissions(Objects.requireNonNullElse(request.getRole(), new Role()));

        Map<String, Object> attr = new HashMap<>();
        attr.put("telegramPhone","9898989898");
        attr.put("permissions", permissions);

        createUserBody.put("username", request.getUsername());
        createUserBody.put("email", request.getEmail());
        createUserBody.put("enabled", true);
//        createUserBody.put("clientRoles",Collections.singletonMap(clientId,Collections.singletonList(request.getRole().getName())));
        //createUserBody.put("attributes", Collections.singletonMap("permissions", permissions));
        createUserBody.put("attributes", attr);

        if (!secret.isEmpty() && !secret.equals("********")) {
            createUserBody.put("credentials", Collections.singletonList(new AuthCredentials("password", secret, false)));
        }

        HttpEntity<Object> postReq = new HttpEntity<>(createUserBody, getAdminAPIHeaders());
        try {
            ResponseEntity<Object> resp = httpClient.exchange(adminAPIUrl, httpMethod, postReq, Object.class);
            log.info(resp.toString());
        } catch (HttpClientErrorException ex) {
//            TODO - exception handling
        }
    }

    public ResponseEntity<Object> refresh(RefreshTokenRequest request) throws URISyntaxException, LoginException {
        MultiValueMap<String, String> mapForm = new LinkedMultiValueMap<>();
        mapForm.add("grant_type", "refresh_token");
        mapForm.add("client_id", clientId);
        mapForm.add("refresh_token", request.getRefresh_token());
        return getObjectResponseEntity(mapForm);
    }

    public void delete(String username) throws URISyntaxException {
        Map<String, Object> createUserBody = new HashMap<>();
        String userId = getUserIdByUsername(username);
        createUserBody.put("id", userId);
        createUserBody.put("enabled", false);
        URI adminAPIUrl = new URI(authUrl + "/admin/realms/" + realm + "/users/" + userId);
        HttpEntity<Object> postReq = new HttpEntity<>(createUserBody, getAdminAPIHeaders());
        httpClient.exchange(adminAPIUrl, HttpMethod.PUT, postReq, Object.class);
    }

    private HttpHeaders getAdminAPIHeaders() throws URISyntaxException {
        /*if (this.adminToken.isEmpty()) {
            this.adminToken = initAdminToken();
        }*/
        String token = initAdminToken();
        HttpHeaders adminAPIHeaders = new HttpHeaders();
        adminAPIHeaders.setContentType(MediaType.APPLICATION_JSON);
        adminAPIHeaders.setBearerAuth(Objects.requireNonNull(token));
        return adminAPIHeaders;
    }

    private HttpHeaders getKeycloakTokenHeader() {
        if (this.keycloakTokenHeader == null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            headers.setBasicAuth(clientId, clientSecret);
            this.keycloakTokenHeader = headers;
        }
        return this.keycloakTokenHeader;
    }

    private boolean mapRoleToScope(String roleName, HttpHeaders adminHeaders) throws URISyntaxException {
        URI adminAPIUrl = new URI(authUrl + "/admin/realms/" + realm + "/client-scopes/" + clientScopeUUID + "/scope-mappings/clients/" + clientUuid);
        Map<String, Object> mapRoleToScopeBody = new HashMap<>();
        mapRoleToScopeBody.put("name", roleName);
        HttpEntity<Object> postReq = new HttpEntity<>(mapRoleToScopeBody, adminHeaders);
        ResponseEntity<Object> resp = httpClient.exchange(adminAPIUrl, HttpMethod.POST, postReq, Object.class);
        return resp.getStatusCode() == HttpStatus.NO_CONTENT;
    }

    private ResponseEntity<Object> getObjectResponseEntity(MultiValueMap<String, String> mapForm) throws URISyntaxException, LoginException {
        HttpEntity<MultiValueMap<String, String>> req = new HttpEntity<>(mapForm, getKeycloakTokenHeader());
        URI url = new URI(authUrl + "/realms/" + realm + "/protocol/openid-connect/token");
        try {
            return httpClient.exchange(url, HttpMethod.POST, req, Object.class);
        } catch (HttpClientErrorException ex) {
            throw new LoginException("authentication.invalid");
        }
    }

    private String initAdminToken() throws URISyntaxException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBasicAuth(adminCLi, adminCliSecret);

        MultiValueMap<String, String> mapForm = new LinkedMultiValueMap<>();
        mapForm.add("grant_type", "client_credentials");
        mapForm.add("client_id", adminCLi);
        mapForm.add("client_secret", adminCliSecret);

        HttpEntity<MultiValueMap<String, String>> req = new HttpEntity<>(mapForm, headers);
        URI url = new URI(authUrl + "/realms/" + realm + "/protocol/openid-connect/token");

        ResponseEntity<AuthResponseBean> res = httpClient.exchange(url, HttpMethod.POST, req, AuthResponseBean.class);
        return Objects.requireNonNull(res.getBody()).getAccess_token();
    }

    private String getUserIdByUsername(String username) throws URISyntaxException, RestClientException {
        URI adminAPIUrl = new URI(authUrl + "/admin/realms/" + realm + "/users?username=" + username);
        ResponseEntity<UserRepresentation[]> response = httpClient.exchange(adminAPIUrl, HttpMethod.GET, new HttpEntity<>(getAdminAPIHeaders()), UserRepresentation[].class);
        List<UserRepresentation> userList = Arrays.asList(Objects.requireNonNull(response.getBody()));
        AtomicReference<String> userid = new AtomicReference<>("");
        userList.stream()
                .filter(
                        userRepresentation -> userRepresentation.getUsername().equals(username)
                )
                .findFirst()
                .ifPresent(userRepresentation -> userid.set(userRepresentation.getId()));

        return userid.get();
    }

    private List<String> getPermissions(Role roles) {
        return roles
                .getAccessRights()
                .stream()
                .map(accessRight -> {
                    AccessRightType type = accessRight.getAccessRightType();
                    String permissionLabel = type.getAccessRightGroup().getCode() + "_" + type.getCode();
                    List<String> permissionAccess = new ArrayList<>();
                    if (accessRight.isCanRead()) permissionAccess.add(permissionLabel + "_read");
                    if (accessRight.isCanCreate()) permissionAccess.add(permissionLabel + "_create");
                    if (accessRight.isCanUpdate()) permissionAccess.add(permissionLabel + "_update");
                    if (accessRight.isCanDelete()) permissionAccess.add(permissionLabel + "_delete");
                    return permissionAccess;
                }).collect(Collectors.toList()).stream().flatMap(Collection::stream).collect(Collectors.toList());
    }
}
