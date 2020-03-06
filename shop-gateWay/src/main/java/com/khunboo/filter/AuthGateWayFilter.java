package com.khunboo.filter;

import com.alibaba.fastjson.JSON;
import com.khunboo.Result;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class AuthGateWayFilter implements GatewayFilter, Ordered {

    //定义常量
    protected static final String TOKEN = "token";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain){

        ServerHttpRequest exRequest = exchange.getRequest();
        String token = getToken(exRequest);
        //todo暂时默认都可以访问，后期需要设置访问权限
        //修改请求实例 构建新的请求实例
        ServerHttpRequest request = exchange.getRequest().mutate().header(TOKEN, token).build();

        ServerHttpResponse response = exchange.getResponse();

        //构建新的ServerWebExchange实例，通过mutate()方法
        ServerWebExchange build = exchange.mutate().request(request).response(response).build();
        return chain.filter(build);
    }

    @Override
    public int getOrder() {
        return -1;
    }

    /**
     * 获取token方法
     * 1：优先从header中取
     * 2：其次从cookies中取
     * 3：再从请求参数中去
     */
    public String getToken(ServerHttpRequest request){

        HttpHeaders httpHeaders = request.getHeaders();
        List<String> list = httpHeaders.get(TOKEN);
        if(!CollectionUtils.isEmpty(list)){
            return list.get(0);
        }

        HttpCookie httpCookie = request.getCookies().getFirst(TOKEN);
        if(httpCookie != null) {
            return httpCookie.getValue();
        }

        String token = request.getQueryParams().getFirst(TOKEN);
        if(!StringUtils.isEmpty(token)){
            return token;
        }

        return "";
    }

    /**
     * 返回失败
     *
     * @param response
     * @return
     */
    private Mono<Void> authFail(ServerHttpResponse response, Result result) {
        byte[] datas = JSON.toJSONBytes(result);
        DataBuffer buffer = response.bufferFactory().wrap(datas);
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        return response.writeWith(Mono.just(buffer));
    }
}
