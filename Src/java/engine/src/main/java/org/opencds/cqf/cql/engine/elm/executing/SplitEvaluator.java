package org.opencds.cqf.cql.engine.elm.executing;

import org.apache.commons.lang3.StringUtils;
import org.opencds.cqf.cql.engine.exception.InvalidOperatorArgument;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Split(stringToSplit String, separator String) List<String>

The Split operator splits a string into a list of strings using a separator.
If the stringToSplit argument is null, the result is null.
If the stringToSplit argument does not contain any appearances of the separator,
  the result is a list of strings containing one element that is the value of the stringToSplit argument.
*/

public class SplitEvaluator {

    public static Object split(Object stringToSplit, Object separator) {
        if (stringToSplit == null) {
            return null;
        }

        if (stringToSplit instanceof String) {
            List<Object> result = new ArrayList<>();
            if (separator == null) {
                result.add(stringToSplit);
            }
            else {
                Collections.addAll(result, StringUtils.split(((String) stringToSplit), (String) separator));
            }
            return result;
        }

        throw new InvalidOperatorArgument(
                "Split(String, String)",
                String.format("Split(%s, %s)", stringToSplit.getClass().getName(), separator.getClass().getName())
        );
    }
}
