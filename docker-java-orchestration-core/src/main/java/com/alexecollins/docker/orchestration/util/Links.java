package com.alexecollins.docker.orchestration.util;

import com.alexecollins.docker.orchestration.model.Id;
import com.alexecollins.docker.orchestration.model.Link;

import java.util.*;

public final class Links {
    private Links() {
    }

    public static String name(String[] names) {
        if (names == null || names.length == 0) {
            throw new IllegalArgumentException();
        }
        return names(Arrays.asList(names));
    }

    private static String names(List<String> names) {
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        return names.get(0);
    }

    public static List<Id> ids(List<Link> links) {
        List<Id> ids = new ArrayList<Id>();
        for (Link link : links) {
            ids.add(link.getId());
        }
        return ids;
    }
}
