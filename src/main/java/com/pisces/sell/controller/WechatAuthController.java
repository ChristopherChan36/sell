package com.pisces.sell.controller;

import com.pisces.sell.enums.ResultEnum;
import com.pisces.sell.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;

/**
 * <p>Title: WechatAuthController </p>
 * <p>Description:  </p>
 *
 * @author christopher
 * @version 1.0
 * @date 2019-3-9 15:46
 */
@Slf4j
@Controller
@RequestMapping("/wechat")
public class WechatAuthController {

    @Autowired
    private WxMpService wxMpService;

    @GetMapping("/auth/test")
    public void auth(@RequestParam("code") String code) {
        log.info("进入微信授权获取code........");
        log.info("获取的code为 {} ", code);

        // 通过code换取网页授权 access_token
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxef4d51981996b443&secret=2db4e1b08f5dac034f229518162a5c4b&code=" + code + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("response={}", response);
    }

    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl) {

        // 1. 配置
        // 2. 调用方法
        String url = "http://pisces.natapp1.cc/sell/wechat/userInfo";
        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO, URLEncoder.encode(returnUrl));
        log.info("【微信网页授权】获取code, result={}", redirectUrl);

        return "redirect:" + redirectUrl;
    }

    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,
                           @RequestParam("state") String returnUrl) {
        log.info("authorize success");
        // 根据获取到的 code 换取 access_token
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            e.printStackTrace();
            log.error("【微信网页授权】error: {}", e);
            throw new SellException(ResultEnum.WECHAT_MP_ACCOUNT_AUTHORIZE_ERROR.getCode(), e.getError().getErrorMsg());
        }
        String openId = wxMpOAuth2AccessToken.getOpenId();

        return "redirect:" + returnUrl + "?openid=" + openId;
    }
}
