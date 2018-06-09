package xyz.liweichao.auth.rest;

import com.github.hicolors.colors.framework.core.abs.AbstractController;
import com.github.hicolors.colors.framework.lock.core.DistributeLock;
import com.github.hicolors.colors.framework.lock.core.DistributeLockHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import xyz.liweichao.auth.api.IUserApi;
import xyz.liweichao.auth.model.persistence.User;
import xyz.liweichao.auth.service.IUserService;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * UserController
 *
 * @author weichao.li (liweichao0102@gmail.com)
 * @date 2018/6/3
 */
@RestController
public class UserController extends AbstractController<User, Long> implements IUserApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    /**
     * 注入 锁
     */
    @Autowired
    private DistributeLock redisDistributeLock;

    private int i = 0;

    private AtomicInteger error = new AtomicInteger(0);

    public UserController(IUserService service) {
        super(service);
    }

    @GetMapping("/lock")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void testLock() {
        DistributeLockHolder holder = null;
        try {
            //获取锁，此种方式为无自旋，未获得锁立即返回。
            holder = redisDistributeLock.getLock("this is your key");
            //获取锁，此种方式为有自旋，在多长时间内未获得锁返回结果，参数为等待的毫秒数。
            //holder = redisDistributeLock.getLock("this is your key",1*1000);
            if (Objects.isNull(holder)) {
                //未获得锁如何处理
//                doSomethings();
            }
            //获得锁如何处理
//            doSomethings();
        } finally {
            //释放锁
            redisDistributeLock.release(holder);
        }

    }


}
