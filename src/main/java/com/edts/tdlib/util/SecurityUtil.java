package com.edts.tdlib.util;

import com.edts.tdlib.constant.RoleConstant;
import com.edts.tdlib.constant.JwtConstant;
import com.edts.tdlib.constant.ScopeConstant;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author rickychandra
 * @created 03/11/2020
 */

/**
 * Collections of security utility functions.
 */
public final class SecurityUtil {


    /**
     * Get username from current user.
     *
     * @return username
     */
    public static Optional<String> getEmail() {
        return getJwt()
                .map(jwt -> jwt.getClaimAsString(JwtConstant.EMAIL));
    }

    /**
     * Check if mobile user.
     *
     * @return is user mobile
     */
    public static boolean isMobile() {
        return getJwt()
                .map(jwt -> jwt.getClaimAsString(JwtConstant.SCOPE))
                .stream().anyMatch(s -> s.contains(ScopeConstant.MOBILE));
    }

    /**
     * Get user permissions
     *
     * @return Optional of list permissions
     */
    public static Optional<List<String>> getListPermissions() {
        return getJwt()
                .map(jwt -> jwt.getClaimAsStringList(JwtConstant.PERMISSIONS));
    }

    /**
     * Get user mobile id
     *
     * @return Optional of user mobile id
     */
    public static Optional<String> getUserMobileId() {
        return getJwt()
                .map(jwt -> jwt.getClaimAsString(JwtConstant.CUSTOMER_ID));
    }

    /**
     * Get username from current user.
     *
     * @return username
     */
    public static Optional<String> getUsername() {
        return getJwt()
                .map(jwt -> jwt.getClaimAsString(JwtConstant.USERNAME));
    }

    /**
     * @return true if jwt token is anonymous role
     */
    public static boolean isAnonymous() {
        return (getRoles().contains(RoleConstant.ANONYMOUS));
    }

    /**
     * Get roles from current user.
     *
     * @return roles
     */
    public static List<String> getRoles() {
        return Stream.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(Authentication::getAuthorities)
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
    }

    /**
     * @return Optional of JWT token
     */
    public static Optional<Jwt> getJwt() {
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .filter(JwtAuthenticationToken.class::isInstance)
                .map(JwtAuthenticationToken.class::cast)
                .map(JwtAuthenticationToken::getToken);
    }

    public static Optional<Integer> getAccountId() {
        Optional<String> id =  getJwt()
                .map(jwt -> jwt.getClaimAsString(JwtConstant.USERNAME));

        Optional<Integer> s = Optional.of(Integer.parseInt(id.get()));

        return s;

    }
}
