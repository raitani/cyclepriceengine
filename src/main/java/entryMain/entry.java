/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entryMain;

import Price.PriceEngine;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import util.priceEngineUtil;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author harsh
 */
public class entry {
    private static JSONArray enquiry = null;

	private static String readInput(String filePath) {
		StringBuilder contentBuilder = new StringBuilder();

		try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
			stream.forEach(s -> contentBuilder.append(s).append("\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return contentBuilder.toString();
	}

	public static void main(String[] args) {
		String thisPath = priceEngineUtil.filePath + "bicycle.json";

		String result = readInput(thisPath);

		try {

			enquiry = new JSONArray(result);

		} catch (JSONException e) {
			e.printStackTrace();
		}

		PriceEngine priceEngine = new PriceEngine(enquiry);
		priceEngine.calculatePrice();

		System.out.println("write to output folder");
	}
}
