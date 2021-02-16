package io.github.NolzCoding.Untils.JSON;

import java.util.List;
import java.util.Objects;

public class JSONSearch {

    private final List<JSONFileParent> jsonFiles;

    public JSONSearch(List<JSONFileParent> jsonFiles) {
        this.jsonFiles = jsonFiles;
    }

    public List<JSONFileParent> getJsonFiles() {
        return jsonFiles;
    }
}
