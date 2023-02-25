# keycloak-remember-me-authenticator
Custom authenticator for remembering the user logging in, even if no "Remember me" flag is set. Useful in combination with identity providers, which don't allow to set the "Remember me" flag.

# Usage

## Keycloak as Docker container
With Keycloak running as Docker container, you'll want to [build your own image](https://www.keycloak.org/operator/customizing-keycloak).  
When you have your basic `Dockerfile` prepared, make the following adjustments:

```
# Install "Remember Me" authenticator
RUN curl -sL https://github.com/Herdo/keycloak-remember-me-authenticator/releases/download/v0.1.2/keycloak-remember-me-authenticator-0.1.2.jar -o /opt/keycloak/providers/keycloak-remember-me-authenticator-0.1.2.jar

# Build image
RUN /opt/keycloak/bin/kc.sh build
```
