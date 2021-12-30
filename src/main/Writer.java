package main;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import common.Constants;
import database.Child;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Writer {

  private JSONArray output;

  public void addToOutput(ArrayList<Child> children) {
    ObjectMapper objectMapper = new ObjectMapper();
    ArrayNode arrayNode = objectMapper.valueToTree(children);
    JsonNode jsonNode = objectMapper.createObjectNode().set("children",arrayNode);
    output.add(jsonNode);
  }

  public Writer() {
    this.output = new JSONArray();
  }

  public void writeJSON(String test) {
    ObjectMapper objectMapper = new ObjectMapper();

    File dir = new File("output");
    if (!dir.exists()) {
      dir.mkdir();
    }
    JSONObject object = new JSONObject();
    object.put("annualChildren", output);
    File out = new File(Constants.OUTPUT_PATH + test + Constants.FILE_EXTENSION);
    try {
      objectMapper.writerWithDefaultPrettyPrinter().writeValue(out, object);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
