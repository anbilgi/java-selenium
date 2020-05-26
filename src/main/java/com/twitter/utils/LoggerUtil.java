package com.twitter.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import com.google.gson.Gson;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import com.twitter.pojos.PromotedLog;


public class LoggerUtil {
  public final static Logger LOG = Logger.getLogger(LoggerUtil.class.getName());

  public static void getLogs(WebDriver driver) {
    LOG.info("Available logs : "+ driver.manage().logs().getAvailableLogTypes().toString());

    List<LogEntry> entries = driver.manage().logs().get(LogType.PERFORMANCE).getAll();
    LOG.info(entries.size() + " " + LogType.PERFORMANCE + " log entries found");
    for (LogEntry entry : entries) {
      if (entry.toString().contains("/i/api/1.1/promoted_content/log.json")) {
        Gson gson = new Gson();

        PromotedLog promotedLog = gson.fromJson(entry.getMessage(), PromotedLog.class);
        if (promotedLog.getMessage().getParams().getRequest() != null) {
          try {
            LOG.info("promotedLog : " + URLDecoder.decode(promotedLog.getMessage().getParams().getRequest().getPostData(), "UTF-8"));
          } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
          }
        }
      }

    }
  }
}
