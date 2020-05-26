package com.twitter.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MockUtils {


  public static void mockHomeTimeline(String path_to_mocked_json) {
//    new MockServerClient("127.0.0.1", 1080)
//        .when(
//            request()
//                .withMethod("GET")
//                .withPath("https://twitter.com/i/api/2/timeline/home.json.*"))
//        .respond(
//            response()
//                .withBody(loadMockJson(path_to_mocked_json))
//        );
  }



  private static String loadMockJson(String file) {
    JSONParser parser = new JSONParser();
    JSONObject jsonObject = null;
    try {
      Object obj = parser.parse(new FileReader(file));
      jsonObject = (JSONObject) obj;
      System.out.println(jsonObject);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException | ParseException e) {
      e.printStackTrace();
    }
    return jsonObject.toJSONString();
  }

}


