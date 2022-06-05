package com.example.demo.config;

import com.example.demo.service.UserService;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;

public class SchroedingerMethodSecurityExpressionHandler
        extends DefaultMethodSecurityExpressionHandler {

    private final UserService userService;

    public SchroedingerMethodSecurityExpressionHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected MethodSecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication,
                                                                              MethodInvocation invocation) {
        UserSecurityExpressionRoot root = new UserSecurityExpressionRoot(authentication);


        root.setParentService(userService);
        root.setPermissionEvaluator(getPermissionEvaluator());
        root.setTrustResolver(new AuthenticationTrustResolverImpl());
        root.setRoleHierarchy(getRoleHierarchy());

        return root;
    }
}
