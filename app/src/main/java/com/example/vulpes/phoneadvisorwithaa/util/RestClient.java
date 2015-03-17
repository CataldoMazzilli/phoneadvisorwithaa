package com.example.vulpes.phoneadvisorwithaa.util;

import com.example.vulpes.phoneadvisorwithaa.models.BrandInfo;

import org.androidannotations.annotations.rest.Get;
import org.androidannotations.annotations.rest.Rest;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * Created by vulpes on 21/01/15.
 */
@Rest(
        rootUrl = "http://www.vulpes.altervista.org",
        converters = {MappingJackson2HttpMessageConverter.class}
)
public interface RestClient {
    @Get("/samsung.json")
    BrandInfo getSamsungBrandInfo();

    @Get("/sony.json")
    BrandInfo getSonyBrandInfo();

    @Get("/lg.json")
    BrandInfo getLgBrandInfo();

    @Get("/apple.json")
    BrandInfo getAppleBrandInfo();

    @Get("/nokia.json")
    BrandInfo getNokiaBrandInfo();

    @Get("/huawei.json")
    BrandInfo getHuaweiBrandInfo();

    @Get("/asus.json")
    BrandInfo getAsusBrandInfo();

    @Get("/htc.json")
    BrandInfo getHtcBrandInfo();

    @Get("/motorola.json")
    BrandInfo getMotorolaBrandInfo();
}