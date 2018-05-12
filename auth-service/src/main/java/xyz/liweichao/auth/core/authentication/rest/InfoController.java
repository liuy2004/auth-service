package xyz.liweichao.auth.core.authentication.rest;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import xyz.liweichao.auth.core.properties.SecurityConstants;

import javax.annotation.security.RolesAllowed;

/**
 * note
 *
 * @author 李伟超
 * @date 2018/03/17
 */
@RestController
@RequestMapping("/")
public class InfoController {

    @GetMapping(SecurityConstants.DEFAULT_UNAUTHORIZED_URL)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Object me() {
        return "请重新登录！";
    }

    @GetMapping("me")
    @RolesAllowed({"USER", "ADMIN"})
    public Object me(@AuthenticationPrincipal UserDetails user) {
        return user;
    }

    @GetMapping("admin")
    @RolesAllowed({"ADMIN"})
    public Object admin(@AuthenticationPrincipal UserDetails user) {
        return user;
    }

}