package com.parthsuresh.alfred.WolframAPI;

import com.wolfram.alpha.WAEngine;
import com.wolfram.alpha.WAException;
import com.wolfram.alpha.WAPlainText;
import com.wolfram.alpha.WAPod;
import com.wolfram.alpha.WAQuery;
import com.wolfram.alpha.WAQueryResult;
import com.wolfram.alpha.WASubpod;

/*
 * The program performs a query given on the command line and prints out the resulting
 * pod titles and plaintext content.
 *
 * You will need to insert your appid into the code.
 *
 *     commons-codec-1.3.jar
 *     httpclient-4.0.1.jar
 *     httpcore-4.0.1.jar
 *     commons-logging.jar
 */

public class WolframAPI {

    // PUT YOUR APPID HERE:
    private static String appid = "XXXX";

    public static String main(String args) {

        // Use "pi" as the default query.
        String input = args;
        String output = "";

        // The WAEngine is a factory for creating WAQuery objects,
        // and it also used to perform those queries. You can set properties of
        // the WAEngine (such as the desired API output format types) that will
        // be inherited by all WAQuery objects created from it. Most applications
        // will only need to crete one WAEngine object, which is used throughout
        // the life of the application.
        WAEngine engine = new WAEngine();

        // These properties will be set in all the WAQuery objects created from this WAEngine.
        engine.setAppID(appid);
        engine.addFormat("plaintext");

        // Create the query.
        WAQuery query = engine.createQuery();

        // Set properties of the query.
        query.setInput(input);

        try {
            // Store the URL we are about to send:
            output += "Query URL:\n";
            output += engine.toURL(query);
            output += "\n\n";

            // This sends the URL to the Wolfram|Alpha server, gets the XML result
            // and parses it into an object hierarchy held by the WAQueryResult object.
            WAQueryResult queryResult = engine.performQuery(query);

            if (queryResult.isError()) {
                output += "Query error\n";
                output += "  error code: " + queryResult.getErrorCode() + "\n";
                output += "  error message: " + queryResult.getErrorMessage();
            } else if (!queryResult.isSuccess()) {
                output += "Query was not understood; no results available.";
            } else {
                // Got a result.
                output += "Successful query. Pods follow:\n";
                for (WAPod pod : queryResult.getPods()) {
                    if (!pod.isError()) {
                        output += pod.getTitle() + "\n";
                        output += "------------\n";
                        for (WASubpod subpod : pod.getSubpods()) {
                            for (Object element : subpod.getContents()) {
                                if (element instanceof WAPlainText) {
                                    output += ((WAPlainText) element).getText();
                                    output += "\n";
                                }
                            }
                        }
                        output += "\n";
                    }
                }
            }
        } catch (WAException e) {
            e.printStackTrace();
        }

        return output;

    }

}
