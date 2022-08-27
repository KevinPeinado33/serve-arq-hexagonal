package pe.edu.upeu.patmosapi.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;
import pe.edu.upeu.patmosapi.user.domain.model.User;
import pe.edu.upeu.patmosapi.user.domain.service.UserService;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;

import java.util.HashMap;
import java.util.Map;


@Component
public class InfoAdditionalToken implements TokenEnhancer {

    @Autowired
    private UserService userService;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

        User userFind            = userService.findByUsername(authentication.getName());
        Map<String, Object> info = new HashMap<>();

        info.put("info_adicional", "Hola que tal!: ".concat(authentication.getName()));
        info.put("user_id", userFind.getId());
        info.put("user_name", userFind.getName());

        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);

        return accessToken;

    }

}
