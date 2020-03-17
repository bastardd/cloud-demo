package com.tzl.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * 名称为first-ek-provider的客户端，将使用MyRule/MyPing两个类，
 *
 */
@RibbonClient(name = "first-ek-provider",configuration = MyConfig.class)
public class CloudProviderConfig {
}
