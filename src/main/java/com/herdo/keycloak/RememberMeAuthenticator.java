package com.herdo.keycloak;

import org.keycloak.authentication.AuthenticationFlowContext;
import org.keycloak.authentication.Authenticator;
import org.keycloak.events.Details;

public class RememberMeAuthenticator implements Authenticator {

    @Override
    public void authenticate(AuthenticationFlowContext context) {
        context.getAuthenticationSession().setAuthNote(Details.REMEMBER_ME, "true");
        context.getEvent().detail(Details.REMEMBER_ME, "true"); 
        context.success();
    }
    
    @Override
    public void setRequiredActions(KeycloakSession session, RealmModel realm, UserModel user) {
        
    }
}