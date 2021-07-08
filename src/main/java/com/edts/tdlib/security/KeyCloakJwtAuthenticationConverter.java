package com.edts.tdlib.security;

import com.edts.tdlib.constant.KeyCloakConstant;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class KeyCloakJwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {
    /**
     * Convert the source object of type {@link Jwt} to target type {@link AbstractAuthenticationToken}.
     *
     * @param jwt the source object to convert, which must be an instance of {@link Jwt} (never null)
     * @return the converted object, which must be an instance of {@link AbstractAuthenticationToken} (potentially null)
     * @throws IllegalArgumentException if the source cannot be converted to the desired target type
     */
    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        Set<SimpleGrantedAuthority> authorities = Stream.ofNullable(jwt.<Map<String, Object>>getClaim("resource_access"))
                .map(resourceAccess -> (Map<String, Object>) resourceAccess.get(KeyCloakConstant.RESOURCE_ID))
                .filter(Objects::nonNull)
                .map(resource -> (Collection<String>) resource.get("roles"))
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());

        return new JwtAuthenticationToken(jwt, authorities);
    }
}
