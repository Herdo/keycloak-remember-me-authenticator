package com.herdo.keycloak;

import org.keycloak.authentication.AuthenticationFlowContext;
import org.keycloak.authentication.Authenticator;
import org.keycloak.events.Details;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;

public class RememberMeAuthenticator implements Authenticator {

    @Override
    public void authenticate(AuthenticationFlowContext context) {
        context.getAuthenticationSession().setAuthNote(Details.REMEMBER_ME, "true");
        context.getEvent().detail(Details.REMEMBER_ME, "true"); 
        context.success();
    }

    @Override
    public boolean configuredFor(KeycloakSession session, RealmModel realm, UserModel user) {
        return true;
    }
    
    @Override
    public void setRequiredActions(KeycloakSession session, RealmModel realm, UserModel user) {
        
    }

    @Override
    public boolean requiresUser() {
        return false;
    }

    @Override
    public void action(AuthenticationFlowContext context) {

    }

    @Override
    public void close() {

    }
}