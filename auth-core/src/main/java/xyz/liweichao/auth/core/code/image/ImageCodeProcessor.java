package xyz.liweichao.auth.core.code.image;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;
import xyz.liweichao.auth.core.code.base.AbstractValidateCodeProcessor;

import javax.imageio.ImageIO;


/**
 * 图片验证码处理器
 *
 * @author 李伟超
 * @email liweichao0102@gmail.com
 * @date 2018/3/1
 */
@Component("imageValidateCodeProcessor")
public class ImageCodeProcessor extends AbstractValidateCodeProcessor<ImageCode> {

    /**
     * 发送图形验证码，将其写到响应中
     */
    @Override
    protected void send(ServletWebRequest request, ImageCode imageCode) throws Exception {
        ImageIO.write(imageCode.getImage(), "JPEG", request.getResponse().getOutputStream());
    }

}
