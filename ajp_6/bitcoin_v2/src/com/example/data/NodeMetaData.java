package com.example.data;

public class NodeMetaData {
    private String node_name;
    private String node_type;

    public NodeMetaData(String node_name, String node_type) {
        this.node_name = node_name;
        this.node_type = node_type;
    }

    public String getNode_name() {
        return node_name;
    }

    public String getNode_type() {
        return node_type;
    }
}
