package com.twitter.tests;

import java.util.logging.Logger;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.filters.RequestFilter;
import net.lightbody.bmp.filters.ResponseFilter;
import net.lightbody.bmp.util.HttpMessageContents;
import net.lightbody.bmp.util.HttpMessageInfo;

import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.twitter.utils.DriverProvider;

import io.netty.handler.codec.http.HttpRequest;


public class TestBase {
  public final static Logger LOG = Logger.getLogger(TestBase.class.getName());
  WebDriver driver = DriverProvider.getDriver();
  //BrowserMobProxy proxy = DriverProvider.getProxy();
  //private ClientAndServer mockServer;

  protected void startMockServer() {
    //mockServer = startClientAndServer(1080);

  }

  @AfterClass(alwaysRun = true)
  protected void close() {
    DriverProvider.CloseAllOtherHandles();
  }

  protected void addRequestResponseFilters(BrowserMobProxy proxy) {
    // request filter
//    proxy.addRequestFilter(new RequestFilter() {
//      @Override
//      public HttpResponse filterRequest(HttpRequest request, HttpMessageContents contents,
//                                        HttpMessageInfo messageInfo) {
//        if (request.getUri().contains("promoted_content/log.json")) {
//          System.out.println("Intercepting request for log.json :" + messageInfo.getUrl());
//          System.out.println("Intercepting request headers for log.json :" + messageInfo.getOriginalRequest().headers().toString());
//        }
//        if (request.getUri().contains("timeline/home.json")) {
//          System.out.println("Intercepting request for Home.json :" + contents.getTextContents());
//        }
//        return null;
//      }
//    });
//    // response filter
//    proxy.addResponseFilter(new ResponseFilter() {
//      @Override
//      public void filterResponse(HttpResponse response, HttpMessageContents contents,
//                                 HttpMessageInfo messageInfo) {
//        System.out.println("intercepting response for url :" + messageInfo.getOriginalUrl());
//      }
//    });

  }

  @AfterSuite
  protected void shutdown() {
    ///mockServer.stop();
    if (driver != null) {
      driver.close();
      driver.quit();
    }
  }
}

