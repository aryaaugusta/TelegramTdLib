package com.edts.tdlib.security;

import com.edts.tdlib.util.SecurityUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @author rickychandra
 * @created 03/11/2020
 */

/**
 * All authorization related logic for {@link org.springframework.security.access.prepost.PreAuthorize}.
 */
@Component("auth")
public class Authorization {

    /**
     * Check if token is mobile
     *
     * @return true if has mobile scoped
     */
    public boolean hasPermission(String permission) {
        return SecurityUtil.getListPermissions()
                .map(list -> list.contains(StringUtils.lowerCase(permission)))
                .orElse(false);
    }

    /**
     * Check if token is mobile
     *
     * @return true if has mobile scoped
     */
    public boolean isMobile() {
        return SecurityUtil.isMobile();
    }
}
