package com.gdg.sofia.android.decorating.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import android.content.res.AssetManager;
import android.util.Log;

/**
 * A class providing helper methods for input / output.
 *
 * @author Boris Strandjev
 */
public class IOHelper {
    private static final String TAG = IOHelper.class.getSimpleName();
    private static final String ENCODING = "UTF-8";

    /**
     * Construct a string form the contents of input stream. Also closes the stream.
     *
     * @param stream the input stream which will be read.
     * @return The string contents of the input stream or null if error occurred.
     */
    public static String getInputStreamContents(InputStream stream) {
        StringBuilder builder = new StringBuilder();
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(stream, ENCODING));
            String line;
            boolean first = true;
            while ((line = in.readLine()) != null) {
                if (!first) {
                    builder.append("\n");
                }
                first = false;
                builder.append(line);
            }

        } catch (UnsupportedEncodingException e) {
            Log.e(TAG, "Unrecognised encoding when reading stream", e);
        } catch (IOException e) {
            Log.e(TAG, "Problem with reading input stream", e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    Log.e(TAG, "Problem with closing input stream that was to be read from");
                }
            }
        }

        String contents = (builder != null) ? builder.toString() : "";
        return contents;
    }

    /**
     * Fetches the contents of given asset file.
     *
     * @param assets The asset manager in which to search the file for.
     * @param fileName The name of the file for which to fetch the contents.
     * @return The string contents of the file or null if error occurred.
     */
    public static String getAssetFileContents(AssetManager assets, String fileName) {
        String contents = null;
        try {
            InputStream assetStream = assets.open(fileName);
            contents = getInputStreamContents(assetStream);
        } catch (IOException e) {
            Log.e(TAG, "Error while opening the asset file " + fileName, e);
        }
        return contents;
    }

}
