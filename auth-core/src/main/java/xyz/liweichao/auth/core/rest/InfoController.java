package xyz.liweichao.auth.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import xyz.liweichao.auth.core.properties.SecurityConstants;
import xyz.liweichao.auth.core.service.IColorsUserService;

import java.util.HashMap;
import java.util.Map;

/**
 * note
 *
 * @author 李伟超
 * @date 2018/03/17
 */
@RestController
@RequestMapping
public class InfoController {

    @Autowired
    private IColorsUserService service;

    @GetMapping(SecurityConstants.DEFAULT_UNAUTHORIZED_URL)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Object require() {
        Map<String,Object> map = new HashMap<>();
        map.put("message","请重新登录！");
        return map;
    }

    @GetMapping("/user-info")
    public Object userInfo(@AuthenticationPrincipal UserDetails user) {
        return service.loadUserByUniqueKey(user.getUsername());
    }

}