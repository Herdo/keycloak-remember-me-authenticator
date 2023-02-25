# keycloak-remember-me-authenticator
Custom authenticator for remembering the user logging in, even if no "Remember me" flag is set. Useful in combination with identity providers, which don't allow to set the "Remember me" flag.

# Usage

## Keycloak as Docker container

1. With Keycloak running as Docker container, you'll want to [build your own image](https://www.keycloak.org/operator/customizing-keycloak).  
2. When you have your basic `Dockerfile` prepared, make the following adjustments:

```
# Install "Remember Me" authenticator
RUN curl -sL https://github.com/Herdo/keycloak-remember-me-authenticator/releases/download/v0.1.2/keycloak-remember-me-authenticator-0.1.2.jar \
    -o /opt/keycloak/providers/keycloak-remember-me-authenticator-0.1.2.jar

# Build image
RUN /opt/keycloak/bin/kc.sh build
```
3. Start your custom Keycloak image as a new container.

## Configuration for IdPs
1. Open your Keycloaks admin interface and login.
2. Navigate to `Authentication`.
3. Create a new `Basic flow` called `post idp login remember me`.
4. Add `Remember Me Authenticator` as `Required` step.
5. Navigate to `Identity providers` and select your provider you want to enable the "Remember Me" function for.
6. For the `Post login flow` select `post idp login remember me` and save.
