package com.edts.tdlib.config;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
//import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Pageable;
import springfox.documentation.builders.AlternateTypeBuilder;
import springfox.documentation.builders.AlternateTypePropertyBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRule;
import springfox.documentation.schema.AlternateTypeRuleConvention;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.host}")
    private String SWAGGER_HOST;

    @Value("${swagger.path}")
    private String SWAGGER_PATH;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .host(SWAGGER_HOST)
                .pathMapping(SWAGGER_PATH)
                .securitySchemes(getSecuritySchemes())
                .securityContexts(getSecurityContexts());
    }

    private List<ApiKey> getSecuritySchemes() {
        return Collections.singletonList(new ApiKey("JWT", "Authorization", "header"));
    }

    private List<SecurityContext> getSecurityContexts() {
        return Collections.singletonList(
                SecurityContext.builder().securityReferences(
                        Collections.singletonList(SecurityReference.builder()
                                .reference("JWT")
                                .scopes(new AuthorizationScope[0])
                                .build()
                        )
                ).build()
        );
    }

    /**
     * Pageable convention.
     *
     * @param resolver the resolver
     * @return the alternate type rule convention
     */
    @Bean
    public AlternateTypeRuleConvention pageableConvention(final TypeResolver resolver) {
        return new AlternateTypeRuleConvention() {

            @Override
            public int getOrder() {
                return Ordered.HIGHEST_PRECEDENCE;
            }

            @Override
            public List<AlternateTypeRule> rules() {
                return Collections.singletonList(new AlternateTypeRule(resolver.resolve(Pageable.class), resolver.resolve(pageableMixin())));
            }
        };
    }

    private Type pageableMixin() {
        return new AlternateTypeBuilder()
                .fullyQualifiedClassName(String.format("%s.generated.%s", Pageable.class.getPackage().getName(),
                        Pageable.class.getSimpleName()))
                .withProperties(Arrays.asList(property(Integer.class, "page"), property(String[].class, "sort"),
                        property(Integer.class, "size"), property(Boolean.class, "unpaged")))
                .build();
    }

    private AlternateTypePropertyBuilder property(Class<?> type, String name) {
        return new AlternateTypePropertyBuilder().withName(name).withType(type).withCanRead(true).withCanWrite(true);
    }
}
