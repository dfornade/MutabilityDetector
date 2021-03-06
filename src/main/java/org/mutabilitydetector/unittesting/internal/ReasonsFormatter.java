package org.mutabilitydetector.unittesting.internal;

/*
 * #%L
 * MutabilityDetector
 * %%
 * Copyright (C) 2008 - 2014 Graham Allan
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */



import static java.lang.String.format;

import java.util.Collection;

import org.mutabilitydetector.MutableReasonDetail;

public final class ReasonsFormatter {
    private ReasonsFormatter() { }
    
    private static String formatReasons(Collection<MutableReasonDetail> reasons, StringBuilder builder) {
        for (MutableReasonDetail reason : reasons) {
            builder.append(formatSingleReason(reason));
        }
        return builder.toString();
    }

    public static String formatSingleReason(MutableReasonDetail reason) {
        return format("        %s %s%n", reason.message(), reason.codeLocation().prettyPrint());
    }
    
    public static String formatReasons(Collection<MutableReasonDetail> reasons) {
        return formatReasons(reasons, new StringBuilder());
    }
}
